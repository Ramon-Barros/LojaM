package com.ramon.model.repository;

import com.ramon.model.entity.Servico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{
    
}
