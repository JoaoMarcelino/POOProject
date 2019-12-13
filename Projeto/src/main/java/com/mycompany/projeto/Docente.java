/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.ArrayList;

/**
 * @author José Esperança 2018278596
 * @author João Marcelino 2018279700
 */
public class Docente extends Pessoa{
    
    /**
     * array de estudantes do docente
     */
    protected ArrayList<Estudante> arrayEstudantes = new ArrayList <>();
    
    private Projeto projeto;
    private int ip;
    private int numMecanografico;
    private String areaInvestigacao;
    
    /**
     * Construtor do Docente
     * @param nome nome do docente
     * @param email email do docnete
     * @param numMecanografico numero mecanografico do docente
     * @param areaInvestigacao area da investigacao do docente
     */
    public Docente(String nome, String email, int numMecanografico, String areaInvestigacao){
        super(nome, email);
        this.ip = 0;
        this.numMecanografico = numMecanografico;
        this.areaInvestigacao = areaInvestigacao;
    } 


    public int getNumMecanografico() {
        return numMecanografico;
    }

    public String getAreaInvestigacao() {
        return areaInvestigacao;
    }
    
    /**
     * Adiciona um estudante ao array
     * @param estudante objeto estudante
     */
    public void addEstudante(Estudante estudante){
        arrayEstudantes.add(estudante);
    }
    
    /**
     * Remove um estudante do array
     * @param estudante objeto estudante
     */
    public void removeEstudante(Estudante estudante){
        
        int indice = arrayEstudantes.indexOf(estudante);
       
        if (indice != -1)
            arrayEstudantes.remove(indice);
        else
            System.out.println("ERRO -- ESTUDANTE NAO EXISTENTE");
    }

    public Projeto getProjeto() {
        return projeto;
    }
    
    public int getIP(){
        return this.ip;
    }
    
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
        this.ip = 1;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }
    
    public void delProjeto() {

        this.projeto = null;
        this.ip = 0;
    }
}
