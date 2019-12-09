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
   
    private int ordenado;
    GregorianCalendar contrato;
    
    public Bolseiro(String nome, String email, GregorianCalendar contrato){
        super(nome,email);
        this.contrato = contrato;
    }    

    public int getOrdenado() {
        return this.ordenado;
    }
    public GregorianCalendar getContrato(){
        return this.contrato;
    }
}
