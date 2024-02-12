package com.adobe.net.PublishOnline.serializer;

import com.adobe.net.PublishOnline.entity.Document;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class DocumentSerializer implements Serializer<Document> {

    ObjectMapper objectMapper= new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Document data) {
        byte[] byteArr = null;
        try {
            byteArr = objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return byteArr;
    }
}
