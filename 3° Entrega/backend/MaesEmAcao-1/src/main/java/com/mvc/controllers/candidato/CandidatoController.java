package com.mvc.controllers.candidato;

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
import com.mvc.models.Experiencia;
import com.mvc.repositories.RepoCandidato;
import com.mvc.repositories.RepoExperiencia;

import jakarta.websocket.server.PathParam;

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
		ModelAndView modelAndView = new ModelAndView("views/candidatos/candidatosCadastrar.html");
		modelAndView.addObject("candidatos", new Candidato());
		modelAndView.addObject("experiencias", new Experiencia());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrarCandidato(@ModelAttribute Candidato candidato,
			@ModelAttribute Experiencia experiencia) {
		ModelAndView modelAndView = new ModelAndView("redirect:/candidatos");
		Candidato candidatoSalvo = repoCandidato.save(candidato);
		Candidato candidatoPersistente = repoCandidato.findById(candidatoSalvo.getId()).orElse(null);
		experiencia.setCandidato(candidatoPersistente);
		repoExperiencia.saveAndFlush(experiencia);
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView editarCandidato(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/candidatos/candidatosAtualizar.html");

		Candidato candidato = repoCandidato.findById(id).orElse(null);

		if (candidato == null) {
			return new ModelAndView("error/404");
		}

		Experiencia experiencia = repoExperiencia.findByCandidatoId(id).orElse(null);
		modelAndView.addObject("candidatos", candidato);

		if (experiencia != null) {
			modelAndView.addObject("experiencias", experiencia);
		} else {
			modelAndView.addObject("experiencias", new Experiencia());
		}

		return modelAndView;
	}

	@PostMapping("/editar")
	public ModelAndView editarCandidato(@ModelAttribute Candidato candidato, @ModelAttribute Experiencia experiencia,
			@RequestParam("id") Long idCandidato, @RequestParam("idExperiencia") Long idExperiencia) {
		ModelAndView model = new ModelAndView("redirect:/vagas");

		if (candidato.getId() != null) {
			candidato.setId(idCandidato);
			model.addObject("candidatos", repoCandidato.save(candidato));
		} else {
			System.out.println("Candidato não localizado");
		}

		if (idExperiencia != null) {
			experiencia.setId(idExperiencia);
			Experiencia experienciaAtualizada = repoExperiencia.save(experiencia);
			model.addObject("experiencias", experienciaAtualizada);
		} else {
			System.out.println("Experiencia não localizada");
			return new ModelAndView("error/404");
		}

		return model;
	}

	@GetMapping("/{id}/deletar")
	public ModelAndView excluirCandidato(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/candidatos");
		repoCandidato.deleteById(id);

		return modelAndView;
	}

}

