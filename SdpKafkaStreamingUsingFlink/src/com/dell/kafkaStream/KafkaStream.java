package com.dell.kafkaStream;

import java.util.Arrays;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.sink.KafkaRecordSerializationSchema;
import org.apache.flink.connector.kafka.sink.KafkaSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import static com.dell.kafkaStream.AppConfig.*;

public class KafkaStream {

	public static void streamDataUsingKafka() {

		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		try {

			// Kafka source to read stream from kafka topic
			KafkaSource<String> source = KafkaSource.<String>builder().setBootstrapServers(brokers)
					.setTopics(Arrays.asList(inputTopics)).setGroupId(consumerGroup)
					.setProperty("commit.offsets.on.checkpoint", "true").setProperty("enable.auto.commit", "true")
					.setStartingOffsets(OffsetsInitializer.earliest())
					.setValueOnlyDeserializer(new SimpleStringSchema())
					.setDeserializer(KafkaRecordDeserializationSchema.valueOnly(new SimpleStringSchema()))
					.setProperty("ssl.truststore.location", "path-to-kafka-trustsore")
					.setProperty("ssl.truststore.password", password)
					.setProperty("ssl.keystore.location", "path-to-kafka-keystore")
					.setProperty("ssl.keystore.password", password).build();

			DataStream<String> stream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka_Source");
			stream.print();

			// Kafka sink to write stream to kafka topic
			KafkaRecordSerializationSchema<String> serializer = KafkaRecordSerializationSchema.builder()
					.setValueSerializationSchema(new SimpleStringSchema()).setTopic(outputTopic).build();

			KafkaSink<String> sink = KafkaSink.<String>builder().setBootstrapServers(brokers)
					.setRecordSerializer(serializer).build();

			stream.sinkTo(sink);

			env.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String args[]) {
		streamDataUsingKafka();
	}
}
