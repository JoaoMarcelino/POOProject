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
public class Doutorado extends Bolseiro{
    
    private int ordenado;
    
    public Doutorado(String nome, String email,GregorianCalendar contrato){
        super(nome,email,contrato);
        this.ordenado = 1200;
    }
}
