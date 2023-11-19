package controller.experiencia;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExperienciaDAO;
import model.Candidato;
import model.Experiencia;

@WebServlet(urlPatterns = { "/experiencia-editar", "/experiencia-atualizar"})
public class ExperienciaAtualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ExperienciaDAO experienciaDao = new ExperienciaDAO();
	Experiencia experiencia = new Experiencia();
	Candidato candidato = new Candidato();

	public ExperienciaAtualizarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch (action) {
		case "/experiencia-editar":
			editar(request, response);
			break;
		case "/experiencia-atualizar":
			atualizar(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	protected void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		experiencia = experienciaDao.consultarById(id);

		request.setAttribute("experiencia", experiencia);
		RequestDispatcher rd = request.getRequestDispatcher("./views/experiencia/atualizar.jsp");
		rd.forward(request, response);
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idCandidato"));
		candidato.setIdCandidato(id);		
		
		experiencia.setNomeEmpresa(request.getParameter("nomeEmpresa"));
		experiencia.setCargo(request.getParameter("cargo"));
		LocalDate dataInicio = LocalDate.parse(request.getParameter("dataInicio"));
		experiencia.setDataInicio(dataInicio);
		LocalDate dataFinal = LocalDate.parse(request.getParameter("dataFinal"));
		experiencia.setDataFinal(dataFinal);
		int idExp = Integer.parseInt(request.getParameter("idExperiencia"));
		experiencia.setIdExperiencia(idExp);
		experienciaDao.atualizar(experiencia);
		
		response.sendRedirect("experiencia?id=" + id);
	}

}
