package controller.experiencia;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExperienciaDAO;
import model.Candidato;
import model.Experiencia;

@WebServlet("/experiencia-cadastrar")
public class ExperienciaCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ExperienciaDAO experienciaDao = new ExperienciaDAO();
	Experiencia experiencia = new Experiencia();
	Candidato candidato = new Candidato();

	public ExperienciaCadastrarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastrar(request, response);

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		experiencia.setNomeEmpresa(request.getParameter("nomeEmpresa"));
		experiencia.setCargo(request.getParameter("cargo"));
		LocalDate dataInicio = LocalDate.parse(request.getParameter("dataInicio"));
		experiencia.setDataInicio(dataInicio);
		LocalDate dataFinal = LocalDate.parse(request.getParameter("dataFinal"));
		experiencia.setDataFinal(dataFinal);
		int id = Integer.parseInt(request.getParameter("idCandidato"));
		candidato.setIdCandidato(id);
		experiencia.setCandidato(candidato);
		experienciaDao.cadastrar(experiencia);
		response.sendRedirect("candidato");

	}

}
