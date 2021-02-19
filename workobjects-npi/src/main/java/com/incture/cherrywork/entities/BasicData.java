package com.incture.cherrywork.dtos;
import com.incture.cherrywork.dtos.BasicDataDescriptionDto
import java.util.List;

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
List<BasicDataDescriptionDto> basicDataDescriptionList = new ArrayList<BasicDataDescriptionDto>()
public List<BasicDataDescriptionDto> getBasicDataDescriptionDtoList() {
	return basicDataDescriptionList;
}
public void setBasicDataDescriptionDtoList(List<BasicDataDescriptionDto> basicDataDescriptionList) { 
	this.basicDataDescriptionList = basicDataDescriptionList;
  }
}
}