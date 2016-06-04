package com.fw.model;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Major implements java.io.Serializable {

	private Integer mid;
	private String mname;
	private Set<Classes> classeses = new HashSet<Classes>();

	public Major() {
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Set<Classes> getClasseses() {
		return classeses;
	}

	public void setClasseses(Set<Classes> classeses) {
		this.classeses = classeses;
	}

	@Override
	public String toString() {
		return "Major [mid=" + mid + ", mname=" + mname + "]";
	}

}