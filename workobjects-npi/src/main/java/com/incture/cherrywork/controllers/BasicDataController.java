package com.incture.cherrywork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.incture.cherrywork.entities.BasicData;
import com.incture.cherrywork.services.IBasicDataService;

@RestController
@Api(value = "Basic Data", tags = {"Basic Data"})
@RequestMapping("/api/v1")

public class BasicDataController {

@Autowired
private IBasicDataService basicDataService;

@PostMapping("/BasicData")
@ApiOperation(value = "Create a BasicData Dataset")
public ResponseEntity<Object> create(@Valid @RequestBody BasicData basicData) {
		return basicDataService.create(basicData);
}
@GetMapping("/BasicData/{materialUniqueId}/")
@ApiOperation(value = "Read BasicData Dataset")
public ResponseEntity<Object> read(@PathVariable String materialUniqueId) { 
		return basicDataService.read(materialUniqueId);
}
@PutMapping("/BasicData/{materialUniqueId}/")
@ApiOperation(value = "Update BasicData Dataset")
public ResponseEntity<Object> update(@PathVariable String materialUniqueId, @Valid @RequestBody BasicData basicData) { 
		return basicDataService.update(materialUniqueId, basicData);
}
@DeleteMapping("/BasicData/{materialUniqueId}/")
@ApiOperation(value = "Delete BasicData Dataset")
public ResponseEntity<Object> delete(@PathVariable String materialUniqueId) { 
		return basicDataService.delete(materialUniqueId);
}
}
