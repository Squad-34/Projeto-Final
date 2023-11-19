package controller.candidato;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAO;
import model.Candidato;
import model.CandidatoEndereco;
import model.Endereco;

@WebServlet(urlPatterns = { "/candidato-editar", "/candidato-atualizar", "/candidato/experiencia-editar"})
public class CandidatoAtualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidatoDAO candidatoDao = new CandidatoDAO();
	CandidatoEndereco candidatoEndereco = new CandidatoEndereco();
	Candidato candidato = new Candidato();
	Endereco endereco = new Endereco();

	public CandidatoAtualizarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		switch (action) {
		case "/candidato-editar":
			editar(request, response);
			break;
		case "/candidato-atualizar":
			atualizar(request, response);
			break;
		case "/candidato/experiencia-editar":
			editarExperiencia(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	protected void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		candidatoEndereco = candidatoDao.consultarById(id);

		request.setAttribute("candidatoEndereco", candidatoEndereco);
		RequestDispatcher rd = request.getRequestDispatcher("./views/candidato/atualizar.jsp");
		rd.forward(request, response);
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		candidato.setNome(request.getParameter("nome"));
		candidato.setEmail(request.getParameter("email"));
		candidato.setCpf(request.getParameter("cpf"));
		candidato.setTelefone(request.getParameter("telefone"));
		candidato.setIdioma(request.getParameter("idioma"));
		candidato.setFormacao(request.getParameter("formacao"));
		int idCandidato = Integer.parseInt(request.getParameter("idCandidato"));
		candidato.setIdCandidato(idCandidato);
		
		int cep = Integer.parseInt(request.getParameter("cep"));
		endereco.setCep(cep);
		endereco.setEstado(request.getParameter("estado"));
		endereco.setCidade(request.getParameter("cidade"));
		int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
		endereco.setIdEndereco(idEndereco);
		
		candidatoDao.atualizar(candidato, endereco);
		response.sendRedirect("candidato");
	}
	
	protected void editarExperiencia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		candidatoEndereco = candidatoDao.consultarById(id);

		request.setAttribute("candidatoEndereco", candidatoEndereco);
		RequestDispatcher rd = request.getRequestDispatcher("../views/experiencia/cadastrar.jsp");
		rd.forward(request, response);
	}

}
