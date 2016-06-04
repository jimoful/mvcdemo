package com.fw.model;

@SuppressWarnings("serial")
public class Classes implements java.io.Serializable {

	private Integer cid;
	private String cname;
	private Major major;

	public Classes() {
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", cname=" + cname + ", major=" + major
				+ "]";
	}

}