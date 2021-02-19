package com.incture.cherrywork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incture.cherrywork.entities.BasicDataDescription;

public interface IBasicDataDescriptionRepository extends JpaRepository<BasicDataDescription, String>{
    }
