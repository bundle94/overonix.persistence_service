<h3>SETTING UP PERSISTENCE SERVICES</h3>
1) Goto <code>KafkaConsumerConfiguration class</code> change the <code>BOOTSTRAP_SERVER_CONFIG</code> to the <code>IP</code> and <code>Port</code> of the host machine where your Kafka server is running. I have also gone ahead to add the <code>Kafka</code>,<code>zookeper</code> and <code>MSSQL server</code> images to the <code>Docker-compose.yml</code> file, just incase you don't have them running on your local already.
   to start them up kindly run the following command : <code>docker-compose up -d</code> and <code>docker ps -a</code> to ensure they are actually running.
   

2) Run the command <code>mvn spring-boot:build-image</code> to build a docker image of the signup service.


3) Run the command <code>docker run -it -p7070:7070 persistence:0.0.1-SNAPSHOT</code> to run the built docker image. This will map the service to port <code>7070</code> on your local machine/server.