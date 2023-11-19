package controller.empresa;

import java.io.IOException;

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

@WebServlet(urlPatterns = { "/empresa-editar", "/empresa-atualizar" })
public class AtualizaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empresa empresa = new Empresa();
	EmpresaDAO empresaDao = new EmpresaDAO();
	Endereco endereco = new Endereco();
	EmpresaEndereco empresaEndereco = new EmpresaEndereco();

	public AtualizaEmpresaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/empresa-editar":
			editar(request, response);
			break;
		case "/empresa-atualizar":
			atualizar(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		empresa.setNome(request.getParameter("nome"));
		empresa.setEmail(request.getParameter("email"));
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setTelefone(request.getParameter("telefone"));
		int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
		empresa.setIdEmpresa(idEmpresa);

		int cep = Integer.parseInt(request.getParameter("cep"));
		endereco.setCep(cep);
		endereco.setEstado(request.getParameter("estado"));
		endereco.setCidade(request.getParameter("cidade"));
		int idEndereco = Integer.parseInt(request.getParameter("idEndereco"));
		endereco.setIdEndereco(idEndereco);

		empresaDao.atualizar(empresa, endereco);
		response.sendRedirect("empresa");
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		empresaEndereco = empresaDao.consultarById(id);

		request.setAttribute("empresaEndereco", empresaEndereco);
		RequestDispatcher rd = request.getRequestDispatcher("./views/empresa/atualizar.jsp");
		rd.forward(request, response);

	}

}
