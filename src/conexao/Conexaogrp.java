package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexaogrp {

	private static final String USARNAME = "root";
	private static final String PASSEWORD = "Laite@147426Almu";
	private static final String CONN_STRING="jdbc:mysql://localhost:3306/contacto";
	
//	
	
	public static Connection grupo() {
	
		Connection grup = null;
		
		try {
			grup = DriverManager.getConnection(CONN_STRING,USARNAME,PASSEWORD);
			return grup;
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, e);
		} 
		return null;
		
		
		
		
	}
}
