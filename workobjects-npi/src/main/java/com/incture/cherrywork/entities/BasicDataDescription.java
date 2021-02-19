package com.incture.cherrywork.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Id;

@Entity
@Table(name = "BasicDataDescription")
public class BasicDataDescription{


@Id
@Column(name = "Language")
private String language;
public String getLanguage(){
	return language;
}
public void setLanguage(String language){
	this.language = language;
}

@Column(name = "Description")
private String description;
public String getDescription(){
	return description;
}
public void setDescription(String description){
	this.description = description;
}

@ManyToOne(fetch = FetchType.LAZY, optional=false)
@JoinColumn(name = "materialUniqueId")@JsonIgnore
private BasicData basicData;
public BasicData getBasicData() {
	return basicData;
}
public void setBasicData(BasicData basicData) {
	this.basicData	= basicData;
}
}