package com.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.models.Vaga;

public interface RepoVaga extends JpaRepository<Vaga, Long>{
	List<Vaga> findByEmpresaId(Long idEmp);
}
