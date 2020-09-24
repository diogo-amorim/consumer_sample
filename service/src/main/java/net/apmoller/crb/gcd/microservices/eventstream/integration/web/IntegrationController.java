package net.apmoller.crb.gcd.microservices.eventstream.integration.web;

import lombok.extern.slf4j.Slf4j;
import net.apmoller.crb.gcd.microservices.eventstream.integration.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.listener.IntegrationEventStream;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.AdvanceManifestEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.DatedScheduleEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.processor.EventProcessor;
import net.apmoller.crb.gcd.microservices.eventstream.integration.service.FileProcessorService;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/gcd/producer")
@Slf4j
public class IntegrationController {

	/*@Autowired
	private IntegrationEventStream gcdEventStream;*/

	@Autowired
	private FileProcessorService fileProcessorService;
	
	@Autowired
	private EventProcessor eventProcessor;


	@Autowired
	private BookingRepository bookingRepository;

	@GetMapping("/getBySegmentId/{segmentId}")
	public Mono<Long> getMapping(@PathVariable String segmentId){
		return bookingRepository.countBookingSegmentById_SegmentId(segmentId);
	}

	/*@Autowired
	private Tracer tracer;*/

	/*@PostMapping("/events/booking")
	public ResponseEntity<?> produceMessage(@RequestBody Booking payload) {

		Message<Booking> message = MessageBuilder.withPayload(payload)
				.setHeader("eventId", "EventProducer." + UUID.randomUUID().toString())
				.setHeader("eventType", IntegrationConstants.BOOKING_EVENT)
				.setHeader("traceId", UUID.randomUUID().toString())
				.setHeader("eventTimeStamp", ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT)).build();
		this.gcdEventStream.gcssoutputchannel().send(message);
		log.info("Published event to Kafka event hub successfully!!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/events/empty")
	public ResponseEntity<?> produceMessage(@RequestBody EmptyContainer payload) {

		Message<EmptyContainer> message = MessageBuilder.withPayload(payload)
				.setHeader("eventId", "EventProducer." + UUID.randomUUID().toString())
				.setHeader("eventType", IntegrationConstants.EMPTYCONTAINER_EVENT)
				.setHeader("traceId", UUID.randomUUID().toString())
				.setHeader("eventTimeStamp", ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT)).build();
		this.gcdEventStream.rkemoutputchannel().send(message);
		log.info("Published event to Kafka event hub successfully!!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/events/applicationaudit")
	public ResponseEntity<?> produceMessage(@RequestBody ApplicationAuditEvent payload) {
		String traceId = tracer.currentSpan().context().traceIdString();
		log.info("produceMessage for Application audit" + "TRACEID: " + traceId);

		Message<ApplicationAuditEvent> message = MessageBuilder.withPayload(payload)
				.setHeader("eventId", "EventProducer." + UUID.randomUUID().toString())
				.setHeader("eventType", IntegrationConstants.SERVICE_EVENT).setHeader("traceId", traceId)
				.setHeader("eventTimeStamp", ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
				.setHeader("source", "tpdocservice").build();
		this.gcdEventStream.appauditeventoutputchannel().send(message);
		log.info("Published event to Kafka event hub successfully!!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}*/
	
    @PostMapping("/events/gmstogcd")
	public ResponseEntity<?> produceMessage(@RequestBody AdvanceManifestEvent payload) {
		//String traceId = tracer.currentSpan().context().traceIdString();
		//String timeStamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
		
		String eventType = payload.getManifest().getMessageHeader().getEventName();
		log.info("produceMessage >>" + " message payload :: "+payload.getManifest().getAdvanceManifest().toString());
		log.info("produceMessage >> eventType: {}", eventType);		
		
		Message<AdvanceManifestEvent> message = MessageBuilder.withPayload(payload)
				.setHeader(IntegrationConstants.EVENT_TYPE, "AdvanceManifestationEvent")
				.setHeader("source", "GMS").build();		    
//	    this.gcdEventStream.outboundchannel().send(message);
		log.info("Published event to EMP Kafka successfully!!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	
	@PostMapping("/events/datedschedules")
	public ResponseEntity<?> produceMessage(@RequestBody DatedScheduleEvent portCallPayload) {
		String eventType = portCallPayload.getTransportSchedule().getMessageHeader().getEventName();
		log.info("produceMessage >> eventType: {}", eventType);		
		log.info("produceMessage >>" + " message payload :: "+portCallPayload.toString());
		Message<DatedScheduleEvent> message = MessageBuilder.withPayload(portCallPayload)
				.setHeader(IntegrationConstants.EVENT_TYPE, eventType)
				.build();
		Result result = eventProcessor.process(portCallPayload, eventType);
		log.info("publish Flag-->produceMessage ::{}", result);
	    //this.gcdEventStream.datedscheduleeventoutboundchannel().send(message);
	    log.info("Published event to kafka event hub successfully!!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
/*
	@PostMapping(value = "/customs/outbound", consumes = "multipart/form-data", produces = "application/json")
	public void uploadFiles(@RequestParam("files") MultipartFile[] files) {
        
		for(MultipartFile file : files){
		log.info("uploadFiles-->file name recieved "+file.getOriginalFilename());
		}
		
		BlobContainerAsyncClient blobContainerAsyncClient = azureAsyncBeanConfig.blobContainerAsyncClient();
		boolean containerExists = blobContainerAsyncClient.exists().block();
		if(!containerExists){
			blobContainerAsyncClient.create().block();
		}
		BlobAsyncClient blobClient = blobContainerAsyncClient.getBlobAsyncClient("outbound");
		Arrays.stream(files).map(x -> {
			Boolean flag = true;
			try {
				Flux<ByteBuffer> data = Flux.just(ByteBuffer.wrap(x.getBytes()));
				blobClient.upload(data, new ParallelTransferOptions(blockSize, numBuffers, null)).b
						.subscribe(response -> log.info("Uploaded BlockBlob MD5 is %s%n",
								Base64.getEncoder().encodeToString(response.getContentMd5())));
			} catch (IOException e) {
				flag = false;
				log.error("flag::"+flag+" Exception::"+e);
			}
			return flag;
		});
	}*/
	
	@PostMapping(value = "/customs/outbound", consumes = "multipart/form-data", produces = "application/json")
	public void uploadFiles(@RequestParam("files") MultipartFile[] files) throws Exception {

		fileProcessorService.saveFiles(files);
		fileProcessorService.uploadToBlobStorage(files);
		fileProcessorService.deleteFilesInDirectory();
	}
	
	
	@PostMapping(value = "/customs/inbound", produces = "application/json")
	public void getBlobs() throws Exception {
		fileProcessorService.processInboundBlobs();
	}
}
