#Before run the Kafka Producer run the Kafka Kraft commands.\bin\windows\kafka-storage.bat random-uuid

#.\bin\windows\kafka-storage.bat format -t random-uuid -c .\config\kraft\server.properties

#.\bin\windows\kafka-server-start.bat .\config\kraft\server.properties

Avro Implementation not done,
Using StringSerializer for Key and value as JsonSerializer 

Kafka Server running inside the docker.

create the image of the application 
                    docket build -t kafka-producer .