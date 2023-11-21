package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Vaga;

public class VagaDAO {
	// adicionar
	public void cadastrar(Vaga vaga) {
		String sql = "INSERT INTO vaga (titulo, descricao, requisito, salario, fk_empresa) " + "VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setString(1, vaga.getTitulo());
			pstm.setString(2, vaga.getDescricao());
			pstm.setString(3, vaga.getRequisito());
			pstm.setDouble(4, vaga.getSalario());
			pstm.setInt(5, vaga.getEmpresa().getIdEmpresa());
			pstm.executeUpdate();

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

	// listar
	public List<Vaga> listar() {
		String sql = "SELECT * FROM vaga";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<Vaga> vagas = new ArrayList<>();

		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Vaga vaga = new Vaga();
				vaga.setIdVaga(rset.getInt("id_vaga"));
				vaga.setTitulo(rset.getString("titulo"));
				vaga.setDescricao(rset.getString("descricao"));
				vaga.setRequisito(rset.getString("requisito"));
				vaga.setSalario(rset.getDouble("salario"));
				vaga.setEmpresa(new Empresa(rset.getInt("fk_empresa")));

				vagas.add(vaga);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
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

		return vagas;
	}

//listar pelo Id
	public Vaga consultarById(int idVaga) {
		String sql = "SELECT * FROM vaga WHERE id_vaga = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Vaga vaga = null;

		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idVaga);
			rset = pstm.executeQuery();

			if (rset.next()) {
				vaga = new Vaga();
				vaga.setIdVaga(rset.getInt("id_vaga"));
				vaga.setTitulo(rset.getString("titulo"));
				vaga.setDescricao(rset.getString("descricao"));
				vaga.setRequisito(rset.getString("requisito"));
				vaga.setSalario(rset.getDouble("salario"));
				vaga.setEmpresa(new Empresa(rset.getInt("fk_empresa")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
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

		return vaga;
	}

//deletar
	public void removerByid(int id) {
		String sql = "DELETE FROM vaga WHERE id_vaga = ?";
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

//atualizar
	public void atualizar(Vaga vaga) {
		String sql = "UPDATE vaga SET titulo = ?, descricao = ?, requisito = ?, salario = ?, WHERE id_vaga = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vaga.getTitulo());
			pstm.setString(2, vaga.getDescricao());
			pstm.setString(3, vaga.getRequisito());
			pstm.setDouble(4, vaga.getSalario());
			pstm.setInt(5, vaga.getIdVaga());
			pstm.executeUpdate();
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

}
