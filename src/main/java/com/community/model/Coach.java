package com.community.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Coach {
public Coach() {}
@JsonCreator
public Coach(String type,String description,String credential,String experience,String picture_URI,String idType,String idCopy_URI,String reference)
{
	this.Ctype = type;
	this.description = description;
	this.credential = credential;
	this.experience = experience;

	this.picture_URI = picture_URI;
	this.idType = idType;
	this.idCopy_URI = idCopy_URI;
	this.reference = reference;
}

public String getCtype() {
	return Ctype;
}
public void setCtype(String ctype) {
	Ctype = ctype;
}

private String Ctype;

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCredential() {
	return credential;
}
public void setCredential(String credential) {
	this.credential = credential;
}

private String experience;

public String getExperience() {
	return experience;
}
public void setExperience(String experience) {
	this.experience = experience;
}
public String getPicture_URI() {
	return picture_URI;
}
public void setPicture_URI(String picture_URI) {
	this.picture_URI = picture_URI;
}
public String getIdType() {
	return idType;
}
public void setIdType(String idType) {
	this.idType = idType;
}
public String getIdCopy_URI() {
	return idCopy_URI;
}
public void setIdCopy_URI(String idCopy_URI) {
	this.idCopy_URI = idCopy_URI;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
private String description; // detail description of Coaching
private String credential; // Certification if they have
private String picture_URI;//location of picture
private String idType; //type of ID ..DL , StateID etc
private String idCopy_URI;//lcoation of id copy 
private String reference;//web site link

}
