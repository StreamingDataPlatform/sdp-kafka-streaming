package com.dell.kafkaStream;

public final class AppConfig {

	private AppConfig() {
	}

	public static final String inputTopics[] = new String[] { "idrac" };
	public static final String outputTopic = "flink-stream";
	public static final String consumerGroup = "flink_kafka_consumer_group";
	public static final String brokers = "kafka-broker"; // kafka connection string is required here
	public static final String password = "password"; // correct password for kafka broker

}
