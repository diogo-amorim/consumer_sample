package net.apmoller.crb.gcd.microservices.eventstream.integration.events.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface IntegrationEventStream {
	
//	static final String GCSS_CHANNEL_NAME = "gcssinputchannel";
	
/*	static final String RKEM_CHANNEL_NAME = "rkeminputchannel";
	
	static final String GSS_OUTPUT_CHANNEL = "gcssoutputchannel";
	
	static final String RKEM_OUTPUT_CHANNEL = "rkemoutputchannel";
	
	static final String AUDIT_EVENT_OUTPUT_CHANNEL = "auditeventoutputchannel";

	static final String APP_AUDIT_OUTPUT_CHANNEL = "appauditeventoutputchannel";*/

	
    String GMS_INPUT_CHANNEL = "gmsinputchannel";

	String GCSS_INPUT_CHANNEL = "gcssinputchannel";

	String GCSS_OUTPUT_CHANNEL = "gcsseventputputchannel";
    
	String DATEDSCHEDULE_EVENT_OUTPUT_CHANNEL = "datedscheduleeventoutputchannel";
	
	String DATED_SCHEDULE_EVENT_INPUT_CHANNEL = "gsisdatedscheduleinputchannel";
	
	String DATED_SCHEDULE_EVENT_ERROR_CHANNEL = "gsisdatedscheduleerrorchannel";
	
	String GCSS_ERROR_CHANNEL = "gcsseventerrorchannel";
	
	String GMS_ERROR_CHANNEL = "gmserrorchannel";
	
//	String LOAD_STATUS_EVENT_OUTPUT_CHANNEL = "loadstatusoutputchannel";
		
	//String PORTCALL_OUTPUT_CHANNEL = "portcalloutputchannel";

	
//	@Input(GCSS_CHANNEL_NAME)
//	SubscribableChannel gcsssinputchannel();
	
	
/*	@Input(RKEM_CHANNEL_NAME)
	SubscribableChannel rkeminputchannel();
	
	@Output(GSS_OUTPUT_CHANNEL)
	MessageChannel gcssoutputchannel();
	
	@Output(RKEM_OUTPUT_CHANNEL)
	MessageChannel rkemoutputchannel();
	
	@Output(AUDIT_EVENT_OUTPUT_CHANNEL)
	MessageChannel auditeventoutputchannel();
	
	@Output(APP_AUDIT_OUTPUT_CHANNEL)
	MessageChannel appauditeventoutputchannel();*/
	
//	@Output(OUTPUT_CHANNEL)
//	MessageChannel outboundchannel();
	
	@Input(GMS_INPUT_CHANNEL)
 	SubscribableChannel gmsinboundchannel();

	@Input(GCSS_INPUT_CHANNEL)
	SubscribableChannel gcssinboundchannel();
	
	@Output(DATEDSCHEDULE_EVENT_OUTPUT_CHANNEL)
	MessageChannel datedscheduleeventoutboundchannel();

	@Output(GCSS_OUTPUT_CHANNEL)
	MessageChannel gcssoutputchannel();
	
	@Input(DATED_SCHEDULE_EVENT_INPUT_CHANNEL)
	SubscribableChannel datedscheduleeventinboundchannel();
	
	@Output(GCSS_ERROR_CHANNEL)
	MessageChannel gcsserroroutboundchannel();
	
	@Output(DATED_SCHEDULE_EVENT_ERROR_CHANNEL)
	MessageChannel gsiserroroutboundchannel();
	
	@Output(GMS_ERROR_CHANNEL)
	MessageChannel gmserroroutboundchannel();
	
//	@Output(LOAD_STATUS_EVENT_OUTPUT_CHANNEL)
//	MessageChannel loadstatusoutputchannel();
	
	/*@Output(PORTCALL_OUTPUT_CHANNEL)
	MessageChannel portcalloutboundchannel();*/
	
}