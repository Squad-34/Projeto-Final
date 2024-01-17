package com.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.models.Candidato;
import com.mvc.models.Vaga;

public interface RepoCandidato extends JpaRepository<Candidato, Long> {

	@EntityGraph(attributePaths = "endereco")
	List<Candidato> findAll();

	Iterable<Candidato> findByVaga(Vaga vaga);
}
