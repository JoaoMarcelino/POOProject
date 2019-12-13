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
 * @author José Esperança 2018278596
 * @author João Marcelino 2018279700
 */
public class Projeto implements Serializable{
    
    /**
     * Array de tarefas no projeto
     */
    protected ArrayList<Tarefa> arrayTarefas = new ArrayList <>();

    /**
     * Array de bolseiros no projeto
     */
    protected ArrayList<Bolseiro> arrayBolseiros = new ArrayList <>();

    /**
     * Array de docentes no projeto
     */
    protected ArrayList<Docente> arrayDocentes = new ArrayList <>();    
    
    private String nome;
    private String acronimo;
    
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataEstimada;
    private GregorianCalendar dataFinal;
    
    private int acabado;
    private int custo;
    private Docente investigadorPrincipal;
    
    /**
     * Construtor do Projeto
     * @param nome
     * @param acronimo
     * @param dataInicio
     * @param dataEstimada
     * @param investigadorPrincipal
     */
    public Projeto(String nome, String acronimo, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Docente investigadorPrincipal) {
        this.custo = 0;
        this.acabado = 0;
        this.nome = nome;
        this.acronimo = acronimo;
        this.dataInicio = dataInicio;
        this.dataEstimada = dataEstimada;
        this.investigadorPrincipal = investigadorPrincipal;
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

    /**
     * Devolve o custo do projeto
     * @return custo
     */
    public int getCusto(){
        
        int aux = 0;
        
        for(Bolseiro bolseiro: arrayBolseiros) {

            aux += bolseiro.getOrdenado();
        }
        return aux;
    }
    
    /**
     * Devolve uma pessoa pelo nome
     * @param nome
     * @return Pessoa
     */
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
    
    /**
     * Devolve uma pessoa pelo indice
     * @param index
     * @return Pessoa
     */
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
    
    /**
     * devolve um bolseiro pelo nome
     * @param nome
     * @return Bolseiro
     */
    public Bolseiro getBolseiro(String nome) {
        
        
        for(Bolseiro pessoa: arrayBolseiros) {
            
            if (pessoa.getNome().equals(nome))
                return pessoa;
        }
        return null;
    }

    /**
     * devolve um bolseiro pelo indice
     * @param index
     * @return bolseiro
     */
    public Bolseiro getBolseiro(int index) {
        
        for(Bolseiro pessoa: arrayBolseiros) {

            if (arrayDocentes.indexOf(pessoa)==index)
                return pessoa;
        }
        
        return null;
    }
    
    /**
     * devolve um docente pelo nome
     * @param nome
     * @return docente
     */
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
    
    /**
     * Cria uma nova tarefa de documentacao
     * @param nome
     * @param dataInicio
     * @param dataEstimada
     * @param pessoa
     */
    public void criaDocumentacao(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa pessoa){
        
        Tarefa tarefa = new Documentacao(nome, dataInicio, dataEstimada, pessoa);
        addTarefa(tarefa);
    }
    
    /**
     * Cria uma nova tarefa de design
     * @param nome
     * @param dataInicio
     * @param dataEstimada
     * @param pessoa
     */
    public void criaDesign(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa pessoa){
        
        
        Design tarefa = new Design(nome, dataInicio, dataEstimada, pessoa);
        this.addTarefa(tarefa);
    }
    
    /**
     * Cria uma nova tarefa de desenvolvimento
     * @param nome
     * @param dataInicio
     * @param dataEstimada
     * @param pessoa
     */
    public void criaDesenvolvimento(String nome, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, Pessoa pessoa){
        
        Tarefa tarefa = new Desenvolvimento(nome, dataInicio, dataEstimada, pessoa);
        addTarefa(tarefa);
    }
    
    /**
     * adiciona uma tarefa ao array
     * @param tarefa
     */
    public void addTarefa(Tarefa tarefa){
        arrayTarefas.add(tarefa);
    }
    
    /**
     * adiciona um docente ao array
     * @param docente
     */
    public void addDocente(Docente docente){
        arrayDocentes.add(docente);
    }
    
    /**
     * adiciona um bolseiro ao array e mete used = 1 no bolseiro
     * @param bolseiro
     */
    public void addBolseiro(Bolseiro bolseiro){
        arrayBolseiros.add(bolseiro);
        this.custo += bolseiro.getOrdenado();
        bolseiro.setUsed();
    }
    
    /**
     * elimina uma tarefa
     * @param tarefa
     */
    public void eliminarTarefas(Tarefa tarefa){
        
        int indice = arrayTarefas.indexOf(tarefa);
        String s = tarefa.getResponsavel().getNome();
        
        if (indice != -1){ 
            arrayTarefas.remove(indice);      
        }
        else
            System.out.println("ERRO -- TAREFA NAO EXISTENTE");
    }
    
    /**
     * devolve uma tarefa pelo nome
     * @return tarefa
     */
    public Tarefa getTarefa(String nome){
        
        for (Tarefa tarefa : arrayTarefas){
            
            if (tarefa.getNome().equals(nome))
                return tarefa;
        }
        return null;
    }
    
    /**
     * print todas as tarefas
     */
    public void listarTarefas(){

        System.out.println("TAREFAS:");

        for(Tarefa tarefa: arrayTarefas) {

            System.out.println(tarefa.getNome());
        }
        System.out.println("----");
    }
    
    /**
     * print todas as tarefas nao iniciadas
     */
    public void listarTarefasNaoIniciadas(){

        System.out.println("TAREFAS:");

        for(Tarefa tarefa: arrayTarefas) {
            if (tarefa.getProgesso() == 0)
                System.out.println(tarefa.getNome());
        }
        System.out.println("----");
    }
    
    /**
     * print todas as tarefas concluidas
     */
    public void listarTarefasConcluidas(){

        System.out.printf("TAREFAS DO PROJETO %s:\n", this.nome);

        for(Tarefa tarefa: arrayTarefas) {
            if (tarefa.getProgesso() == 100)
                System.out.println(tarefa.getNome());
        }
        System.out.println("----");
    }
    
    /**
     * print todas as tarefas nao concluidas
     */
    public void listarTarefasNaoConcluidas(){

        System.out.println("TAREFAS:");

        for(Tarefa tarefa: arrayTarefas) {
            if (tarefa.getProgesso() != 0 && tarefa.getProgesso() != 100)
                System.out.println(tarefa.getNome());
        }
        System.out.println("----");
    }
    
    /**
     * adiciona custo ao proj
     * @param aux
     */
    public void addCusto(int aux) {
        this.custo += aux;
    }
    
    /**
     * acaba o projeto
     */
    public void endProjeto() {
        this.acabado = 1;
    }
    
    /**
     * remove um docente do array recebendo um docente
     * @param pessoa
     */
    public void removeDocente(Docente pessoa){
      
        int indice = arrayDocentes.indexOf(pessoa);
       
        if (indice != -1)
            arrayDocentes.remove(indice);
        else
            System.out.println("ERRO -- DOCENTE NAO EXISTENTE");
    }
    
    /**
     * remove um bolseiro do array
     * @param pessoa
     */
    public void removeBolseiro(Bolseiro pessoa){
        
        int indice = arrayBolseiros.indexOf(pessoa);
        
        if (indice != -1)
            arrayBolseiros.remove(indice);
        else
            System.out.println("ERRO -- BOLSEIRO NAO EXISTENTE");
    }
    
    /**
     * remove uma tarefa
     * @param tarefa
     */
    public void removeTarefa(Tarefa tarefa){
      
        int indice = arrayTarefas.indexOf(tarefa);
       
        if (indice != -1)
            arrayTarefas.remove(indice);
        else
            System.out.println("ERRO -- DOCENTE NAO EXISTENTE");
    }
    
    /**
     * devolve a carga de uma pessoa numa certa data
     * @param nome
     * @param dataInicio
     * @return carga
     */
    public float getCargaPessoa(String nome, GregorianCalendar dataInicio){
        
        float aux = 0;
        
        for (Tarefa tarefa : arrayTarefas){
            
            if (dataInicio.compareTo(tarefa.getDataInicio()) <= 0 && tarefa.getProgesso() != 100 && nome.equals(tarefa.getResponsavel().getNome()))
                aux += tarefa.getTaxaEsforco();
        }
        return aux;
    }
    
    /**
     *
     * @return
     */
    public int checkTarefas(){
        int aux =0;
        for (Tarefa tarefa: arrayTarefas){
            if (tarefa.getProgesso() != 100){
                aux = 1;
                break;
            }
        }
        return aux;
    }
}