/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author José Esperança 2018278596
 * @author João Marcelino 2018279700
 */
public class Estudante extends Bolseiro{
    
    /**
     * array de docentes do estudante
     */
    protected ArrayList<Docente> arrayDocentes = new ArrayList <>();
    
    /**
     * Construtor do estudante
     * @param nome
     * @param email
     * @param inicioBolsa
     * @param fimBolsa
     * @param docente
     */
    public Estudante(String nome, String email, GregorianCalendar inicioBolsa, GregorianCalendar fimBolsa, Docente docente){
        super(nome,email,inicioBolsa,fimBolsa);
        arrayDocentes.add(docente);
    }
    
    /**
     * Adiciona um docente ao array no estudante
     * @param docente
     */
    public void addDocente(Docente docente){
        arrayDocentes.add(docente);
        docente.addEstudante(this);
    }
    
    /**
     * Remove um docente do array no estudante
     * @param docente
     */
    public void removeDocente(Docente docente){
        
        int indice = arrayDocentes.indexOf(docente);
       
        if (indice != -1)
            arrayDocentes.remove(indice);
        else
            System.out.println("ERRO -- DOCENTE NAO EXISTENTE");
    }
}
