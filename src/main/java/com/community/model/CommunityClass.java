package com.community.model;

import java.util.Date;

public class CommunityClass {
	private String className;
	private String classDescription;
	private String classCategory;
	private String ageGroup;
	private String seasson;
	private String classLocation;
	private String classTime;
	private int classCapacity;
	private String classTeacher;
	private String classLevel;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassDescription() {
		return classDescription;
	}
	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	public String getClassCategory() {
		return classCategory;
	}
	public void setClassCategory(String classCategory) {
		this.classCategory = classCategory;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	public String getSeasson() {
		return seasson;
	}
	public void setSeasson(String seasson) {
		this.seasson = seasson;
	}
	public String getClassLocation() {
		return classLocation;
	}
	public void setClassLocation(String classLocation) {
		this.classLocation = classLocation;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public int getClassCapacity() {
		return classCapacity;
	}
	public void setClassCapacity(int classCapacity) {
		this.classCapacity = classCapacity;
	}
	public String getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}
	public String getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}
	public String getClassPrice() {
		return classPrice;
	}
	public void setClassPrice(String classPrice) {
		this.classPrice = classPrice;
	}
	private String classPrice;

	
	public Date getCreteUpdateDate() {
		return creteUpdateDate;
	}
	public void setCreteUpdateDate(Date creteUpdateDate) {
		this.creteUpdateDate = 	new Date(System.currentTimeMillis());
	}
	private Date creteUpdateDate;
	

}
