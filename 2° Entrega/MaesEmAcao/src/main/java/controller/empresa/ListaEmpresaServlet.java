package controller.empresa;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDAO;
import model.Empresa;
import model.EmpresaEndereco;
import model.Endereco;


@WebServlet(urlPatterns = {"/empresa"})
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empresa empresa = new Empresa();
	EmpresaDAO empresaDao = new EmpresaDAO();
	Endereco endereco = new Endereco();
       
   
    public ListaEmpresaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/empresa":
			listar(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmpresaEndereco> lista = empresaDao.getEmpresaEndereco();
		request.setAttribute("listaEmpresas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/empresa/index.jsp");
		rd.forward(request, response);
		
	}

}
