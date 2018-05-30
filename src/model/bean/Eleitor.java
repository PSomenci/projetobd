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
public class Eleitor {

    private String nome_eleitor;
    private int cpf;
    private int cep;
    private int zona;
    private int secao;
    private String data_nasc;
    private String rua;
    private String bairro;
    private String numero;
    private Urna cod_voto;

    public String getNome_eleitor() {
        return nome_eleitor;
    }

    public void setNome_eleitor(String nome_eleitor) {
        this.nome_eleitor = nome_eleitor;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getSecao() {
        return secao;
    }

    public void setSecao(int secao) {
        this.secao = secao;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Urna getCod_voto() {
        return cod_voto;
    }

    public void setCod_voto(Urna cod_voto) {
        this.cod_voto = cod_voto;
    }

    

    
}
