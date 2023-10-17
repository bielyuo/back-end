package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Destino;
import modelos.Estadia;
import modelos.Viagem;

public class ViagemDAO {
	// create
	public void create(Viagem viagem) {

		String sql = "insert into viagem (nome ,valor, id_destino, id_estadia) values (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viagem.getNome());
			pstm.setFloat(2, viagem.getValor());
			pstm.setInt(3, viagem.getDestino().getId_destino());
			pstm.setInt(4, viagem.getEstadia().getId_estadia());
			
			
			System.out.println("Cadastro realizado");
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
	public List<Viagem> read() {
		
		List<Viagem> Voiagem = new ArrayList<Viagem>();
		String sql = "select * from viagem";
		

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Viagem viagem = new Viagem();
				int id_viagem = rset.getInt("id_viagem");
				int id_destino = rset.getInt("id_destino");
				int id_estadia = rset.getInt("id_estadia");
				
				DestinoDAO destinodao = new DestinoDAO();
				EstadiaDAO estadiadao = new EstadiaDAO();
				
				Destino destino = destinodao.readById(id_destino);
				Estadia estadia = estadiadao.readById(id_estadia);
	
				viagem.setId_viagem(rset.getInt("id_viagem"));			
				viagem.setDestino(destino);
				viagem.setEstadia(estadia);
				viagem.setNome(rset.getString("nome"));
				viagem.setValor(rset.getFloat("valor"));


				Voiagem.add(viagem);
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

		return Voiagem;
	}

	// update
	public void update(Viagem viagem) {
		String sql = "UPDATE viagem SET nome = ?, valor = ? WHERE id_viagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viagem.getNome());
			pstm.setInt(2, viagem.getId_viagem());
			pstm.setFloat(3, viagem.getValor());


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
	public void delete(int id) {
		String sql = "DELETE FROM viagem WHERE id_viagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

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

	// readById
	public Viagem readById(int id) {
		Viagem viagem = new Viagem();
		
		String sql = "select * from viagem WHERE id_viagem = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();
			

			int id_destino = rset.getInt("id_destino");
			int id_estadia = rset.getInt("id_estadia");
			
			DestinoDAO destinodao = new DestinoDAO();
			EstadiaDAO estadiadao = new EstadiaDAO();
			
			Destino destino = destinodao.readById(id_destino);
			Estadia estadia = estadiadao.readById(id_estadia);

			

			


			viagem.setDestino(destino);
			viagem.setEstadia(estadia);
			viagem.setNome(rset.getString("nome"));
			viagem.setValor(rset.getFloat("valor"));


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
		return viagem;
	}
}