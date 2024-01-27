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
@RequestMapping("/vagas-editar")
public class VagaAtualizar {

	@Autowired
	private RepoVaga repoVaga;

	@GetMapping("/{id}")
	public ModelAndView vagasById(@PathVariable Long id, @RequestParam("idEmpresa") Long idEmpresa) {
		ModelAndView model = new ModelAndView("views/vagas/vagasAtualizar.html");
		Vaga vaga = repoVaga.findById(id).orElse(null);

		if (vaga == null) {
			return new ModelAndView("error/404");
		}

		// Adicione a vaga e o idEmpresa ao modelo
		model.addObject("vagas", vaga);
		model.addObject("idEmpresa", idEmpresa);

		return model;
	}

	@PostMapping("/vagas-atualizar")
	public ModelAndView atualizar(@ModelAttribute("vagas") Vaga vaga, @RequestParam("id") Long id,
			@RequestParam("idEmpresa") Long idEmpresa) {
		ModelAndView model = new ModelAndView("redirect:/vagas");
		Empresa empresa = new Empresa();
		empresa.setId(idEmpresa);
		vaga.setEmpresa(empresa);
		vaga.setId(id);

		if (vaga.getId() != null && vaga.getEmpresa() != null) {

			model.addObject("vagas", repoVaga.save(vaga));
		}

		return model;

	}
}