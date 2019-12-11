/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author hp
 */
public class Projeto implements Serializable{
    
    protected ArrayList<Tarefa> arrayTarefas = new ArrayList <>();
    protected ArrayList<Bolseiro> arrayBolseiros = new ArrayList <>();
    protected ArrayList<Docente> arrayDocentes = new ArrayList <>();    
    
    private String nome;
    private String acronimo;
    
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataEstimada;
    private GregorianCalendar dataFinal;
    
    private int acabado;
    private int custo;
    private Docente investigadorPrincipal;
    
    public Projeto(String nome, String acronimo, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Docente investigadorPrincipal) {
        this.custo = 0;
        this.acabado = 0;
        this.nome = nome;
        this.acronimo = acronimo;
        this.dataInicio = dataInicio;
        this.dataEstimada = dataEstimada;
        this.investigadorPrincipal = investigadorPrincipal;
    }
    
    public Projeto(){
        this.nome = "NONEXISTANT";
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getAcronimo() {
        return this.acronimo;
    }

    public GregorianCalendar getDataInicio() {
        return this.dataInicio;
    }

    public GregorianCalendar getDataEstimada() {
        return this.dataEstimada;
    }
    
    public Docente getInvestigadorPrincipal() {
        return this.investigadorPrincipal;
    }

    public GregorianCalendar getDataFinal() {
        return this.dataFinal;
    }

    public int getAcabado() {
        return this.acabado;
    }

    public int getCusto(){
        
        int aux = 0;
        
        for(Bolseiro bolseiro: arrayBolseiros) {

            aux += bolseiro.getOrdenado();
        }
        return aux;
    }
    
    public Pessoa getPessoa(String nome) {
        
        
        for(Bolseiro pessoa: arrayBolseiros) {
            
            if (pessoa.getNome().equals(nome))
                return pessoa;
        }
        
        for(Docente pessoa: arrayDocentes) {

            if (pessoa.getNome().equals(nome))
                return pessoa;
        }
        
        return null;
    }
    
    public Pessoa getPessoa(int index) {
        
        
        for(Bolseiro pessoa: arrayBolseiros) {
            
            if (arrayBolseiros.indexOf(pessoa)==index)
                return pessoa;
        }
        
        for(Docente pessoa: arrayDocentes) {

            if (arrayDocentes.indexOf(pessoa)==index)
                return pessoa;
        }
        
        return null;
    }
    
    public Bolseiro getBolseiro(String nome) {
        
        
        for(Bolseiro pessoa: arrayBolseiros) {
            
            if (pessoa.getNome().equals(nome))
                return pessoa;
        }
        return null;
    }
    
    public Docente getDocente(String nome){
        
        for(Docente pessoa: arrayDocentes) {

            if (pessoa.getNome().equals(nome))
                return pessoa;
        }
        
        return null;
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
    
    public void criaDocumentacao(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa pessoa){
        
        Tarefa tarefa = new Documentacao(nome, dataInicio, dataEstimada, pessoa);
        pessoa.addTarefa(tarefa);
        addTarefa(tarefa);
    }
    
    public void criaDesign(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa pessoa){
        
        //Pessoa pessoa = this.getPessoa(nomePessoa);
        
        Design tarefa = new Design(nome, dataInicio, dataEstimada, pessoa);
        pessoa.addTarefa(tarefa);
        this.addTarefa(tarefa);
    }
    
    public void criaDesenvolvimento(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa pessoa){
        
        Tarefa tarefa = new Desenvolvimento(nome, dataInicio, dataEstimada, pessoa);
        pessoa.addTarefa(tarefa);
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
        this.custo += bolseiro.getOrdenado();
    }
    
    public void eliminarTarefas(Tarefa tarefa){
        
        int indice = arrayTarefas.indexOf(tarefa);
        String s = tarefa.getResponsavel().getNome();
        
        if (indice != -1){
            this.getPessoa(s).removeTarefa(tarefa);
            arrayTarefas.remove(indice);      
        }
        else
            System.out.println("ERRO -- TAREFA NAO EXISTENTE");
    }
    
    
    public Tarefa getTarefa(String nome){
        
        for (Tarefa tarefa : arrayTarefas){
            
            if (tarefa.getNome().equals(nome))
                return tarefa;
        }
        return null;
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

        System.out.printf("TAREFAS DO PROJETO %s:\n", this.nome);

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
    
    public void removeDocente(Docente pessoa){
      
        int indice = arrayDocentes.indexOf(pessoa);
       
        if (indice != -1)
            arrayDocentes.remove(indice);
        else
            System.out.println("ERRO -- DOCENTE NAO EXISTENTE");
    }
    
    public void removeBolseiro(Bolseiro pessoa){
        
        int indice = arrayBolseiros.indexOf(pessoa);
        
        if (indice != -1)
            arrayBolseiros.remove(indice);
        else
            System.out.println("ERRO -- BOLSEIRO NAO EXISTENTE");
    }
    
    public void removeTarefa(Tarefa tarefa){
      
        int indice = arrayTarefas.indexOf(tarefa);
       
        if (indice != -1)
            arrayTarefas.remove(indice);
        else
            System.out.println("ERRO -- DOCENTE NAO EXISTENTE");
    }
    
}