package com.mvc.controllers.vagas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.repositories.RepoVaga;


@Controller
@RequestMapping("/")
public class VagaExcluir  {

	@Autowired
	private RepoVaga repoVaga; 

	@GetMapping("/vagas-deletar/{id}")
	public ModelAndView deletar(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("redirect:/vagas");

		repoVaga.deleteById(id);

		return model;
	}
}