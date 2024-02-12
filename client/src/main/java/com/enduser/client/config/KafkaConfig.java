package com.enduser.client.config;

import com.enduser.client.entity.Document;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {
    @KafkaListener(topics = AppConstants.DOCUMENT_TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void getDocument(Document document){
        System.out.println(document.toString());
    }
}
