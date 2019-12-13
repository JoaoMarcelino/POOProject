/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public abstract class Pessoa implements Serializable{
    
    //protected ArrayList<Tarefa> arrayTarefas = new ArrayList <>();
        
    private String nome;
    private String email;
    private float carga;
    
    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.carga = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
    public float getCarga(){
        return carga;
    }
    /*
    public void addTarefa(Tarefa tarefa){
        this.carga += tarefa.getTaxaEsforco();
    }
    
    public void addCarga(float n){
        this.carga += n;
    }
    
    public void removeTarefa(Tarefa tarefa){
        this.carga -= tarefa.getTaxaEsforco();
    }
    
    public void removeCarga(float n){
        this.carga += n;
    }
    */
    
}    