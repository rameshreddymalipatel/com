package com.incture.cherrywork.services;

import org.springframework.http.ResponseEntity;
import com.incture.cherrywork.entities.BasicDataDescription;
public interface IBasicDataDescriptionService {

	ResponseEntity<Object> create(String materialUniqueId, BasicDataDescription basicDataDescription);
	ResponseEntity<Object> read(String materialUniqueId, String language);
	ResponseEntity<Object> update(String materialUniqueId, String language, BasicDataDescription basicDataDescription);
	ResponseEntity<Object> delete(String materialUniqueId, String language);

}