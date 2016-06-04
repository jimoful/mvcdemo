package com.fw.model;

@SuppressWarnings("serial")
public class EntStu implements java.io.Serializable {

	private Integer esid;
	private Student student;
	private Enterprise enterprise;

	public EntStu() {
	}

	public EntStu(Enterprise enterprise, Student student) {
		this.enterprise = enterprise;
		this.student = student;
	}

	public Integer getEsid() {
		return esid;
	}

	public void setEsid(Integer esid) {
		this.esid = esid;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

}