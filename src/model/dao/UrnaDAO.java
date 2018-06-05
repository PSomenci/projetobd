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
import model.bean.Urna;

/**
 *
 * @author pedro somente inserir
 */
public class UrnaDAO {

    private Connection con = null;

    public UrnaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void create(Urna u) {

        //Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO urna (cpf, voto) VALUES (?,?)");
            stmt.setString(1, u.getCpf().getCpf());
            stmt.setInt(2, u.getVoto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
