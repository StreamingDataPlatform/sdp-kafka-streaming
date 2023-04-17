# Connecting External Kafka Instances With Streaming Data Platform
This is a general guide for reading and writing into a Kafka stream from Dell EMC Streaming Data Platform.

## Pre-Requisites
1. External connectivity enabled Dell EMC SDP cluster is required to perform these samples. 
2. A project should be created on SDP UI using the same cluster.
3. There should be a Kafka cluster already running with required brokers and kafka topics which will be used to read and write data. 
4. For these samples, setup of kafka uses the confluent version with single broker and data is being ingested into one of the topics which will be read by the flink/spark applications running on SDP .
5. By default, Kafka is installed with no authentication. Confluent Platform supports the various authentication mechanisms and protocols for Kafka brokers.
6. For these samples, SSL based authentication has been used for a secure connection between kafka cluster and SDP. More details can be found here: https://docs.confluent.io/platform/current/kafka/authentication_ssl.html#encrypt-and-authenticate-with-tls
7. For detailed instructions regarding creating flink and spark application on SDP to connect with external kafka instances, please refer README section for each application.

