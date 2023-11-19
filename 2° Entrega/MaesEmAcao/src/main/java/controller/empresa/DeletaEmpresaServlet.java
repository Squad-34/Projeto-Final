package controller.empresa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDAO;


@WebServlet("/empresa-deletar")
public class DeletaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpresaDAO empresaDao = new EmpresaDAO();
       
    public DeletaEmpresaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deletar(request, response);
	}


	private void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		empresaDao.removerByid(id);
		response.sendRedirect("empresa");
		
	}

}
