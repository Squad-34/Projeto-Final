package com.mvc.controllers.vagas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.models.Empresa;
import com.mvc.models.Vaga;
import com.mvc.repositories.RepoVaga;


@Controller
@RequestMapping("/vagas-cadastrar")
public class VagaCadastrar {

	@Autowired
	private RepoVaga repoVaga;

	@GetMapping("/{id}")
	public ModelAndView cadastrar(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("views/vagas/vagasCadastrar.html");
		Empresa empresas = new Empresa();
		empresas.setId(id);
		model.addObject("empresas", empresas);
		model.addObject("vagas", new Vaga());
		return model;

	}

	@PostMapping("/salvar")
	public ModelAndView cadastrar(@ModelAttribute("vagas") Vaga vaga, @RequestParam("id") Long id) {
		ModelAndView model = new ModelAndView("redirect:/vagas");
		Empresa idEmpresa = new Empresa();
		idEmpresa.setId(id);
		vaga.setEmpresa(idEmpresa);
		if (idEmpresa != null) {
			vaga.setEmpresa(idEmpresa);
			repoVaga.save(vaga);
		}
		return model;
	}
}