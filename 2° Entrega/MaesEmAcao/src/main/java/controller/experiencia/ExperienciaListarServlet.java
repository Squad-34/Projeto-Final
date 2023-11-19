package controller.experiencia;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExperienciaDAO;
import model.Experiencia;

@WebServlet("/experiencia")
public class ExperienciaListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ExperienciaDAO experienciaDao = new ExperienciaDAO();
	Experiencia experiencia = new Experiencia();
	

	public ExperienciaListarServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/experiencia":
			listar(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}

	}

	protected void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		experiencia = experienciaDao.consultarById(id);

		request.setAttribute("experiencia", experiencia);
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/experiencia/index.jsp");
		rd.forward(request, response);
	}

}
