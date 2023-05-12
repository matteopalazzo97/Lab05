package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		
		final String sql = "SELECT parola.`nome` "
				+ "FROM parola "
				+ "WHERE parola.nome = ?";
		
		boolean corretta = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				
				//System.out.println("Forse funziona");
				corretta = true;
				return corretta;
				
			}
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return corretta;
		
	}

}
