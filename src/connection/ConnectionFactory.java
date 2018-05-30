/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class ConnectionFactory {
    
        private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
        private static final String URL = "jdbc:oracle:thin:@200.145.158.211:1521:XE";
        private static final String USER = "ldcjfunior";
        private static final String PASS = "junior";
        
        public  static Connection getConnection(){
            try {
                Class.forName(DRIVER);
                
                return DriverManager.getConnection(URL, USER, PASS);
                
                
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException("Erro na conexão: ", ex);
            }
            
            
        }
        
        public static void closeConnection(Connection con){
            try {
                if (con != null){
                    con.close();
                }
            } catch (SQLException ex) {
                    throw new RuntimeException("Erro na desconexão: ", ex);
                }
            }
        public static void closeConnection(Connection con, PreparedStatement stmt){
            
            closeConnection(con);
            
            try {
                if(stmt != null ){
                   stmt.close();
                   
                }
            } catch (SQLException ex) {
                    throw new RuntimeException("Erro na desconexão: ", ex);
                }
            }
        public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
            
            closeConnection(con, stmt);
            
            try {
                if(rs != null ){
                   rs.close();
                   
                }
            } catch (SQLException ex) {
                    throw new RuntimeException("Erro na desconexão: ", ex);
                }
            }
        }
 
