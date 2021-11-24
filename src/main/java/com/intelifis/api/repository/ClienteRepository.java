package com.intelifis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intelifis.api.model.*;

@Repository
@RequestMapping("/clientes")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
