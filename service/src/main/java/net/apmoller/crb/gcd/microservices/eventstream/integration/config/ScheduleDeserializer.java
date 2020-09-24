package net.apmoller.crb.gcd.microservices.eventstream.integration.config;

import org.apache.avro.Schema;

import io.confluent.kafka.schemaregistry.client.MockSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule;

public class ScheduleDeserializer extends KafkaAvroDeserializer {
	@Override
	public Object deserialize(String topic, byte[] bytes) {
		this.schemaRegistry = getMockClient(datedSchedule.SCHEMA$);
		return super.deserialize(topic, bytes);
	}

	private static SchemaRegistryClient getMockClient(final Schema schema$) {
		return new MockSchemaRegistryClient() {
			@Override
			public synchronized Schema getById(int id) {
				return schema$;
			}
		};
	}
}
