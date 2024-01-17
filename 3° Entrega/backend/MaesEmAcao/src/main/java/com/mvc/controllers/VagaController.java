package com.mvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.mvc.models.Candidato;
import com.mvc.models.Vaga;
import com.mvc.repositories.RepoCandidato;
import com.mvc.repositories.RepoEmpresa;
import com.mvc.repositories.RepoVaga;

@Controller
public class VagaController {
	@Autowired
	private RepoVaga repoVaga;
	
	@Autowired
	private RepoCandidato repoCandidato;
	
	@Autowired
	private RepoEmpresa repoEmpresa;

	
}
