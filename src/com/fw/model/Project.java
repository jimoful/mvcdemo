package com.fw.model;

@SuppressWarnings("serial")
public class Project implements java.io.Serializable {

	private Integer pid;
	private String pname;
	private String description;
	private String publishTime;
	private String attachment;

	private Enterprise enterprise;

	public Project() {
	}

	public Project(Integer pid) {
		super();
		this.pid = pid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", description="
				+ description + ", publishTime=" + publishTime
				+ ", attachment=" + attachment + ", enterprise=" + enterprise
				+ "]";
	}

}