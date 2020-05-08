package com.snails.mkydy.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BlogProperties {

    @Value("${snails.blog.name}")
    private String name;

    @Value("${snails.blog.title}")
    private String title;
}
