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
 * @author pedro inserir deletar modificar
 */
public class EleitorDAO {

    private Connection con = null;

    public EleitorDAO() {
        con = ConnectionFactory.getConnection();
    }

    public void create(Eleitor e) {

        //Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO eleitor (nome_eleitor, cpf, cep, zona, secao, data_nasc, rua, bairro, numero) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, e.getNome_eleitor());
            stmt.setString(2, e.getCpf());
            stmt.setString(3, e.getCep());
            stmt.setInt(4, e.getZona());
            stmt.setInt(5, e.getSecao());
            stmt.setString(6, e.getData_nasc());
            stmt.setString(7, e.getRua());
            stmt.setString(8, e.getBairro());
            stmt.setString(9, e.getNumero());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Eleitor e) {

        String sql = "UPDATE eleitor SET nome_eleitor = ? cep = ? zona = ? secao = ? data_nasc = ? rua = ? bairro = ? numero = ? WHERE cpf = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getNome_eleitor());
            stmt.setString(2, e.getCep());
            stmt.setInt(3, e.getZona());
            stmt.setInt(4, e.getSecao());
            stmt.setString(5, e.getData_nasc());
            stmt.setString(6, e.getRua());
            stmt.setString(7, e.getBairro());
            stmt.setString(8, e.getNumero());
            stmt.setString(9, e.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Eleitor e) {
        String sql = "DELETE FROM eleitor WHERE cpf = ?";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getCpf());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
