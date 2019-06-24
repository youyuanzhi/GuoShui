package com.yuanzhi.pojo;

import java.util.Date;

public class Info {
	private String infoId;
	private String type;
	private String source;
	private String title;
	private String content;
	private String memo;
	private String creator;
	private Date create_time;
	private String state;

	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Info [infoId=" + infoId + ", type=" + type + ", source=" + source + ", title=" + title + ", content="
				+ content + ", memo=" + memo + ", creator=" + creator + ", create_time=" + create_time + ", state="
				+ state + "]";
	}


}
