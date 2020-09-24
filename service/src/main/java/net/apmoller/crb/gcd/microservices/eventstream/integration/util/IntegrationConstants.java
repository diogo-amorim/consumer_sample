package net.apmoller.crb.gcd.microservices.eventstream.integration.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Getter
@Setter
public final class IntegrationConstants {

    @Value("${gcd.billoflading.baseUri}")
    private String billofladingBaseURI;
	@Value("${gcd.billoflading.getBolEndpoint}")
	private String bolGetEndpoint;

    private IntegrationConstants() {
    }

    public static final String EVENT_TYPE = "eventType";
    public static final String BOOKING_EVENT = "bookingEvent";
    public static final String EMPTYCONTAINER_EVENT = "emptyContainerEvent";
    public static final String INTEGRATION_EVENT = "integrationEvent";
    public static final String SERVICE_EVENT = "serviceEvent";
    public static final String COMPLIANCE_API_BASEURL = "https://gcd-compliance-service.azurewebsites.net";
    public static final String TPDOC_API_BASEURL = "https://gcd-transportation-document-service-1573640263691.azurewebsites.net";
    public static final String TPDOC_URL = "/tpdoc";
    public static final String EMPTY_TPDOC_URL = "/tpdoc/empty";
    public static final String COMPLIANCE_URL = "/v1/compliance";
    public static final String OUTBOUND_UPLOAD_LOC = "./tmp/outbounduploads/";
    public static final String INBOUND_DOWNLOAD_LOC = "/tmp/inbounddownloads/";
    public static final String DATA_UPDATE_ERROR = "There was some problem while updating the data.";
    public static final List<String> GSIS_EXCLUDED_EVENT_LIST = Arrays.asList("VesselDatedScheduleVesselArrived", "VesselDatedSchedulePilotOnBoard",
            "VesselDatedSchedulePilotoffBoard", "VesselDatedScheduleArrivalAtPilotStation", "VesselDatedScheduleCommentsUpdated",
            "VesselDatedScheduleVesselDeparted", "VesselDatedScheduleUnOmitted");
	public static final String X_APP_ID_KEY = "X-APP-ID";
	public static final String X_APP_ID_VALUE = "GCD";
	public static final String X_API_KEY_KEY = "X-API-KEY";
	public static final String X_API_KEY_VALUE = "69ba14f0-2edb-4b87-96ca-789125790b09";

}
