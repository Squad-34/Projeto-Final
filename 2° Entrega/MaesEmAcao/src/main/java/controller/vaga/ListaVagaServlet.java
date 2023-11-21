package controller.vaga;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VagaDAO;
import model.Vaga;

@WebServlet("/vaga")
public class ListaVagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VagaDAO vagaDao = new VagaDAO();
	Vaga vaga = new Vaga();

	public ListaVagaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/vaga":
			listar(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Vaga> lista = vagaDao.listar();
		request.setAttribute("listaVagas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/vaga/index.jsp");
		rd.forward(request, response);
	}

}
