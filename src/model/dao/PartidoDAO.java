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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Partido;
import view.ViewPartido;

/**
 *
 * @author pedro inserir deletar modificar
 */
public class PartidoDAO {

    private Connection con = null;

    public PartidoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void create(Partido p) {

        //Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO partido (nome_partido, numero_partido) VALUES (?,?)");
            stmt.setString(1, p.getNome_partido());
            stmt.setInt(2, p.getNum_partido());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(new ViewPartido(), "Salvo com sucesso!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Partido p) {
        String sql = "DELETE FROM partido WHERE numero_partido = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getNum_partido());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(new ViewPartido(), "Deletado com sucesso!!");
            return true;              
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Partido c) {

        String sql = "UPDATE partido SET nome_partido = ? WHERE numero_partido = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome_partido());
            stmt.setInt(2, c.getNum_partido());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(new ViewPartido(), "Alterado com sucesso!!");
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List <Partido> findAll(){
        
        String sql = "SELECT * FROM partido";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Partido> partidos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Partido p = new Partido();           
                p.setNome_partido(rs.getString("nome_partido"));
                p.setNum_partido(rs.getInt("numero_partido"));
                partidos.add(p);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
            }
        return partidos;
    }

}
