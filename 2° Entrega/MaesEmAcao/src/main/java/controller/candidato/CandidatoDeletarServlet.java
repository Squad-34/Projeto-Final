package controller.candidato;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDAO;

@WebServlet("/candidato-deletar")
public class CandidatoDeletarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CandidatoDAO candidatoDao = new CandidatoDAO();

	public CandidatoDeletarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		deletar(request, response);
	}

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		candidatoDao.removerByid(id);
		response.sendRedirect("candidato");
	}

}
