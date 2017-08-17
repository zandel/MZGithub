package mz_A_One;

import java.sql.*;

public class DBConnection {
/**	
	public static void main( String[] args ) {
		//connectDB();
	}	
	**/
	
	
	public void registerDetails( int tempID, String tempUsername, String tempPassword ) {
		//String dbUrl = "jdbc:mysql://localhost:3306/onlinejobseek";
		String dbUrl = "jdbc:mysql://localhost/onlinejobseek";
		String user = "root";
		String password = "";
		
		try {
			Connection myConn = DriverManager.getConnection( dbUrl, user, password );
			Statement myStmt = myConn.createStatement();
			
			PreparedStatement pstmt = myConn.prepareStatement( "INSERT INTO Student_Login( Student_ID, "
					+ "Student_Name, Student_Password ) VALUES (?, ?, ?)" );
					
			
			/** -------- debug only
			PreparedStatement pstmt = myConn.prepareStatement( "INSERT INTO Student_Login( Student_ID, "
					+ "Student_Name, Student_Password ) VALUES (101, 'zok1', 'zok1pwd')" );
					****/
			
			pstmt.setInt( 1, tempID );
			pstmt.setString( 2, tempUsername );
			pstmt.setString( 3, tempPassword );
			
			
			pstmt.executeUpdate();						
			
			myStmt.close();
			myConn.close();
			
		} catch( Exception e) {
			e.printStackTrace();
		}

		
	}

}
