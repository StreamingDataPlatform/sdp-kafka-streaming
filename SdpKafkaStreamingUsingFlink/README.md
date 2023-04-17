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
![image](https://media.eos2git.cec.lab.emc.com/user/16094/files/64470e05-8b5f-4dd7-a9ae-7f34a9c08e8f)

4.  Go to Flink tab under your project in SDP UI
 ![image](https://media.eos2git.cec.lab.emc.com/user/16094/files/dd0e2a3f-b484-46bf-8d96-594625a5ae0e)

5. Click on tab "Clusters" under Flink and create a flink cluster.
![image](https://media.eos2git.cec.lab.emc.com/user/16094/files/168f9488-f51f-414e-ad15-545a10779865)

6. After creating the cluster, it should be in running state.
![image](https://media.eos2git.cec.lab.emc.com/user/16094/files/19f8860c-b8dd-4d7a-93d1-61e369451ffc)

7. Create the flink application.
![image](https://media.eos2git.cec.lab.emc.com/user/16094/files/c1327074-a6e2-42d7-b547-c101380fe5eb)

8. Once the application starts running, it should be able to read from the input kafka topic and write to another kafka topic.
![image](https://media.eos2git.cec.lab.emc.com/user/16094/files/e472870c-d034-4c15-9572-2671d7ce8d49)

9. In order to visualize these kafka streams, there are various tools available. Since we are using confluent kafka, it comes in-build with Confluent control center which can be used to visualize kafka data streams. Currently, SDP UI does not provide a capability to visualize these streams on streaming data platform.

10. Input kafka stream consumed by flink application on SDP.
![image](https://media.eos2git.cec.lab.emc.com/user/16094/files/6324eab3-6484-4508-b2cc-8bddf6683a7b)

11. Output kafka stream produced by  flink application on SDP.
![image](https://media.eos2git.cec.lab.emc.com/user/16094/files/61cb3ee0-bdfe-4574-82e0-48447332ec78)
