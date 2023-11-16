package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import model.Candidato;
import model.Endereco;

public class CandidatoDAO {
	// adicionar
	public void cadastrar(Candidato candidato, Endereco endereco) {
		String sql = "INSERT INTO candidado (nome, email, cpf, telefone, idioma, formação) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, candidato.getNome());
			pstm.setString(2, candidato.getEmail());
			pstm.setString(3, candidato.getCpf());
			pstm.setString(4, candidato.getTelefone());
			pstm.setString(5, candidato.getIdioma());
			pstm.setString(6, candidato.getFormacao());
			pstm.executeUpdate();

			int id;

			try (var resultSet = pstm.getGeneratedKeys()) {
				if (resultSet.next()) {
					id = resultSet.getInt(1);
				} else {
					throw new SQLException("Falha ao obter o ID do cliente.");
				}
			}

			String sqlEndereco = "INSERT INTO endereco (cep, estado, cidade, fk_candidato) " + "VALUES (?, ?, ?, ?)";

			try (PreparedStatement statementEndereco = conn.prepareStatement(sqlEndereco)) {

				pstm.setInt(1, endereco.getCep());
				pstm.setString(2, endereco.getEstado());
				pstm.setString(3, endereco.getCidade());
				pstm.setInt(4, id);
				pstm.executeUpdate();
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

	/*
	 * public List<Cliente> getCliente() { String sql = "SELECT * FROM cliente";
	 * List<Cliente> cliente = new ArrayList<Cliente>(); Connection conn = null;
	 * PreparedStatement pstm = null; // classe que vai recuperar os dados do banco
	 * de dados ResultSet rset = null; try { conn =
	 * Conexao.createConnectionToMySql(); pstm = conn.prepareStatement(sql); rset =
	 * pstm.executeQuery(); // enquanto existir dados no banco de dados faça while
	 * (rset.next()) { Cliente client = new Cliente();
	 * client.setCpf(rset.getString("CPF_Cliente"));
	 * client.setNome(rset.getString("Nome_Cliente"));
	 * client.setEmail(rset.getString("Email_Cliente"));
	 * client.setTelefone(rset.getString("Telefone_Cliente")); cliente.add(client);
	 * } } catch (Exception e) { e.printStackTrace(); } finally { try { if (pstm !=
	 * null) { pstm.close(); } if (conn != null) { conn.close(); } } catch
	 * (Exception e) { e.printStackTrace(); } } return cliente; }
	 * 
	 * public void atualizar(Cliente cliente) { String sql =
	 * "UPDATE cliente SET Nome_Cliente = ?, Email_Cliente = ?, Telefone_Cliente = ?"
	 * + "WHERE CPF_Cliente = ?"; Connection conn = null; PreparedStatement pstm =
	 * null; try { conn = Conexao.createConnectionToMySql(); pstm =
	 * conn.prepareStatement(sql); pstm.setString(1, cliente.getNome());
	 * pstm.setString(2, cliente.getEmail()); pstm.setString(3,
	 * cliente.getTelefone()); pstm.setString(4, cliente.getCpf()); pstm.execute();
	 * } catch (Exception e) { e.printStackTrace(); } finally { try { if (pstm !=
	 * null) { pstm.close(); } if (conn != null) { conn.close(); } } catch
	 * (Exception e) { e.printStackTrace(); } } }
	 * 
	 * // exluir public void removerByCpf(String cpf) { String sql =
	 * "DELETE FROM cliente WHERE CPF_Cliente = ?"; Connection conn = null;
	 * PreparedStatement pstm = null; try { conn =
	 * Conexao.createConnectionToMySql(); pstm = conn.prepareStatement(sql);
	 * pstm.setString(1, cpf); pstm.execute(); } catch (Exception e) {
	 * e.printStackTrace(); } finally { try { if (pstm != null) { pstm.close(); } if
	 * (conn != null) { conn.close(); } } catch (Exception e) { e.printStackTrace();
	 * } } } public Cliente consultarByCpf(String cpf) { Cliente cliente = new
	 * Cliente(); String sql = "SELECT * FROM cliente WHERE CPF_Cliente = ?";
	 * 
	 * Connection conn = null; PreparedStatement pstm = null; ResultSet rset = null;
	 * 
	 * try { conn = Conexao.createConnectionToMySql(); pstm =
	 * conn.prepareStatement(sql); pstm.setString(1, cpf);
	 * 
	 * rset = pstm.executeQuery(); rset.next();
	 * cliente.setCpf(rset.getString("CPF_Cliente"));
	 * cliente.setNome(rset.getString("Nome_Cliente"));
	 * cliente.setEmail(rset.getString("Email_Cliente"));
	 * cliente.setTelefone(rset.getString("Telefone_Cliente"));
	 * 
	 * pstm.execute(); } catch (Exception e) { e.printStackTrace(); } finally { try
	 * { if (pstm != null) { pstm.close(); } if (conn != null) { conn.close(); } }
	 * catch (Exception e) { e.printStackTrace(); } } return cliente; }
	 */

}
