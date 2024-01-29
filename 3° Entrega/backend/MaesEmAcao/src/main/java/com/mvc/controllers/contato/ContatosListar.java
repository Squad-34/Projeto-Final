package com.mvc.controllers.contato;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/contatos")
public class ContatosListar {

	@GetMapping
	public ModelAndView experiencia() {
		ModelAndView modelAndView = new ModelAndView("views/contatos/index.html");
		return modelAndView;
	}
}
