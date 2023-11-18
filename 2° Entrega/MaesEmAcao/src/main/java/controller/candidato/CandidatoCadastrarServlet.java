package controller.candidato;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAO;
import model.Candidato;
import model.Endereco;



@WebServlet("/candidato-cadastrar")
public class CandidatoCadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidatoDAO candidatoDao = new CandidatoDAO();
	Candidato candidato = new Candidato();
	Endereco endereco = new Endereco();

	public CandidatoCadastrarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastrar(request, response);

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		candidato.setNome(request.getParameter("nome"));
		candidato.setEmail(request.getParameter("email"));
		candidato.setCpf(request.getParameter("cpf"));
		candidato.setTelefone(request.getParameter("telefone"));
		candidato.setIdioma(request.getParameter("idioma"));
		candidato.setFormacao(request.getParameter("formacao"));
		
		int cep = Integer.parseInt(request.getParameter("cep"));
		endereco.setCep(cep);
		endereco.setEstado(request.getParameter("estado"));
		endereco.setCidade(request.getParameter("cidade"));

		candidatoDao.cadastrar(candidato, endereco);
		response.sendRedirect("candidato");

	}

}
