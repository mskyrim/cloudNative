## Dapr commands

### start docker service
sudo service docker start

### Dapr message-service

sudo dapr run --app-id message --dapr-http-port 4001 --app-port 3001 --config ./dapr-config/basic-config.yaml --components-path ./dapr-config/components

### Dapr getway-service

sudo dapr run --app-id getway --dapr-http-port 4000 --app-port 3000 --config ./dapr-config/basic-config.yaml

### Dapr event-service
sudo dapr run --app-id event-service --dapr-http-port 4002 --app-port 3002 --config ./dapr-config/basic-config.yaml --components-path ./dapr-config/components

### Dapr dashboard
sudo dapr dashboard

### Start zepkin
sudo docker-compose -f docker-compose-mem.yml up zipkin

### Acess H2 console for each service
http://localhost:3001/h2-console/

### Run kafka
~/kafka_2.13-3.1.0/bin/zookeeper-server-start.sh ~/kafka_2.13-3.1.0/config/zookeeper.properties   
~/kafka_2.13-3.1.0/bin/kafka-server-start.sh ~/kafka_2.13-3.1.0/config/server.properties  
