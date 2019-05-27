import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Base{

	final String driver = "com.mysql.cj.jdbc.Driver";
	final String url = "jdbc:mysql://localhost/e4"
			+ "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	final String user = "root";
	final String password = "";
	ResultSet res;
	public ResultSet executeRequete(String query)
	{
		try{
			Class.forName(driver).newInstance();
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			res = st.executeQuery(query);
			return res;
					
		}catch(Exception e){
			System.out.println("Erreur, " + e.getMessage());
			return null;
		}
	}
	
////////// VERIF LES LOGS EN BDD //////////////
	
public boolean verifLog(String deb, String fin) {
		
		Base c = new Base();
		
		String query = "select * from connexion where heured =deb and heuref = fin order by heured";
		
		ResultSet r3 = executeRequete(query);
		
		//$res = mysqli_query($id, $req);
		
		if(r3 == null ){
			
			System.out.println("requette is null");
			return false;
			
		}
		try {
			while (r3.next()) {
				String hdebut = r3.getString(3);
				String hfin = r3.getString(4);
				
				if (deb.equals(hdebut) && fin.equals(hfin) ) {
					return true;
				}
			}
			System.out.println("r2 not contain user");
		}
		
		catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
	return false;
	}

///////////////// VERIF QUE LUSER EST BIEN EN BDD //////////////
	
	public boolean verifUser(String login, String mdp) {
		
		Base c = new Base();
		
		String query = "select * from membre";
		ResultSet r2 = executeRequete(query);
		
		if (r2 == null) {
			System.out.println("requette is null");
			return false;
		}
		try {
			while (r2.next()) {
				String username = r2.getString(2);
				String pwd = r2.getString(4);
				if (login.equals(username) && mdp.equals(pwd) ){  
					return true;
				}
			}
			System.out.println("r2 not contain user");
			
		}
            
            catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
		return false;
		}
	
///////////// VERIF QUE LUSER A LE GRADE ADMIN ////////////////////
	
public boolean verifAdmin(String login, String mdp) {
		
		Base c = new Base();
		ResultSet r2 = c.executeRequete("SELECT * FROM membre WHERE login= '"+login+
        		"' and mdp='"+mdp+"' and grade= 'admin' ");
        try {
        	r2.last(); 
  			int nombreLignes = r2.getRow();	        			
  			r2.beforeFirst();     			
  			if(nombreLignes > 0) {
  				return true;
  			}else {
  				return false;
  			}
         /*   while(r2.next())
            {       
                    if(r2.getRow() < 1)
                    {
                        return false;
                    }
                    else {
                    	return true;
                    }
            }*/}
            
            catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	            
	        }
       return false; 
}

	
}
   
	