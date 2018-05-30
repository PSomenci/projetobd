/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Partido;

/**
 *
 * @author pedro
 */
public class PartidoDAO {
    
    private Connection con = null;

    public PartidoDAO() {
        con = ConnectionFactory.getConnection();
    }
 
    public void create(Partido p){
        
        //Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO partido (nome_partido, num_partido, data_criacao) VALUES (?,?,?)");
            stmt.setString(1, p.getNome_partido() );
            stmt.setInt(2, p.getNum_partido());
            stmt.setString(3, p.getData_criacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally {
           ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete (Partido p){
        String sql = "DELETE FROM partido WHERE num_partido = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(2, p.getNum_partido());
            stmt.executeUpdate();
            return true;            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
