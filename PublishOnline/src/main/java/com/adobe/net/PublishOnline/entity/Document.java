package com.adobe.net.PublishOnline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Document implements Serializable {
    private String uuid;
    private String title;
    private String created_by;
    private Date created_at;
    private int no_of_pages;
    private boolean hasMedia;
}