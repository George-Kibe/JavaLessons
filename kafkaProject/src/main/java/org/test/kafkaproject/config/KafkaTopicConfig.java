package org.test.kafkaproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {
    // class for creating topics
    @Bean
    public NewTopic georgesCodeTopic(){
        return TopicBuilder.name("georgesCode")
                .build();
    }
}
