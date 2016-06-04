package com.fw.model;


@SuppressWarnings("serial")
public class StuPro implements java.io.Serializable {

	private Integer spid;
	
	private String submitTime;
	private String praise;
	private Integer submitNumber;
	private String submitPath;

	private Student student;
	private Project project;

	public StuPro() {
	}

	public StuPro(Student student, Project project) {
		super();
		this.student = student;
		this.project = project;
	}

	public Integer getSpid() {
		return spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getPraise() {
		return praise;
	}

	public void setPraise(String praise) {
		this.praise = praise;
	}

	public Integer getSubmitNumber() {
		return submitNumber;
	}

	public void setSubmitNumber(Integer submitNumber) {
		this.submitNumber = submitNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getSubmitPath() {
		return submitPath;
	}

	public void setSubmitPath(String submitPath) {
		this.submitPath = submitPath;
	}

	@Override
	public String toString() {
		return "StuPro [spid=" + spid + ", submitTime=" + submitTime
				+ ", praise=" + praise + ", submitNumber=" + submitNumber
				+ ", submitPath=" + submitPath + ", student=" + student
				+ ", project=" + project + "]";
	}

	
}