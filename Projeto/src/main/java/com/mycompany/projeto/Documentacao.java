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
public class Documentacao extends Tarefa{
    
    private float taxaEsforco = (float) 0.25; 
            
    public Documentacao(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, int progresso) {
        super(nome, dataInicio, dataEstimada, progresso);
    }
}
