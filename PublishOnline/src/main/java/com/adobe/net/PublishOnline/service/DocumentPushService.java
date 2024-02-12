package com.adobe.net.PublishOnline.service;

import com.adobe.net.PublishOnline.configs.AppConstants;
import com.adobe.net.PublishOnline.entity.Document;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class DocumentPushService {
    @Autowired
    private KafkaTemplate<String, Document> kafkaTemplate;
    @Autowired
    private Document document;

    public Document publishDocument(){
        document.setUuid(UUID.randomUUID().toString());
        document.setTitle(new Faker().name().title());
        document.setCreated_at(new Date());
        document.setCreated_by(new Faker().name().fullName());
        document.setNo_of_pages(new Random().nextInt(2,1000));
        document.setHasMedia(new Random().nextInt()%2==1?true:false);
        this.kafkaTemplate.send(AppConstants.DOCUMENT_TOPIC_NAME,document);
        return document;
    }
}
