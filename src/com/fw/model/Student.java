package com.fw.model;


@SuppressWarnings("serial")
public class Student implements java.io.Serializable {

	private Integer sid;
	private String sno;
	private String name;
	private String password;
	private Integer age;
	private Integer gender;
	private String resume;

	private Classes classes;

	private String newPassword;

	public Student() {
	}

	public Student(Integer sid) {
		this.sid = sid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sno=" + sno + ", name=" + name
				+ ", password=" + password + ", age=" + age + ", gender="
				+ gender + ", resume=" + resume + ", classes=" + classes + "]";
	}

}