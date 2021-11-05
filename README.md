# kitchen-engine


#Some docker commands
docker pull wurstmeister/zookeeper:latest
docker run -d \
-p 2181:2181 \
--name zookeeper \
wurstmeister/zookeeper:latest


docker run -d -p 9092:9092 \
-e KAFKA_BROKER_ID="${KAFKA_BROKER_ID}" \
-e KAFKA_CREATE_TOPICS="${KAFKA_CREATE_TOPICS}" \
-e HOSTNAME_COMMAND="docker info | grep ^Name: | cut -d' ' -f 2" \
-e KAFKA_ZOOKEEPER_CONNECT="zookeeper:2181" \
-e KAFKA_LISTENER_SECURITY_PROTOCOL_MAP="INTERNAL:PLAINTEXT,EXTERNAL:PLAINTEXT" \
-e KAFKA_ADVERTISED_LISTENERS="INTERNAL://localhost:9093,EXTERNAL://localhost:9092" \
-e KAFKA_LISTENERS="INTERNAL://:9093,EXTERNAL://:9092" \
-e KAFKA_INTER_BROKER_LISTENER_NAME="INTERNAL" \
-v /var/run/docker.sock:/var/run/docker.sock \
--link zookeeper:zookeeper \
--name kafka \
wurstmeister/kafka:latest

=====Docker command=====

docker build -t spring-boot:1.0 .
docker run -d -p 80:8080 -t spring-boot:1.0