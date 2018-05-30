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
import javax.swing.JOptionPane;
import model.bean.Eleitor;

/**
 *
 * @author pedro
 */
public class EleitorDAO {
    
    private Connection con = null;

    public EleitorDAO() {
        con = ConnectionFactory.getConnection();
    }
    
         public void create(Eleitor e){
        
        //Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO eleitor (nome_eleitor, cpf, zona, secao, data_nasc, rua, bairro, numero, cep) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, e.getNome_eleitor());
            stmt.setInt(2, e.getCpf());
            stmt.setInt(3, e.getZona());
            stmt.setInt(4, e.getSecao());
            stmt.setString(5, e.getData_nasc());
            stmt.setString(6, e.getRua());
            stmt.setString(7, e.getBairro());
            stmt.setString(8, e.getNumero());
            stmt.setInt(9, e.getCep());
            //stmt.setInt(10, e.getCod_voto().getCod_voto());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally {
           ConnectionFactory.closeConnection(con, stmt);
        }
    }
         
    public boolean update(Eleitor e){
        
        String sql = "UPDATE categoria SET nome_eleitor = ? cpf = ? zona = ? secao = ? data_nasc = ? rua = ? bairro = ? numero = ? cep = ? WHERE cpf = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getNome_eleitor());
            stmt.setInt(2, e.getCpf());
            stmt.setInt(3, e.getZona());
            stmt.setInt(4, e.getSecao());
            stmt.setString(5, e.getData_nasc());
            stmt.setString(6, e.getRua());
            stmt.setString(7, e.getBairro());
            stmt.setString(8, e.getNumero());
            stmt.setInt(9, e.getCep());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete (Eleitor e){
        String sql = "DELETE FROM eleitor WHERE cpf = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(2, e.getCpf());
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
