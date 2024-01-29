package com.mvc.controllers.empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.enums.UF;
import com.mvc.models.Candidato;
import com.mvc.models.Empresa;
import com.mvc.models.Experiencia;
import com.mvc.repositories.RepoEmpresa;
import com.mvc.repositories.RepoVaga;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private RepoEmpresa repoEmpresa;

	// @Autowired
	// private RepoVaga repoVaga;

	@GetMapping
	public ModelAndView empresa() {
		ModelAndView modelAndView = new ModelAndView("views/empresas/index.html");
		List<Empresa> empresas = repoEmpresa.findAll();
		modelAndView.addObject("empresas", empresas);

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarEmpresa() {
		ModelAndView modelAndView = new ModelAndView("views/empresas/empresasCadastrar.html");
		modelAndView.addObject("empresas", new Empresa());

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView editarEmpresa(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/empresas/empresasAtualizar");
		Empresa empresa = repoEmpresa.findById(id).orElse(null);

		if (empresa == null) {
			return new ModelAndView("error/404");
		}
		modelAndView.addObject("empresas", empresa);
		return modelAndView;
	}

	@PostMapping({ "/cadastrar"})
	public ModelAndView cadastrarEmpresa(Empresa empresa) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas");
		repoEmpresa.save(empresa);

		return modelAndView;
	}
	
	@PostMapping("/editar")
	public ModelAndView editarEmpresa(@ModelAttribute Empresa empresa,
			@RequestParam("id") Long idEmpresa) {
		ModelAndView model = new ModelAndView("redirect:/empresas");

		if (empresa.getId() != null) {
			empresa.setId(idEmpresa);
			model.addObject("candidatos", repoEmpresa.save(empresa));
		} else {
			System.out.println("Candidato não localizado");
		}

		return model;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluirEmpresa(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas");
		repoEmpresa.deleteById(id);

		return modelAndView;
	}

}
