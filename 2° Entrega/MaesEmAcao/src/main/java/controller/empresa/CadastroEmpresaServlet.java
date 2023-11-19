package controller.empresa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDAO;
import model.Empresa;
import model.Endereco;

@WebServlet("/empresa-cadastrar")
public class CadastroEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empresa empresa = new Empresa();
	EmpresaDAO empresaDao = new EmpresaDAO();
	Endereco endereco = new Endereco();

	public CadastroEmpresaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cadastrar(request, response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		empresa.setNome(request.getParameter("nome"));
		empresa.setEmail(request.getParameter("email"));
		empresa.setCnpj(request.getParameter("cnpj"));
		empresa.setTelefone(request.getParameter("telefone"));

		int cep = Integer.parseInt(request.getParameter("cep"));
		endereco.setCep(cep);
		endereco.setEstado(request.getParameter("estado"));
		endereco.setCidade(request.getParameter("cidade"));

		empresaDao.cadastrar(empresa, endereco);
		response.sendRedirect("empresa");

	}

}
