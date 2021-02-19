package com.incture.cherrywork.dtos;
public class BasicDataDto{


private String materialUniqueId;
public String getMaterialUniqueId(){
	return materialUniqueId;
}
public void setMaterialUniqueId(String materialUniqueId){
	this.materialUniqueId = materialUniqueId;
}

private String allowedPackageVolume;
public String getAllowedPackageVolume(){
	return allowedPackageVolume;
}
public void setAllowedPackageVolume(String allowedPackageVolume){
	this.allowedPackageVolume = allowedPackageVolume;
}
}