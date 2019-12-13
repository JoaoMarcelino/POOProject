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
public class Doutorado extends Bolseiro{
    
    /**
     * Construtor da classe doutorado
     * @param nome
     * @param email
     * @param inicioBolsa
     * @param fimBolsa
     */
    public Doutorado(String nome, String email, GregorianCalendar inicioBolsa, GregorianCalendar fimBolsa){
        super(nome,email,inicioBolsa,fimBolsa);
        this.ordenado = 1200;
    }
}
