package net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import net.apmoller.crb.gcd.microservices.eventstream.integration.api.client.LocationApiClient;
import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.Timezone;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.BaseEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.DatedScheduleEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.EventHeader;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.GcdDatedScheduleEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.MessageHeader;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.PortCall;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.PortCallPayload;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.PortCalls;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.ScheduleEntry;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.publisher.EventPublisher;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;

@Service
@Log4j2
public class DatedScheduleEventHandler implements EventHandler {

	@Autowired
	private EventPublisher eventPublisher;

	@Autowired
	private LocationApiClient locationClient;

	public Result handle(BaseEvent event) {
		log.info("DatedScheduleEventHandler>> handle");
		DatedScheduleEvent datedScheduleEvent = (DatedScheduleEvent) event;
		List<PortCall> portCallList = new ArrayList<>();
		List<ScheduleEntry> scheduleEntryList = datedScheduleEvent.getTransportSchedule().getScheduleEntries()
				.getScheduleEntry();
		if (!scheduleEntryList.isEmpty()) {
			scheduleEntryList.stream().forEach(scheduleEntry -> {
				PortCall portCall = buildPortCall(scheduleEntry);
				log.info("Adding PortCall to the list ::{}", portCall.toString());
				portCallList.add(portCall);
			});
		}

		Message<GcdDatedScheduleEvent> gcdDatedScheduleEvent = buildEvent(portCallList,
				datedScheduleEvent.getTransportSchedule().getMessageHeader());

		log.info("gcdDatedScheduleEvent before sending to eventHub:: {}", gcdDatedScheduleEvent.toString());

		boolean publish = eventPublisher.publishDatedScheduleEvent(gcdDatedScheduleEvent);
		log.info("publish Flag ::{}", publish);
		return publish ? Result.PROCESSED : Result.FAILED;

	}

	private PortCall buildPortCall(ScheduleEntry scheduleEntry) {
		int offset = 0;
		String cityCode = scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getCurrentPortCall()
				.getCityCode();
		try {
			if (cityCode != null && cityCode.trim().length() > 5) {
				cityCode = cityCode.substring(0, 5);
			}
			if (cityCode == null) {
				String siteCode = scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getCurrentPortCall()
						.getTerminalCode();
				cityCode = siteCode.trim().substring(0, 5);
			}
			if (cityCode != null) {
				Timezone timezone = locationClient.getTimezone(cityCode).block();
				log.info("Timezone: " + timezone);
				int index = -1;
				if ((index = timezone.getUtcOffsetMins().indexOf(".")) != -1) {
					offset = Integer.parseInt(timezone.getUtcOffsetMins().substring(0, index));
				} else {
					offset = Integer.parseInt(timezone.getUtcOffsetMins());
				}
			}
			log.info("offset: " + offset);
		} catch (Exception ex) {
			log.warn("Error getting timestamp offset: " + ex.getMessage());
			offset = 0;
		}
		PortCall portCall = PortCall.builder().gsisKey(scheduleEntry.getScheduleEntryID().getScheduleEntryKey())
				.previousSiteCode(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getPreviousPortCall()
						.getTerminalCode())
				.nextSiteCode(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getNextPortCall()
						.getTerminalCode())
				.arrivalVoyageTransportMode(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier()
						.getArrivalVoyage().getTransportMode())
				.departureVoyageTransportMode(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier()
						.getDepartureVoyage().getTransportMode())
				.vesselCode(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getVessel().getVesselCode())
				.vesselOperatorCode(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getVessel()
						.getVesselOperatorCode())
				.vesselName(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getVessel().getVesselName())
				.vesselFlagCode(
						scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getVessel().getVesselFlag())
				.siteRkstCode(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getCurrentPortCall()
						.getTerminalCode())
				.siteName(scheduleEntry
						.getScheduleEntryID().getScheduleEntryIdentifier().getCurrentPortCall().getTerminalName())
				.cityCode(cityCode)
				.city(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getCurrentPortCall()
						.getCityName())
				.arrivalServiceCode(
						scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getService().getCode())
				.departureServiceCode(
						scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getService().getCode())
				.arrivalVoyageCode(
						scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getArrivalVoyage().getVoyage())
				.arrivalDirection(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getArrivalVoyage()
						.getDirection())
				.departureVoyageCode(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier()
						.getDepartureVoyage().getVoyage())
				.departureDirection(scheduleEntry.getScheduleEntryID().getScheduleEntryIdentifier().getDepartureVoyage()
						.getDirection())
				.estimatedArrivalDate(formatDate(offset, scheduleEntry.getSchedule().getScheduledArrival(), cityCode))
				.estimatedDepartureDate(
						formatDate(offset, scheduleEntry.getSchedule().getScheduledDeparture(), cityCode))
				.siteCallStatus(scheduleEntry.getSiteCallStatus()).build();

		if (scheduleEntry.getSchedule().getProformaArrival() != null
				&& scheduleEntry.getSchedule().getProformaDeparture() != null) {
			portCall.setProformaArrivalDate(
					formatDate(offset, scheduleEntry.getSchedule().getProformaArrival(), cityCode));
			portCall.setProformaDepartureDate(
					formatDate(offset, scheduleEntry.getSchedule().getProformaDeparture(), cityCode));
		}

		if (scheduleEntry.getActual() != null) {
			if (scheduleEntry.getActual().getActualArrivalDate() != null)
				portCall.setActualArrivalDate(
						formatDate(offset, scheduleEntry.getActual().getActualArrivalDate(), cityCode));
			if (scheduleEntry.getActual().getActualDepartureDate() != null)
				portCall.setActualDepartureDate(
						formatDate(offset, scheduleEntry.getActual().getActualDepartureDate(), cityCode));
		}
		return portCall;
	}

