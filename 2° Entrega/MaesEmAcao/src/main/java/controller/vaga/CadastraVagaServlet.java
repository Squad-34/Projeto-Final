package controller.vaga;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VagaDAO;
import model.Empresa;
import model.Vaga;

@WebServlet("/vaga-cadastrar")
public class CadastraVagaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VagaDAO vagaDao = new VagaDAO();
	Vaga vaga = new Vaga();
	Empresa empresa = new Empresa();

	public CadastraVagaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		cadastrar(request, response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vaga.setTitulo(request.getParameter("titulo"));
		vaga.setDescricao(request.getParameter("descricao"));
		vaga.setRequisito(request.getParameter("requisito"));
		vaga.setSalario(Double.parseDouble(request.getParameter("salario")));
		int id = Integer.parseInt(request.getParameter("idCandidato"));
		empresa.setIdEmpresa(id);
		vaga.setEmpresa(empresa);
		vagaDao.cadastrar(vaga);
		response.sendRedirect("empresa");

	}

}
