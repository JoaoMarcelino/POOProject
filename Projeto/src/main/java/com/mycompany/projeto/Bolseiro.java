/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

/**
 *
 * @author hp
 */
public abstract class Bolseiro extends Pessoa{
   
    private int ordenado;
    
    public Bolseiro(String nome, String email){
        super(nome,email);
    }    

    public int getOrdenado() {
        return ordenado;
    }
}
