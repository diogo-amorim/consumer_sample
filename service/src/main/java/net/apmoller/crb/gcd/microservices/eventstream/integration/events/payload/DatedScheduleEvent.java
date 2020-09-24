package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.SiteCallStatus;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler.EventHandler;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler.EventToHandlerMapper;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.actual;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.arrivalVoyage;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.currentPortCall;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.departureVoyage;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.nextPortCall;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.previousPortCall;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.scheduleEntryID;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.service;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.vessel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Log4j2
@Component
public class DatedScheduleEvent extends BaseEvent {

	@JsonProperty("TransportSchedule")
	private TransportSchedule transportSchedule;

	public static DatedScheduleEvent getDatedScheduleEvent(Message<?> message, String eventName,
			datedSchedule schedule) {
		MessageHeader messageHeader = new MessageHeader();
		messageHeader.setCorrelationId(new String((byte[]) message.getHeaders().get("correlationID")));
		messageHeader.setEventName(eventName);
		messageHeader.setTraceId(messageHeader.getCorrelationId());
		messageHeader.setMessageGeneratedTimestamp(DateTime.now());
		messageHeader.setMessageId(new String((byte[]) message.getHeaders().get("messageID")));
		messageHeader.setCausationId(new String((byte[]) message.getHeaders().get("causationID")));
		List<ScheduleEntry> scheduleEntries = schedule.getScheduleEntries().getScheduleEntry().stream().map(e -> {
			ScheduleEntry entry = new ScheduleEntry();
			entry.setDummyCall(false);
			String notes = e.getNotes() != null ? e.getNotes().toString() : null;
			String omitReason = e.getOmitReason() != null ? e.getOmitReason().toString() : null;
			RotationDetails rd = new RotationDetails();
			rd.setRotationId(e.getRotationId().toString());
			rd.setRotationName(e.getRotationName().toString());
			rd.setRotationVersion(e.getRotationVersion().toString());
			Schedule s = new Schedule();
			s.setProformaArrival(e.getSchedule().getProformaArrival().toString());
			s.setProformaDeparture(e.getSchedule().getProformaDeparture().toString());
			s.setScheduledArrival(e.getSchedule().getScheduledArrival().toString());
			s.setScheduledDeparture(e.getSchedule().getScheduledDeparture().toString());
			ScheduleEntryID scheduleEntryID = getScheduledEntry(e.getScheduleEntryID());
			entry.setNotes(notes);
			entry.setOmitReason(omitReason);
			entry.setRotationDetails(rd);
			entry.setSchedule(s);
			entry.setScheduleEntryID(scheduleEntryID);
			if (e.getSiteCallStatus() == null || e.getSiteCallStatus().toString() == ""
					|| e.getSiteCallStatus().toString().isEmpty()) {
				entry.setSiteCallStatus(SiteCallStatus.EMPTY);
			} else if (e.getSiteCallStatus().toString().equals("ARRIVAL HAS BEEN ACTUALIZED")) {
				entry.setSiteCallStatus(SiteCallStatus.ARRIVAL_HAS_BEEN_ACTUALIZED);
			} else
				entry.setSiteCallStatus(SiteCallStatus.valueOf(e.getSiteCallStatus().toString()));
			if (e.getActual() != null) {
				actual a = e.getActual();
				Actual actual = new Actual();
				if (a.getActualArrival() != null)
					actual.setActualArrivalDate(a.getActualArrival().toString());
				if (a.getActualDeparture() != null) {
					actual.setActualDepartureDate(a.getActualDeparture().toString());
				}
				if (a.getArrivalAtPilotStation() != null) {
					actual.setArrivalAtPilotStation(a.getArrivalAtPilotStation().toString());
				}
				if (a.getPilotOff() != null) {
					actual.setPilotOff(a.getPilotOff().toString());
				}
				if (a.getFirstPilotOnBoard() != null) {
					actual.setFirstPilotOnBoard(a.getFirstPilotOnBoard().toString());
				}
				entry.setActual(actual);
			}
			return entry;
		}).collect(Collectors.toList());
		TransportSchedule transportSchedule = TransportSchedule.builder().messageHeader(messageHeader)
				.scheduleEntries(ScheduleEntries.builder().scheduleEntry(scheduleEntries).build()).build();
		return DatedScheduleEvent.builder().transportSchedule(transportSchedule).build();
	}

	private static ScheduleEntryID getScheduledEntry(scheduleEntryID se) {
		arrivalVoyage a = se.getScheduleEntryIdentifier().getArrivalVoyage();
		currentPortCall cp = se.getScheduleEntryIdentifier().getCurrentPortCall();
		departureVoyage dv = se.getScheduleEntryIdentifier().getDepartureVoyage();
		nextPortCall np = se.getScheduleEntryIdentifier().getNextPortCall();
		previousPortCall pc = se.getScheduleEntryIdentifier().getPreviousPortCall();
		service s = se.getScheduleEntryIdentifier().getService();
		vessel v = se.getScheduleEntryIdentifier().getVessel();
		ArrivalVoyage arrivalVoyage = ArrivalVoyage.builder().direction(a.getDirection().toString())
				.transportMode(a.getTransportMode().toString()).voyage(a.getVoyage().toString()).build();
		CurrentPortCall currentPortCall = CurrentPortCall.builder().cityCode(cp.getCityCode().toString())
				.cityName(cp.getCityName().toString()).geoCode(cp.getGeoCode().toString())
				.terminalCode(cp.getTerminalCode().toString()).terminalName(cp.getTerminalName().toString()).build();
		DepartureVoyage departureVoyage = DepartureVoyage.builder().direction(dv.getDirection().toString())
				.transportMode(dv.getTransportMode().toString()).voyage(dv.getVoyage().toString()).build();
		NextPortCall nextPortCall = NextPortCall.builder().cityCode(np.getCityCode().toString())
				.cityName(np.getCityName().toString()).geoCode(np.getGeoCode().toString())
				.terminalCode(np.getTerminalCode().toString()).terminalName(np.getTerminalName().toString()).build();
		PreviousPortCall previousPortCall = PreviousPortCall.builder().cityCode(pc.getCityCode().toString())
				.cityName(pc.getCityName().toString()).geoCode(pc.getGeoCode().toString())
				.terminalCode(pc.getTerminalCode().toString()).terminalName(pc.getTerminalName().toString()).build();
		Service service = Service.builder().code(s.getCode().toString()).name(s.getName().toString()).build();
		Vessel vessel = Vessel.builder().imoNumber(v.getIMONumber().toString())
				.vesselCallSign(v.getVesselCallSign().toString()).vesselCode(v.getVesselCode().toString())
				.vesselFlag(v.getVesselFlag().toString()).vesselName(v.getVesselName().toString())
				.vesselOperatorCode(v.getVesselOperatorCode().toString()).build();
		ScheduleEntryIdentifier scheduleEntryIdentifier = ScheduleEntryIdentifier.builder().arrivalVoyage(arrivalVoyage)
				.currentPortCall(currentPortCall).departureVoyage(departureVoyage).nextPortCall(nextPortCall)
				.previousPortCall(previousPortCall).service(service).vessel(vessel).build();
		return ScheduleEntryID.builder().scheduleEntryIdentifier(scheduleEntryIdentifier)
				.scheduleEntryKey(se.getScheduleEntryKey().toString()).build();
	}

	@Override
	public Result handle(EventToHandlerMapper handlerMapper) {
		EventHandler eventHandler = handlerMapper.map(this);
		return eventHandler.handle(this);
	}

}
