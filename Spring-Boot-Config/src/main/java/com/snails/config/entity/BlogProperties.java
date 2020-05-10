package com.snails.config.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "snails.blog")
public class BlogProperties {

    private String name;

    private String title;
}
