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
public class Mestre extends Estudante{
    
    private int ordenado;
    
    protected Mestre(String nome, String email, GregorianCalendar inicioBolsa, GregorianCalendar fimBolsa, Docente docente){
        super(nome,email, inicioBolsa,fimBolsa, docente);
        this.ordenado = 1000;
    }
}
