package net.apmoller.crb.gcd.microservices.eventstream.integration.events.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.apmoller.gcd.gcdcommoncomponents.dtos.BillOfLading;
import com.apmoller.gcd.gcdcommoncomponents.dtos.RouteLink;

import lombok.extern.log4j.Log4j2;
import net.apmoller.crb.gcd.microservices.eventstream.integration.api.client.BolApiClient;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.listener.IntegrationEventStream;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.AdvanceManifest;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.loadstatus.KeySchema;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.loadstatus.LoadStatus;

@Component
@Log4j2
public class ContainerLoadStatusEventPublisher {
	@Autowired
	private IntegrationEventStream integrationEventStream;

	@Autowired
	private BolApiClient client;

	public void publishEvent(AdvanceManifest manifest) {
		log.info("Received loadtype message: " + manifest);
		List<String> containers = null;
		try {
			BillOfLading bol = client.getBillOfLading(manifest.getTransportDocumentNumber()).block();
			containers = bol.getEquipments().stream().map(e -> {
				if (e.getEquipmentNoWhenBooked() != null)
					return e.getEquipmentNoWhenBooked();
				else
					return e.getOperationalEquipmentNumber();
			}).collect(Collectors.toList());
			Optional<RouteLink> link = bol.getShipments().stream()
					.map(s -> s.getRoute().getRouteLinks().stream()
							.filter(r -> r.getRouteEndPoint().getSiteCode().equals(manifest.getDischargePort()))
							.findFirst().orElse(new RouteLink()))
					.findFirst();
			if (link.isPresent() && link.get().getRouteStartPoint() != null) {
				String loadPort = link.get().getRouteStartPoint().getSiteCode();
				log.info("Load Port: " + loadPort);
				manifest.setLoadPort(loadPort);
			}
		} catch (Exception ex) {
			log.warn("Error has occured while fetching container numbers: " + ex.getMessage());
			return;
		}
		if (containers == null || containers.isEmpty()) {
			log.info("No container information found in billoflading '" + manifest.getTransportDocumentNumber() + "'");
		} else {
			manifest.setContainerNumbers(containers);
			log.info("Bill of Lading '" + manifest.getTransportDocumentNumber() + "' has '" + containers.size()
					+ "' containers.");
			log.info("Updated manifest: " + manifest);
		}
		try {
//			LoadStatus loadStatus = buildLoadStatus(manifest);
//			if (integrationEventStream.loadstatusoutputchannel().send(buildLoadStatusEvent(loadStatus))) {
//				log.info("Successfully sent the message.");
//			} else {
//				log.info("There was an issue sending the message");
//			}
		} catch (Exception ex) {
			log.warn("There was some problem in sending loadstatus response: " + ex.getMessage(),ex);
		}

	}

	private Message<LoadStatus> buildLoadStatusEvent(LoadStatus loadStatus) {
		KeySchema schema = new KeySchema();
		schema.setMessageKey(loadStatus.getTransportDocumentNumber());
		Message<LoadStatus> message = MessageBuilder.withPayload(loadStatus).setHeader(KafkaHeaders.MESSAGE_KEY, schema)
				.build();
		return message;
	}

	private LoadStatus buildLoadStatus(AdvanceManifest m) {
		return LoadStatus.newBuilder()
				.setArrivalVoyageNumber(m.getArrivalVoyageNumber() == null ? "" : m.getArrivalVoyageNumber())
				.setComplianceLoadStatus(m.getComplianceLoadStatus() == null ? "" : m.getComplianceLoadStatus())
				.setComplianceReceiverPort(m.getComplianceReceiverPort() == null ? "" : m.getComplianceReceiverPort())
				.setComplianceStatus(m.getComplianceStatus() == null ? "" : m.getComplianceStatus())
				.setCustomsResponseReason(m.getCustomsResponseReason() == null ? "" : m.getCustomsResponseReason())
				.setDepartureVoyageNumber(m.getDepartureVoyageNumber() == null ? "" : m.getDepartureVoyageNumber())
				.setLoadPort(m.getLoadPort() == null ? "" : m.getLoadPort())
				.setDischargePort(m.getDischargePort() == null ? "" : m.getDischargePort())
				.setEntryPortEta(m.getEntryPortEta() == null ? "" : m.getEntryPortEta().toString())
				.setMrnCustomsNumber(m.getMrnCustomsNumber() == null ? "" : m.getMrnCustomsNumber())
				.setSentTimeStamp(m.getSentTimeStamp() == null ? "" : m.getSentTimeStamp().toString())
				.setTransportDocumentNumber(
						m.getTransportDocumentNumber() == null ? "" : m.getTransportDocumentNumber())
				.setVesselCode(m.getVesselCode() == null ? "" : m.getVesselCode())
				.setContainerNumbers(m.getContainerNumbers() == null ? new ArrayList<CharSequence>()
						: new ArrayList<CharSequence>(m.getContainerNumbers()))
				.build();
	}
}
