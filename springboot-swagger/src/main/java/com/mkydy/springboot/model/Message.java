package com.mkydy.springboot.model;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

public class Message {

	private Long id;
	
	@ApiModelProperty(value = "消息体")
	private String text;
	
	@ApiModelProperty(value = "消息总结")
	private String summary;
	
	private LocalDate createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	
}
