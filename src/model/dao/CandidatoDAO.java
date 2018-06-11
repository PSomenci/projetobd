/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Candidato;

/**
 *
 * @author pedro
 * inserir
 * modificar
 * deletar
 */
public class CandidatoDAO {
    
    private Connection con = null;

    public CandidatoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void create(Candidato c) {

        //Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO candidato (nome_candidato, cargo, num_candidato, num_partido) VALUES (?,?,?,123)");
            stmt.setString(1, c.getNome_candidato());
            stmt.setInt(2, c.getNum_candidato());
            stmt.setString(3, c.getCargo());
            stmt.setInt(4, c.getNum_partido().getNum_partido());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean update(Candidato c){
        
        String sql = "UPDATE candidato SET nome_candidato = ? cargo = ? WHERE num_cadidato = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome_candidato());
            stmt.setString(2, c.getCargo());
            stmt.setInt(3, c.getNum_candidato());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete (Candidato c){
        String sql = "DELETE FROM candidato WHERE num_candidato = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getNum_candidato());
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
