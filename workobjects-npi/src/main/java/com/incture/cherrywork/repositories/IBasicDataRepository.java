package com.incture.cherrywork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.incture.cherrywork.entities.BasicData;

public interface IBasicDataRepository extends JpaRepository<BasicData, String>{
    }
