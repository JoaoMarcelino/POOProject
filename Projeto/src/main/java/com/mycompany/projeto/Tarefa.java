/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 *
 * @author hp
 */
public abstract class Tarefa implements Serializable{
    
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataEstimada;
    private GregorianCalendar dataFinal;

    
    private int progesso;
    protected float taxaEsforco;
    private String nome;
    private Pessoa responsavel;

    public Tarefa(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa responsavel) {
        this.progesso = 0;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataEstimada = dataEstimada;
        this.responsavel = responsavel;
    }

    public void setResponsavel(Pessoa pessoa) {
        this.responsavel = pessoa;
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
    
    public GregorianCalendar getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(GregorianCalendar dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setProgesso(int progesso) {
        this.progesso = progesso;
    }
}