package com.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.models.Experiencia;


public interface RepoExperiencia extends JpaRepository<Experiencia, Long>{

    @EntityGraph(attributePaths = {"candidato"})
    List<Experiencia> findAll();
}
