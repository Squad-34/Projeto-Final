package com.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.models.Entrevista;

public interface RepoEntrevista extends JpaRepository<Entrevista, Long>{

    
}
