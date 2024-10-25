#Local Kafka Server startup process
#Before run the Kafka Producer run the Kafka Kraft commands
.\bin\windows\kafka-storage.bat random-uuid

Replace the generated RandomUUID with 'random-uuid' in the below command
#.\bin\windows\kafka-storage.bat format -t random-uuid -c .\config\kraft\server.properties


#.\bin\windows\kafka-server-start.bat .\config\kraft\server.properties

Using StringSerializer for Key and value as JsonSerializer 

This Application is going to run inside the docker.
1.do maven clean and install

2.create the image of the application inside docker using
                    docker build -t kafka-producer .

Data can post using URL http://localhost:9191/publish

{
"id": "254340",
"name":"data1",
"email": "data1@gmail.com",
"contactNo":"1234567890"

}

