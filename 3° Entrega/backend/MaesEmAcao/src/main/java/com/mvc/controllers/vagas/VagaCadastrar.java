package com.mvc.controllers.vagas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.models.Vaga;
import com.mvc.repositories.RepoVaga;


@Controller
@RequestMapping("/vagas-cadastrar")
public class VagaCadastrar {

	@Autowired
	private RepoVaga repoVaga;

	@GetMapping
	public ModelAndView cadastrar() {
		ModelAndView model = new ModelAndView("views/vagas/vagasCadastrar.html");
		model.addObject("vagas", new Vaga());
		return model;
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView cadastrar(@ModelAttribute ("vagas") Vaga vaga) {
		ModelAndView model = new ModelAndView("redirect:/vagas");
		repoVaga.save(vaga);
		return model;
	}
}