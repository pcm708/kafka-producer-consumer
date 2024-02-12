package com.enduser.client.deserializer;

import com.enduser.client.entity.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class DocumentDeserializer implements Deserializer<Document> {

    ObjectMapper objectMapper = new ObjectMapper() ;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No additional configuration needed for this deserializer
    }

    @Override
    public Document deserialize(String topic, byte[] data) {
        Document student = null;
        try {
            student = objectMapper.readValue(data, Document.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void close() {
        // No resources to release
    }
}
