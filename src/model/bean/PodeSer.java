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
public class PodeSer {
    
    private Eleitor cpf;
    private Candidato num_candidato;

    public Eleitor getCpf() {
        return cpf;
    }

    public void setCpf(Eleitor cpf) {
        this.cpf = cpf;
    }

    public Candidato getNum_candidato() {
        return num_candidato;
    }

    public void setNum_candidato(Candidato num_candidato) {
        this.num_candidato = num_candidato;
    }
    
    
}
