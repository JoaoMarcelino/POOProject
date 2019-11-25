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
public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected ArrayList<Tarefa> ArrayTarefa = new ArrayList <Tarefa>();
    
    protected Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
}
