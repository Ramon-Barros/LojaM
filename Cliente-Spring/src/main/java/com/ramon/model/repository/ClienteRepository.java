package com.ramon.model.repository;

import com.ramon.model.enity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    
}
