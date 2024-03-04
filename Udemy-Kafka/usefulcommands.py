# list topics
#docker exec -it cli-tools kafka-topics --list --bootstrap-server broker0:29092,broker1:29093,broker2:29094

# create topic
# docker exec -it cli-tools kafka-topics --create --topic my-topic --bootstrap-server broker0:29092,broker1:29093,broker2:29094
# docker exec -it cli-tools kafka-topics --bootstrap-server broker0:29092 --create --topic people --partitions 2 --replication-factor 2

