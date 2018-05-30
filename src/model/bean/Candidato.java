/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author pedro
 */
public class Candidato {

    private String nome_candidato;
    private int num_candidato;
    private String cargo;
    private Partido num_partido;

    public String getNome_candidato() {
        return nome_candidato;
    }

    public void setNome_candidato(String nome_candidato) {
        this.nome_candidato = nome_candidato;
    }

    public int getNum_candidato() {
        return num_candidato;
    }

    public void setNum_candidato(int num_candidato) {
        this.num_candidato = num_candidato;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Partido getNum_partido() {
        return num_partido;
    }

    public void setNum_partido(Partido num_partido) {
        this.num_partido = num_partido;
    }

   

}
