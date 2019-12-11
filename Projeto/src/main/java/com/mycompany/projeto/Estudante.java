/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author hp
 */
public class Estudante extends Bolseiro{
    
    protected ArrayList<Docente> arrayDocentes = new ArrayList <>();
    
    public Estudante(String nome, String email, GregorianCalendar inicioBolsa, GregorianCalendar fimBolsa, Docente docente){
        super(nome,email,inicioBolsa,fimBolsa);
        arrayDocentes.add(docente);
    }
    
    public void addDocente(Docente docente){
        arrayDocentes.add(docente);
        docente.addEstudante(this);
    }
    
    public void removeDocente(Docente docente){
        
        int indice = arrayDocentes.indexOf(docente);
       
        if (indice != -1)
            arrayDocentes.remove(indice);
        else
            System.out.println("ERRO -- DOCENTE NAO EXISTENTE");
    }
}
