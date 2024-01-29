package com.mvc.controllers.experiencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.models.Experiencia;
import com.mvc.repositories.RepoExperiencia;

@Controller
@RequestMapping("/experiencias/{id}")
public class ExperienciaListar {

	@Autowired
	private RepoExperiencia repoExperiencia;

	@GetMapping
	public ModelAndView experiencia(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/experiencias/index.html");
		Experiencia experiencias = repoExperiencia.findByCandidatoId(id).orElse(null);
		
		if (experiencias != null) {
			List<Experiencia> addExperiencias = new ArrayList<>();
			addExperiencias.add(experiencias);
			modelAndView.addObject("experiencias", addExperiencias);
		}else {
			System.out.println("Experiencia não localizada");
		}

		return modelAndView;
	}
}
