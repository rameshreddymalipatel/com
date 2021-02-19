package com.incture.cherrywork.services;

import org.springframework.http.ResponseEntity;
import com.incture.cherrywork.entities.BasicData;
public interface IBasicDataService {

	ResponseEntity<Object> create(BasicData basicData);
	ResponseEntity<Object> read(String materialUniqueId);
	ResponseEntity<Object> update(String materialUniqueId, BasicData basicData);
	ResponseEntity<Object> delete(String materialUniqueId);

}