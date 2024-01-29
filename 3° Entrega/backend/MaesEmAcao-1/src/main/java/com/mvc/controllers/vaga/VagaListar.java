package com.mvc.controllers.vaga;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.models.Vaga;
import com.mvc.repositories.RepoVaga;

@Controller
@RequestMapping("/vagas")
public class VagaListar {
	
	@Autowired
	private RepoVaga repoVaga;
	
	@GetMapping
	public ModelAndView vagas() {
		ModelAndView model = new ModelAndView("views/vagas/index.html");		
		List<Vaga> vagas = repoVaga.findAll();
		model.addObject("vagas", vagas);
		return model;
	}

}
