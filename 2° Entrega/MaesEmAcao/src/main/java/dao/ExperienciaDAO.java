package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.Experiencia;

public class ExperienciaDAO {

	// adicionar
	public void cadastrar(Experiencia experiencia) {
		String sql = "INSERT INTO Experiencia (nome_empresa, cargo, data_inicio, data_fim, fk_candidato) "
				+ "VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, experiencia.getNomeEmpresa());
			pstm.setString(2, experiencia.getCargo());

			LocalDate dataInicio = experiencia.getDataInicio();
			java.sql.Date sqlDateInicio = java.sql.Date.valueOf(dataInicio);
			pstm.setDate(3, sqlDateInicio);

			LocalDate dataFinal = experiencia.getDataFinal();
			java.sql.Date sqlDateFinal = java.sql.Date.valueOf(dataFinal);
			pstm.setDate(4, sqlDateFinal);
			pstm.setInt(5, experiencia.getCandidato().getIdCandidato());
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

	public List<Experiencia> getExperiencia() {
		String sql = "SELECT * FROM Experiencia";
		List<Experiencia> experiencias = new ArrayList<Experiencia>();
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

				Experiencia experiencia = new Experiencia();
				Candidato candidato = new Candidato();

				experiencia.setIdExperiencia(rset.getInt("id_experiencia"));
				experiencia.setNomeEmpresa(rset.getString("nome_empresa"));
				experiencia.setCargo(rset.getString("cargo"));

				java.sql.Date sqlDate = rset.getDate("data_inicio");
				LocalDate dataInicio = sqlDate.toLocalDate();
				experiencia.setDataInicio(dataInicio);

				java.sql.Date sqlDate1 = rset.getDate("data_fim");
				LocalDate dataFinal = sqlDate1.toLocalDate();
				experiencia.setDataFinal(dataFinal);

				candidato.setIdCandidato(rset.getInt("fk_candidato"));
				experiencia.setCandidato(candidato);

				experiencias.add(experiencia);
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
		return experiencias;
	}
	
	public void atualizar(Experiencia experiencia) {
		String sql = "UPDATE Experiencia SET nome_empresa = ?, cargo = ?, data_inicio = ?, data_fim = ?"
				+ "WHERE id_experiencia = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, experiencia.getNomeEmpresa());
			pstm.setString(2, experiencia.getCargo());

			LocalDate dataInicio = experiencia.getDataInicio();
			java.sql.Date sqlDateInicio = java.sql.Date.valueOf(dataInicio);
			pstm.setDate(3, sqlDateInicio);

			LocalDate dataFinal = experiencia.getDataFinal();
			java.sql.Date sqlDateFinal = java.sql.Date.valueOf(dataFinal);
			pstm.setDate(4, sqlDateFinal);
			pstm.setInt(5, experiencia.getIdExperiencia());
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

	public Experiencia consultarById(int id) {
		Experiencia experiencia = new Experiencia();
		String sql = "SELECT * FROM experiencia WHERE fk_candidato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();
			experiencia.setIdExperiencia(rset.getInt("id_experiencia"));
			experiencia.setNomeEmpresa(rset.getString("nome_empresa"));
			experiencia.setCargo(rset.getString("cargo"));

			java.sql.Date sqlDate = rset.getDate("data_inicio");
			LocalDate dataInicio = sqlDate.toLocalDate();
			experiencia.setDataInicio(dataInicio);

			java.sql.Date sqlDate1 = rset.getDate("data_fim");
			LocalDate dataFinal = sqlDate1.toLocalDate();
			experiencia.setDataFinal(dataFinal);

			Candidato candidato = new Candidato();
			candidato.setIdCandidato(rset.getInt("fk_candidato"));
			experiencia.setCandidato(candidato);

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
		return experiencia;
	}
}
