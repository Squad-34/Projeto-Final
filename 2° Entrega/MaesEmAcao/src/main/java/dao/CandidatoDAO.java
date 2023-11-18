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
import model.Endereco;

public class CandidatoDAO {
	// adicionar
	public void cadastrar(Candidato candidato, Endereco endereco) {
		String sql = "INSERT INTO candidato (nome, email, cpf, telefone, idioma, formacao) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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

	public List<CandidatoEndereco> getCandidatoEndereco() {
		String sql = "SELECT c.*, e.* " + "FROM endereco e " + "JOIN candidato c ON e.fk_candidato = c.id_candidato";
		List<CandidatoEndereco> candidatos = new ArrayList<CandidatoEndereco>();
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
				Candidato candidato = new Candidato();
				candidato.setIdCandidato(rset.getInt("id_candidato"));
				candidato.setNome(rset.getString("nome"));
				candidato.setEmail(rset.getString("email"));
				candidato.setCpf(rset.getString("cpf"));
				candidato.setTelefone(rset.getString("telefone"));
				candidato.setIdioma(rset.getString("idioma"));
				candidato.setFormacao(rset.getString("formacao"));

				Endereco endereco = new Endereco();
				endereco.setIdEndereco(rset.getInt("id_endereco"));
				endereco.setCep(rset.getInt("cep"));
				endereco.setEstado(rset.getString("estado"));
				endereco.setCidade(rset.getString("cidade"));

				CandidatoEndereco candidatoEndereco = new CandidatoEndereco();
				candidatoEndereco.setCandidato(candidato);
				candidatoEndereco.setEndereco(endereco);

				candidatos.add(candidatoEndereco);
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
		return candidatos;
	}

	public void atualizar(Candidato candidato, Endereco endereco) {
		String sql = "UPDATE candidato SET nome = ?, email = ?, cpf = ?, telefone = ?, idioma = ?, formacao = ?"
				+ "WHERE id_candidato = ?";
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
			pstm.setInt(7, candidato.getIdCandidato());
			pstm.executeUpdate();

			String sqlEndereco = "UPDATE endereco SET cep = ?, estado = ?, cidade = ?" + "WHERE fk_candidato = ?";

			try (PreparedStatement statementEndereco = conn.prepareStatement(sqlEndereco)) {

				statementEndereco.setInt(1, endereco.getCep());
				statementEndereco.setString(2, endereco.getEstado());
				statementEndereco.setString(3, endereco.getCidade());
				statementEndereco.setInt(4, candidato.getIdCandidato());
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
		String sql = "DELETE FROM candidato WHERE id_candidato = ?";
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

	public CandidatoEndereco consultarById(int idCandidato) {

		CandidatoEndereco candidatoEndereco = new CandidatoEndereco();
		Candidato candidato = new Candidato();
		Endereco endereco = new Endereco();

		String sql = "SELECT c.*, e.* " + "FROM endereco e "
				+ "JOIN candidato c ON c.id_candidato = ? AND e.fk_candidato = c.id_candidato";
		;

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCandidato);

			rset = pstm.executeQuery();
			rset.next();
			candidato.setIdCandidato(rset.getInt("id_candidato"));
			candidato.setNome(rset.getString("nome"));
			candidato.setEmail(rset.getString("email"));
			candidato.setCpf(rset.getString("cpf"));
			candidato.setTelefone(rset.getString("telefone"));
			candidato.setIdioma(rset.getString("idioma"));
			candidato.setFormacao(rset.getString("formacao"));

			endereco.setIdEndereco(rset.getInt("id_endereco"));
			endereco.setCep(rset.getInt("cep"));
			endereco.setEstado(rset.getString("estado"));
			endereco.setCidade(rset.getString("cidade"));

			candidatoEndereco.setCandidato(candidato);
			candidatoEndereco.setEndereco(endereco);

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
		return candidatoEndereco;
	}
}
