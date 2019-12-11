/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.GregorianCalendar;

/**
 *
 * @author hp
 */
public abstract class Bolseiro extends Pessoa{
   
    protected int ordenado;
    GregorianCalendar inicioBolsa;
    GregorianCalendar fimBolsa;
    
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
}
