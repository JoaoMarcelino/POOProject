/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class Docente extends Pessoa{
    
    protected ArrayList<Estudante> arrayEstudantes = new ArrayList <>();
    
    private Projeto projeto;
    private int ip;
    private int numMecanografico;
    private String areaInvestigacao;
    
    public Docente(String nome, String email, int numMecanografico, String areaInvestigacao){
        super(nome, email);
        this.ip = 0;
        this.numMecanografico = numMecanografico;
        this.areaInvestigacao = areaInvestigacao;
    } 
    
    public void addEstudante(Estudante estudante){
        arrayEstudantes.add(estudante);
    }
    
    public void removeDocente(Estudante estudante){
        
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
    
    public void delProjeto() {
        Projeto projeto = new Projeto();
        
        this.projeto = projeto;
        this.ip = 0;
    }
}
