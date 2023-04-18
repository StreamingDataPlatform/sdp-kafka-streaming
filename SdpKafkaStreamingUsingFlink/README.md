# Flink application example to read and write to kafka streams from SDP

This code sample demonstrates the capabilities of flink application created on SDP that can be used to read data from one kafka topic and write to another kafka topic.

## Dependencies
* Refer dependencies section in pom.xml

## Deployment

1. Create a project on SDP and upload the maven dependencies artifacts.
    - Git clone the repository for [SdpKafkaStreamingUsingFlink](https://github.com/)   
    - Use `maven` to build the artifacts
```console
 mvn clean package
```
    - Use `maven` to build the artifacts
2. Upload the jar through UI in SDP
3.  Go to Artifactory tab under your project in SDP UI and upload the above jar created above.
![image](https://user-images.githubusercontent.com/125700236/232898695-8cb9411c-3e4f-477c-ae82-a379b4c9af5e.png)

4.  Go to Flink tab under your project in SDP UI
 ![image](https://user-images.githubusercontent.com/125700236/232898799-49f66885-da40-47f1-baf5-27f5e3ed4604.png)

5. Click on tab "Clusters" under Flink and create a flink cluster.
![image](https://user-images.githubusercontent.com/125700236/232898894-755d98cd-ccf8-4b7e-b8b4-6b9242d69831.png)

6. After creating the cluster, it should be in running state.
![image](https://user-images.githubusercontent.com/125700236/232899003-72aaad9a-4bc9-410a-be65-2bed09e64570.png)

7. Create the flink application.
![image](https://user-images.githubusercontent.com/125700236/232899107-53846132-bdd1-4246-b384-9d78614de3a8.png)

8. Once the application starts running, it should be able to read from the input kafka topic and write to another kafka topic.
![image](https://user-images.githubusercontent.com/125700236/232899182-cc266761-e69e-4327-bcf7-2916b69c20b7.png)

9. In order to visualize these kafka streams, there are various tools available. Since we are using confluent kafka, it comes in-build with Confluent control center which can be used to visualize kafka data streams. Currently, SDP UI does not provide a capability to visualize these streams on streaming data platform.

10. Input kafka stream consumed by flink application on SDP.
![image](https://user-images.githubusercontent.com/125700236/232899310-dae9c8e2-bcf0-4dc3-a0fc-f6e6525bbb60.png)

11. Output kafka stream produced by  flink application on SDP.
![image](https://user-images.githubusercontent.com/125700236/232899383-b9069f7d-84a9-48f9-b43e-e6e889b910e6.png)
