package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.CandidatoEndereco;
import model.Empresa;
import model.EmpresaEndereco;
import model.Endereco;

public class EmpresaDAO {

	public void cadastrar(Empresa empresa, Endereco endereco) {
		String sql = "INSERT INTO empresa (nome, cnpj, email, telefone)" + " VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, empresa.getNome());
			pstm.setString(2, empresa.getCnpj());
			pstm.setString(3, empresa.getEmail());
			pstm.setString(4, empresa.getTelefone());
			pstm.executeUpdate();

			int id;

			try (var resultSet = pstm.getGeneratedKeys()) {
				if (resultSet.next()) {
					id = resultSet.getInt(1);
				} else {
					throw new SQLException("Falha ao obter o ID da empresa.");
				}
			}

			String sqlEndereco = "INSERT INTO endereco (cep, estado, cidade, fk_empresa) " + "VALUES (?, ?, ?, ?)";

			try (PreparedStatement statementEndereco = conn.prepareStatement(sqlEndereco)) {

				statementEndereco.setInt(1, endereco.getCep());
				statementEndereco.setString(2, endereco.getEstado());
				statementEndereco.setString(3, endereco.getCidade());
				statementEndereco.setInt(4, id);
				statementEndereco.executeUpdate();
			}

		} catch (Exception e) {
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<EmpresaEndereco> getEmpresaEndereco() {
		String sql = "SELECT emp.*, e.* " + "FROM endereco e " + "JOIN empresa emp ON e.fk_empresa = emp.id_empresa";
		List<EmpresaEndereco> empresas = new ArrayList<EmpresaEndereco>();
		Connection conn = null;
		PreparedStatement pstm = null;
		// classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// enquanto existir dados no banco de dados faça
			while (rset.next()) {
				Empresa empresa = new Empresa();
				empresa.setIdEmpresa(rset.getInt("id_empresa"));
				empresa.setNome(rset.getString("nome"));
				empresa.setEmail(rset.getString("email"));
				empresa.setCnpj(rset.getString("cnpj"));
				empresa.setTelefone(rset.getString("telefone"));

				Endereco endereco = new Endereco();
				endereco.setIdEndereco(rset.getInt("id_endereco"));
				endereco.setCep(rset.getInt("cep"));
				endereco.setEstado(rset.getString("estado"));
				endereco.setCidade(rset.getString("cidade"));

				EmpresaEndereco empresaEndereco = new EmpresaEndereco();
				empresaEndereco.setEmpresa(empresa);
				empresaEndereco.setEndereco(endereco);

				empresas.add(empresaEndereco);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return empresas;
	}

	public void atualizar(Empresa empresa, Endereco endereco) {
		String sql = "UPDATE empresa SET nome = ?, email = ?, cnpj = ?, telefone = ?" + "WHERE id_empresa = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, empresa.getNome());
			pstm.setString(2, empresa.getEmail());
			pstm.setString(3, empresa.getCnpj());
			pstm.setString(4, empresa.getTelefone());
			pstm.setInt(5, empresa.getIdEmpresa());
			pstm.executeUpdate();

			String sqlEndereco = "UPDATE endereco SET cep = ?, estado = ?, cidade = ?" + "WHERE fk_empresa = ?";

			try (PreparedStatement statementEndereco = conn.prepareStatement(sqlEndereco)) {

				statementEndereco.setInt(1, endereco.getCep());
				statementEndereco.setString(2, endereco.getEstado());
				statementEndereco.setString(3, endereco.getCidade());
				statementEndereco.setInt(4, empresa.getIdEmpresa());
				statementEndereco.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removerByid(int id) {
		String sql = "DELETE FROM empresa WHERE id_empresa = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public EmpresaEndereco consultarById(int idEmpresa) {

		EmpresaEndereco empresaEndereco = new EmpresaEndereco();
		Empresa empresa = new Empresa();
		Endereco endereco = new Endereco();

		String sql = "SELECT emp.*, e.* " + "FROM endereco e "
				+ "JOIN empresa emp ON emp.id_empresa = ? AND e.fk_empresa = emp.id_empresa";
		;

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idEmpresa);

			rset = pstm.executeQuery();
			rset.next();
			empresa.setIdEmpresa(rset.getInt("id_empresa"));
			empresa.setNome(rset.getString("nome"));
			empresa.setEmail(rset.getString("email"));
			empresa.setCnpj(rset.getString("cnpj"));
			empresa.setTelefone(rset.getString("telefone"));

			endereco.setIdEndereco(rset.getInt("id_endereco"));
			endereco.setCep(rset.getInt("cep"));
			endereco.setEstado(rset.getString("estado"));
			endereco.setCidade(rset.getString("cidade"));

			empresaEndereco.setEmpresa(empresa);
			empresaEndereco.setEndereco(endereco);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return empresaEndereco;
	}
}
