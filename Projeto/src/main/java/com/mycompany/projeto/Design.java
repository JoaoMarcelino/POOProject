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
public class Design extends Tarefa{
        
    private float taxaEsforco; 
            
    public Design(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada) {
        super(nome, dataInicio, dataEstimada);
        this.taxaEsforco = (float) 0.5;
    }
}
