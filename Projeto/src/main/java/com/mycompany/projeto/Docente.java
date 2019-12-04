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
    
    public Docente(String nome, String email){
        super(nome, email);
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

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
