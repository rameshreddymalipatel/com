package com.incture.cherrywork.services;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.incture.cherrywork.entities.BasicDataDescription;
import com.incture.cherrywork.repositories.IBasicDataDescriptionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
import com.incture.cherrywork.repositories.IBasicDataRepository;
import com.incture.cherrywork.entities.BasicData;

@Service
@Transactional
public class BasicDataDescriptionService implements IBasicDataDescriptionService{

@Autowired
private IBasicDataRepository basicDataRepository;
@Autowired
private IBasicDataDescriptionRepository basicDataDescriptionRepository;

@Override
public ResponseEntity<Object> create(String materialUniqueId, BasicDataDescription basicDataDescription) { 
Optional<BasicData> optionalBasicData = basicDataRepository.findById(materialUniqueId);
if(!optionalBasicData.isPresent()) { 
return ResponseEntity.notFound().build();
}
basicDataDescription.setBasicData(optionalBasicData.get());
BasicDataDescription savedBasicDataDescription = basicDataDescriptionRepository.save(basicDataDescription);
URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("id").toUri();
		return ResponseEntity.created(location).body(savedBasicDataDescription);
}
@Override
public ResponseEntity<Object> read(String materialUniqueId, String language) { 
Optional<BasicDataDescription> optionalBasicDataDescription = basicDataDescriptionRepository.findById(language);
if(!optionalBasicDataDescription.isPresent()) { 
return ResponseEntity.notFound().build();
}
return ResponseEntity.ok().body(optionalBasicDataDescription.get());
}
@Override
public ResponseEntity<Object> update(String materialUniqueId, String language, BasicDataDescription basicDataDescription){
Optional<BasicData> optionalBasicData = basicDataRepository.findById(materialUniqueId);
if(!optionalBasicData.isPresent()) { 
return ResponseEntity.notFound().build();
}
Optional<BasicDataDescription> optionalBasicDataDescription = basicDataDescriptionRepository.findById(language);
if(!optionalBasicDataDescription.isPresent()) { 
return ResponseEntity.notFound().build();
}
basicDataDescription.setLanguage(optionalBasicDataDescription.get().getLanguage());
basicDataDescriptionRepository.save(basicDataDescription);
return ResponseEntity.noContent().build();
}
@Override
public ResponseEntity<Object> delete(String materialUniqueId, String language) { 
Optional<BasicDataDescription> optionalBasicDataDescription = basicDataDescriptionRepository.findById(language);
if(!optionalBasicDataDescription.isPresent()) { 
return ResponseEntity.notFound().build();
}
basicDataDescriptionRepository.delete(optionalBasicDataDescription.get());
return ResponseEntity.ok().body(null);
}
}