## High level diagram

![Screenshot 2024-04-07 at 3 36 38 PM](https://github.com/pcm708/kafka-producer-consumer/assets/52307892/f3254dea-fcdd-4192-b256-4d628ac79a7e)




KAFKA ESSENTIALS

Starting Zookeeper from terminal window: zookeeper-server-start.sh ~/kafka/config/zookeeper.properties  Starting Kafka server from terminal window: kafka-server-start.sh ~/kafka/config/server.properties

To start Kafka without zookeeper:

If you face any issue related to meta.properties file 
1. kafka-storage.sh random-uuid
2. kafka-storage.sh format -t uuid -c ~/kafka/config/kraft/server.properties
3.  kafka-server-start.sh ~/kafka/config/kraft/server.properties

Topics CLI:

Create topic in a Kafka cluster: kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --create --topic first_topic

kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092

For mentioning partitions explicitly: —partitions 5

To list all the topics in terminal window: kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --list

kafka-topics.sh --bootstrap-server localhost:9092 --list

To get info about a topic: kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --describe

kafka-topics.sh --bootstrap-server localhost:9092 --topic user_location --describe

To delete a Kafka topic: kafka-topics.sh --command-config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --delete

kafka-topics.sh --bootstrap-server localhost:9092 --topic first_topic --delete

Producer CLI:

To produce a message to a topic: kafka-console-producer.sh --producer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic_1

Producing to a non existing topic may be successful or not, basically it depends on the cluster configuration set by the admin.

Produce with keys kafka-console-producer.sh --producer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --property parse.key=true --property key.separator=:

Consumer CLI:  Consumes new messages: kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic

Consume from beginning: kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --from-beginning kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic_1 --from-beginning

Consumes in a pretty format: kafka-console-consumer.sh --consumer.config playground.config --bootstrap-server cluster.playground.cdkt.io:9092 --topic first_topic --formatter kafka.tools.DefaultMessageFormatter --property print.timestamp=true --property print.key=true --property print.value=true --property print.partition=true --from-beginning

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic_1 --formatter kafka.tools.DefaultMessageFormatter --property print.timestamp=true --property print.key=true --property print.value=true --property print.partition=true --from-beginning
