package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {

  String dbase = "service";
	String user = "root";
	String pwd = "Fallou45";
	String url = "jdbc:mysql://localhost:3306/"+dbase;
	
        Connection connection = null;

        public  Connection connecter(){
            
           try{
			      connection = DriverManager.getConnection(url, user, pwd);
			      System.out.println("Connexion reussi");
             return connection;
			 
		  }catch(SQLException e) {
			e.printStackTrace();
              return null;
		}
   }
}
