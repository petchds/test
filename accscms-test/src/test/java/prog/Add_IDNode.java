package prog;


import java.sql.*;
import java.util.ArrayList;

import javax.sql.DataSource;

public class Add_IDNode{

	public Add_IDNode() {
		Connection conn = null;
		
	    String url = "jdbc:mysql://localhost:3306/";
	    String dbName = "accscmstest";
	    String driver = "com.mysql.jdbc.Driver";
	    String userName = "root";
	    String password = "1234";
	    conn = ConnectionMysql(url, dbName, driver, userName, password);
	    ArrayList<String> arrayTable =  new ArrayList<String>();
	    try {
			arrayTable = getTables(conn);
			add_id2(conn,dbName,arrayTable);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	}
	
	
	private static void add_id2(java.sql.Connection conn2,String databaseName ,ArrayList<String> arrayTable) throws SQLException {
		
	//	ALTER TABLE `testcase2`.`received_control_number` ADD COLUMN `id_2` VARCHAR(45) NOT NULL AFTER `number`;
		Statement st = conn2.createStatement();
		
		ArrayList<String> errorArray = new ArrayList<String>();
				
				for (String tableName : arrayTable) {
				try {
						String sqlupdate = " ALTER TABLE `"+databaseName+"`. "+
						"`"+ tableName +"` "+
						" ADD COLUMN `id2` VARCHAR(45)"+
						" NOT NULL AFTER `id` ";
						st.executeUpdate(sqlupdate);
						
						System.out.println("Add Column id2 " + tableName);
					} catch (SQLException sqlException) {
						errorArray.add(sqlException.getMessage() +" " +tableName);
						System.out.println(	sqlException.getMessage());
						
					}
					
				}
					System.out.println("#################################");
					for (String error : errorArray) {
						System.out.println(error.toString());
					}
					System.out.println("#################################");
					
		}
	
  
  	public static ArrayList<String> getTables(Connection conn) throws SQLException{
  	
		DatabaseMetaData dbm = conn.getMetaData();
		String[] types = {"TABLE"};
		ResultSet rs = dbm.getTables(null,null,"%",types);
		ArrayList<String> arrayTable =   new ArrayList<String>();
		while (rs.next()){
		String table = rs.getString("TABLE_NAME");
		arrayTable.add(table);
		}
		return arrayTable;
			
  	}

	public static Connection ConnectionMysql(String url,String dbName,String driver,String userName ,String password){
		
		System.out.println("MySQL Connect Example.");
        Connection conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
             } catch (Exception e) {
            e.printStackTrace();
        }
       return conn; 
	}
}