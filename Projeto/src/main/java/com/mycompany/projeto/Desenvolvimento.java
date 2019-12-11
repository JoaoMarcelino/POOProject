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
public class Desenvolvimento extends Tarefa{
        
    public Desenvolvimento(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa responsavel) {
        super(nome, dataInicio, dataEstimada, responsavel);
        this.taxaEsforco = 1;
    }
}
