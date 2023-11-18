package controller.candidato;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/candidato")
public class CandidatoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidatoDAO candidatoDao = new CandidatoDAO();
	Candidato candidato = new Candidato();
	Endereco endereco = new Endereco();
	

	public CandidatoListarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/candidato":
			listar(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}

	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CandidatoEndereco> lista = candidatoDao.getCandidatoEndereco();
		request.setAttribute("listaCandidatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/candidato/index.jsp");
		rd.forward(request, response);
	}

}
