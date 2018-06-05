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
public class Urna {

    private Eleitor cpf;
    private int voto;

    public Eleitor getCpf() {
        return cpf;
    }

    public void setCpf(Eleitor cpf) {
        this.cpf = cpf;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

}
