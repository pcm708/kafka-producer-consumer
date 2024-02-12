package com.adobe.net.PublishOnline.controller;

import com.adobe.net.PublishOnline.entity.Document;
import com.adobe.net.PublishOnline.service.DocumentPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentPushService documentPushService;
    @PostMapping("/publish")
    public ResponseEntity<?> publishDocumentOnline(){
        Document doc= this.documentPushService.publishDocument();
        return new ResponseEntity<>(doc, HttpStatus.OK);
    }
}