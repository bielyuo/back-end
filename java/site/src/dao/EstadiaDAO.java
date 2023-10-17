package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;

import modelos.Estadia;

public class EstadiaDAO {

	// create
	public void create(Estadia estadia) {

		String sql = "insert into Estadia (preco, nome) values (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setFloat(1, estadia.getPreco());
			pstm.setString(2, estadia.getNome());

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

	// read
	public List<Estadia> read() {
		List<Estadia> estadia = new ArrayList<Estadia>();
		String sql = "select * from estadia";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Estadia estadias = new Estadia();
				

				estadias.setId_estadia(rset.getInt("id_estadia"));
				estadias.setPreco(rset.getInt("preco"));
				estadias.setNome(rset.getString("nome"));

				estadia.add(estadias);
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

		return estadia;
	}

	// update
	public void update(Estadia estadia) {
		String sql = "UPDATE estadia SET nome = ?, preco = ? WHERE id_estadia = ?;";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, estadia.getNome());
			pstm.setFloat(2, estadia.getPreco());
			pstm.setInt(3, estadia.getId_estadia());
			
			

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

	// delete
	public void delete(int id_destino) {
		String sql = "DELETE FROM Estadia WHERE id_estadia = ?;";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_destino);

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

	// readById
	public Estadia readById(int id_destino) {
		Estadia estadias = new Estadia();
		String sql = "select * from Estadia WHERE id_estadia = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_destino);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			estadias.setId_estadia(rset.getInt("id_estadia"));
			estadias.setPreco(rset.getFloat("preco"));
			estadias.setNome(rset.getString("nome"));
			

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
		return estadias;
	}

}
