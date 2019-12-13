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
public class Licenciado extends Estudante{
    
    /**
     * Construtor do Licenciado
     * @param nome nome da pessoa
     * @param email email da pessoa
     * @param inicioBolsa data de inicio da bolsa
     * @param fimBolsa data de fim da bolsa
     * @param docente docente do estudante
     */
    public Licenciado(String nome, String email, GregorianCalendar inicioBolsa, GregorianCalendar fimBolsa, Docente docente){
        super(nome,email,inicioBolsa,fimBolsa, docente);   
        this.ordenado = 800;
    }
}
