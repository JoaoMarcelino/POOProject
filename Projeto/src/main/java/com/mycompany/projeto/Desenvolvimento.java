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
public class Desenvolvimento extends Tarefa{
        
    /**
     * Construtor da classe Desenvolvimento
     * @param nome
     * @param dataInicio
     * @param dataEstimada
     * @param responsavel
     */
    public Desenvolvimento(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa responsavel) {
        super(nome, dataInicio, dataEstimada, responsavel);
        this.taxaEsforco = 1;
    }
}
