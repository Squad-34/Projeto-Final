package com.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.enums.UF;
import com.mvc.models.Candidato;
import com.mvc.models.Experiencia;
import com.mvc.repositories.RepoCandidato;
import com.mvc.repositories.RepoExperiencia;

@Controller
@RequestMapping("/candidatos")
public class CandidatoController {

	@Autowired
	private RepoCandidato repoCandidato;

	@Autowired
	private RepoExperiencia repoExperiencia;

	@GetMapping
	public ModelAndView candidato() {
		ModelAndView modelAndView = new ModelAndView("views/candidatos/index.html");
		List<Candidato> candidatos = repoCandidato.findAll();
		modelAndView.addObject("candidatos", candidatos);

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarCandidato() {
		ModelAndView modelAndView = new ModelAndView("views/candidatos/create");
		modelAndView.addObject("candidatos", new Candidato());
		modelAndView.addObject("ufs", UF.values());
		// modelAndView.addObject("experiencias", new Experiencia());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editarCandidato(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/candidatos/edit");
		modelAndView.addObject("candidato", repoCandidato.getReferenceById(id));
		modelAndView.addObject("ufs", UF.values());
		// modelAndView.addObject("experiencias", new Experiencia());

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public ModelAndView cadastrarCandidato(Candidato candidato) {
		ModelAndView modelAndView = new ModelAndView("redirect:/candidatos");
		repoCandidato.save(candidato);

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluirCandidato(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/candidatos");
		repoCandidato.deleteById(id);

		return modelAndView;
	}

}
