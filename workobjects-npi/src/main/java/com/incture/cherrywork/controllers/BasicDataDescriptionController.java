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
import com.incture.cherrywork.entities.BasicDataDescription;
import com.incture.cherrywork.services.IBasicDataDescriptionService;

@RestController
@Api(value = "Basic Data Description", tags = {"Basic Data Description"})
@RequestMapping("/api/v1/BasicData/{materialUniqueId}")

public class BasicDataDescriptionController {

@Autowired
private IBasicDataDescriptionService basicDataDescriptionService;

@PostMapping("/BasicDataDescription")
@ApiOperation(value = "Create a BasicDataDescription Dataset")
public ResponseEntity<Object> create(@PathVariable String materialUniqueId, @Valid @RequestBody BasicDataDescription basicDataDescription) {
		return basicDataDescriptionService.create(materialUniqueId,basicDataDescription);
}
@GetMapping("/BasicDataDescription/{language}/")
@ApiOperation(value = "Read BasicDataDescription Dataset")
public ResponseEntity<Object> read(@PathVariable String materialUniqueId, @PathVariable String language) { 
		return basicDataDescriptionService.read(materialUniqueId,language);
}
@PutMapping("/BasicDataDescription/{language}/")
@ApiOperation(value = "Update BasicDataDescription Dataset")
public ResponseEntity<Object> update(@PathVariable String materialUniqueId, @PathVariable String language, @Valid @RequestBody BasicDataDescription basicDataDescription) { 
		return basicDataDescriptionService.update(materialUniqueId,language, basicDataDescription);
}
@DeleteMapping("/BasicDataDescription/{language}/")
@ApiOperation(value = "Delete BasicDataDescription Dataset")
public ResponseEntity<Object> delete(@PathVariable String materialUniqueId, @PathVariable String language) { 
		return basicDataDescriptionService.delete(materialUniqueId,language);
}
}
