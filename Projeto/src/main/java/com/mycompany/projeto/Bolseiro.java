/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.GregorianCalendar;

/**
 * @author José Esperança 2018278596
 * @author João Marcelino 2018279700
 */

public abstract class Bolseiro extends Pessoa{
   
    /**
     * int para ser herdado e alterado pelas subclasses
     */
    
    protected int ordenado;
    private int used;
    private GregorianCalendar inicioBolsa;
    private GregorianCalendar fimBolsa;
    
    /**
     * Construtor da classe Bolseiro
     * @param nome
     * @param email
     * @param inicioBolsa
     * @param fimBolsa
     */
    
    public Bolseiro(String nome, String email, GregorianCalendar inicioBolsa, GregorianCalendar fimBolsa){
        super(nome,email);
        this.inicioBolsa = inicioBolsa;
        this.fimBolsa = fimBolsa;
    }    
    
    public int getOrdenado() {
        return this.ordenado;
    }
    public GregorianCalendar getInicioBolsa(){
        return this.inicioBolsa;
    }

    public GregorianCalendar getFimBolsa() {
        return fimBolsa;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed() {
        this.used = 1;
    }
    
}
