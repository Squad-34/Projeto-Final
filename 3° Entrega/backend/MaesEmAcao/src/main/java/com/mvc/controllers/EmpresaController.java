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
import com.mvc.models.Empresa;
import com.mvc.repositories.RepoEmpresa;
import com.mvc.repositories.RepoVaga;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private RepoEmpresa repoEmpresa;

	@Autowired
	private RepoVaga repoVaga;

	@GetMapping
	public ModelAndView empresa() {
		ModelAndView modelAndView = new ModelAndView("views/empresas/index.html");
		List<Empresa> empresas = repoEmpresa.findAll();
		modelAndView.addObject("empresas", empresas);

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarEmpresa() {
		ModelAndView modelAndView = new ModelAndView("views/empresas/create");
		modelAndView.addObject("empresas", new Empresa());
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editarEmpresa(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/empresas/edit");
		modelAndView.addObject("empresa", repoEmpresa.getReferenceById(id));
		modelAndView.addObject("ufs", UF.values());

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public ModelAndView cadastrarEmpresa(Empresa empresa) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas");
		repoEmpresa.save(empresa);

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluirEmpresa(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas");
		repoEmpresa.deleteById(id);

		return modelAndView;
	}
	
	
}
