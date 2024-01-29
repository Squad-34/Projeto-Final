package com.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.models.Empresa;
import com.mvc.models.Vaga;

public interface RepoEmpresa extends JpaRepository<Empresa, Long> {
	//@EntityGraph(attributePaths = "endereco")
	List<Empresa> findAll();

	//Iterable<Empresa> findByVaga(Vaga vaga);
}
