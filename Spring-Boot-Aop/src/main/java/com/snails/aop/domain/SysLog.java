package com.snails.aop.domain;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class SysLog {
    private Integer id;
    private String userName;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private LocalDateTime createTime;
}
