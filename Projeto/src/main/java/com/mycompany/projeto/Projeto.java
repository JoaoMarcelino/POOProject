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
public class Projeto {
    
    protected ArrayList<Tarefa> arrayTarefas = new ArrayList <>();
    protected ArrayList<Bolseiro> arrayBolseiros = new ArrayList <>();
    protected ArrayList<Docente> arrayDocentes = new ArrayList <>();    
    
    private String nome;
    private String acrónimo;
    
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataEstimada;
    private GregorianCalendar dataFinal;
    
    private int acabado = 0;
    private int custo;
    private Docente investigadorPrincipal;
    
    public Projeto(String nome, String acrónimo, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, int custo) {
        this.nome = nome;
        this.acrónimo = acrónimo;
        this.dataInicio = dataInicio;
        this.dataEstimada = dataEstimada;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public String getAcrónimo() {
        return acrónimo;
    }

    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }

    public GregorianCalendar getDataEstimada() {
        return dataEstimada;
    }
    
    public Docente getInvestigadorPrincipal() {
        return investigadorPrincipal;
    }

    public GregorianCalendar getDataFinal() {
        return dataFinal;
    }

    public int getAcabado() {
        return acabado;
    }

    public int getCusto(){
        
        int aux = 0;
        
        for(Bolseiro bolseiro: arrayBolseiros) {

            aux += bolseiro.getOrdenado();
        }
        return aux;
    }

    public void setInvestigadorPrincipal(Docente investigadorPrincipal) {
        this.investigadorPrincipal = investigadorPrincipal;
    }
    
    public void setDataFinal(GregorianCalendar dataFinal){
        this.dataFinal = dataFinal;
    }
    
    public void setAcabado(int acabado) {
        this.acabado = acabado;
    }
    
    public void criaDocumentacao(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, int progresso){
        
        Tarefa tarefa = new Documentacao(nome, dataInicio, dataEstimada, progresso);
        addTarefa(tarefa);
    }
    
    public void criaDesign(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, int progresso){
        
        Tarefa tarefa = new Design(nome, dataInicio, dataEstimada, progresso);
        addTarefa(tarefa);
    }
    
    public void criaDesenvolvimento(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, int progresso){
        
        Tarefa tarefa = new Desenvolvimento(nome, dataInicio, dataEstimada, progresso);
        addTarefa(tarefa);
    }
    
    public void addTarefa(Tarefa tarefa){
        arrayTarefas.add(tarefa);
    }
    
    public void addDocente(Docente docente){
        arrayDocentes.add(docente);
    }
    
    public void addBolseiro(Bolseiro bolseiro){
        arrayBolseiros.add(bolseiro);
    }
    
    public void eliminarTarefas(Tarefa tarefa){
        
        int indice = arrayTarefas.indexOf(tarefa);
        
        if (indice != -1)
            arrayTarefas.remove(indice);
        else
            System.out.println("ERRO -- TAREFA NAO EXISTENTE");
    }
    
    public void listarTarefas(){

        System.out.println("TAREFAS:");

        for(Tarefa tarefa: arrayTarefas) {

            System.out.println(tarefa.getNome());
        }
        System.out.println("----");
    }
    
    public void listarTarefasNaoIniciadas(){

        System.out.println("TAREFAS:");

        for(Tarefa tarefa: arrayTarefas) {
            if (tarefa.getProgesso() == 0)
                System.out.println(tarefa.getNome());
        }
        System.out.println("----");
    }
    
    public void listarTarefasConcluidas(){

        System.out.println("TAREFAS:");

        for(Tarefa tarefa: arrayTarefas) {
            if (tarefa.getProgesso() == 100)
                System.out.println(tarefa.getNome());
        }
        System.out.println("----");
    }
    
    public void listarTarefasNaoConcluidas(){

        System.out.println("TAREFAS:");

        for(Tarefa tarefa: arrayTarefas) {
            if (tarefa.getProgesso() != 0 && tarefa.getProgesso() != 100)
                System.out.println(tarefa.getNome());
        }
        System.out.println("----");
    }
    
    public void addCusto(int aux) {
        this.custo += aux;
    }
    
    public void endProjeto(Projeto projeto) {
        this.acabado = 1;
    }
}