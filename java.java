package connection1;
 
import java.beans.Statement;
	import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 
/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * @author www.codejava.net and adjust by Nguyen Dinh Quan
 *
 */
public class test1 {
 
    public static void main(String[] args) {
 
        Connection conn = null;
        //ResultSet rs = null;
		//Statement stmt = null;

        
        try {
 
            String dbURL = "jdbc:sqlserver://localhost:52668;databaseName=QLBongDa;integratedSecurity=true;";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
               
                String query = " SELECT * FROM QUOCGIA";
                java.sql.Statement stmt = conn.createStatement();
				
                ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
                while(rs.next()) {
                	System.out.println(rs.getString(1) + "  " + rs.getString(2));
                }
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}


class queryDatabase{
	public void queryTableName() {
		
	}
	public void queryString(String str) {
		
	}
}
class insertDatabase{
	
}
