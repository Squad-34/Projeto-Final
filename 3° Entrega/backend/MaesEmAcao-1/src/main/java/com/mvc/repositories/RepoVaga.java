package com.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.models.Vaga;

public interface RepoVaga extends JpaRepository<Vaga, Long>{
  
}
