package com.incture.cherrywork.services;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.incture.cherrywork.entities.BasicData;
import com.incture.cherrywork.repositories.IBasicDataRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@Service
@Transactional
public class BasicDataService implements IBasicDataService{

@Autowired
private IBasicDataRepository basicDataRepository;

@Override
public ResponseEntity<Object> create(BasicData basicData) { 
BasicData savedBasicData = basicDataRepository.save(basicData);
URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand("id").toUri();
		return ResponseEntity.created(location).body(savedBasicData);
}
@Override
public ResponseEntity<Object> read(String materialUniqueId) { 
Optional<BasicData> optionalBasicData = basicDataRepository.findById(materialUniqueId);
if(!optionalBasicData.isPresent()) { 
return ResponseEntity.notFound().build();
}
return ResponseEntity.ok().body(optionalBasicData.get());
}
@Override
public ResponseEntity<Object> update(String materialUniqueId, BasicData basicData){
Optional<BasicData> optionalBasicData = basicDataRepository.findById(materialUniqueId);
if(!optionalBasicData.isPresent()) { 
return ResponseEntity.notFound().build();
}
basicData.setMaterialUniqueId(optionalBasicData.get().getMaterialUniqueId());
basicDataRepository.save(basicData);
return ResponseEntity.noContent().build();
}
@Override
public ResponseEntity<Object> delete(String materialUniqueId) { 
Optional<BasicData> optionalBasicData = basicDataRepository.findById(materialUniqueId);
if(!optionalBasicData.isPresent()) { 
return ResponseEntity.notFound().build();
}
basicDataRepository.delete(optionalBasicData.get());
return ResponseEntity.ok().body(null);
}
}