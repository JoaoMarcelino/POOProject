/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.Serializable;

/**
 * @author José Esperança 2018278596
 * @author João Marcelino 2018279700
 */
public abstract class Pessoa implements Serializable{
           
    private String nome;
    private String email;
    private float carga;
    
    /**
     * Construtor da pessoa
     * @param nome nome da pessoa
     * @param email email da pessoa
     */
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
}    