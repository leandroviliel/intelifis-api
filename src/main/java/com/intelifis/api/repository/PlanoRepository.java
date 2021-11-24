package com.intelifis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelifis.api.model.*;
import java.util.List;


@RestController
@Repository

public interface PlanoRepository extends JpaRepository<Plano, Long> {
  
	  
}