	private Message<GcdDatedScheduleEvent> buildEvent(List<PortCall> portCallList, MessageHeader messageHeader) {

		EventHeader eventHeader = new EventHeader(messageHeader.getSourceId(),
				messageHeader.getMessageGeneratedTimestamp(), messageHeader.getEventName(),
				messageHeader.getMessageId(), messageHeader.getCorrelationId(), messageHeader.getTraceId());

		PortCallPayload portCallPayload = PortCallPayload.builder()
				.portCalls(PortCalls.builder().portCall(portCallList).build()).build();
		GcdDatedScheduleEvent gcdDatedScheduleEvent = GcdDatedScheduleEvent.builder().eventheader(eventHeader)
				.portCallPayload(portCallPayload).build();

		Message<GcdDatedScheduleEvent> message = MessageBuilder.withPayload(gcdDatedScheduleEvent)
				.setHeader(IntegrationConstants.EVENT_TYPE, messageHeader.getEventName()).build();
		return message;
	}

	private String formatDate(int offset, String date, String cityCode) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		if (date == null || date == "" || date.isEmpty()) {
			return null;
		}
		if (date.endsWith("000Z")) {
			date = date.substring(0, date.length() - 5);
			formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
		}
		if (cityCode.startsWith("FI") || cityCode.startsWith("DK")) {
			String day = date.substring(0, 10);
			offset = calculateNewOffset(offset, day);
		}
		DateTimeFormatter newFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
		try {
			LocalDateTime dt = LocalDateTime.parse(date, formatter);
			DateTime convertedTime = null;
			if (offset < 0) {
				convertedTime = dt.plusMinutes(Math.abs(offset)).toDateTime(DateTimeZone.forID("UTC"));
			} else {
				convertedTime = dt.minusMinutes(offset).toDateTime(DateTimeZone.forID("UTC"));
			}
			String newDate = convertedTime.toString(newFormat);
			log.info("date: " + date);
			log.info("newDate: " + newDate);
			return newDate;
		} catch (Exception ex) {
			log.info("error: " + ex.getMessage(), ex);
			return date;
		}
	}

	private int calculateNewOffset(int offset, String day) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		DateTime current = formatter.parseDateTime(day);
		String dst2020Start = "2020-03-29";
		String dst2020End = "2020-10-25";
		String dst2021Start = "2021-03-28";
		String dst2021End = "2021-10-31";
		DateTime start2020 = formatter.parseDateTime(dst2020Start);
		DateTime end2020 = formatter.parseDateTime(dst2020End);
		DateTime start2021 = formatter.parseDateTime(dst2021Start);
		DateTime end2021 = formatter.parseDateTime(dst2021End);
		if ((current.isAfter(start2020.getMillis()) && current.isBefore(end2020.getMillis()))
				|| (current.isAfter(start2021.getMillis()) && current.isBefore(end2021.getMillis()))) {
			offset += 60;
		}
		return offset;
	}
}
