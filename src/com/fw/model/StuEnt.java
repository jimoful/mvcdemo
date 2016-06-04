package com.fw.model;

@SuppressWarnings("serial")
public class StuEnt implements java.io.Serializable {

	private Integer seid;
	private Student student;
	private Enterprise enterprise;

	public StuEnt() {
	}

	
	public StuEnt(Student student, Enterprise enterprise) {
		this.student = student;
		this.enterprise = enterprise;
	}



	public Integer getSeid() {
		return seid;
	}

	public void setSeid(Integer seid) {
		this.seid = seid;
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