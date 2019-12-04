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
public abstract class Tarefa {
    
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataEstimada;
    
    private int progesso;
    private float taxaEsforco;
    private String nome;
    private Pessoa responsavel;

    public Tarefa(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, int progesso) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataEstimada = dataEstimada;
        this.progesso = progesso;
    }

    public void setResponsavel(Pessoa pessoa) {
        if (pessoa.getCarga() + this.taxaEsforco <= 1)
            this.responsavel = pessoa;
        else
            System.out.println("ERRO -- PESSOA SOBRECARREGADA");
    }

    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }

    public GregorianCalendar getDataEstimada() {
        return dataEstimada;
    }

    public String getNome() {
        return nome;
    }

    public int getProgesso() {
        return progesso;
    }

    public float getTaxaEsforco() {
        return taxaEsforco;
    }
    
    public Pessoa getResponsavel() {
        return responsavel;
    }
}