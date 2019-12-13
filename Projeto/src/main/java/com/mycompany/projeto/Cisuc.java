/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * @author José Esperança 2018278596
 * @author João Marcelino 2018279700
 */

public class Cisuc {
    
    /**
     * Array de docentes na instituicao
     */
    protected ArrayList<Docente> arrayDocentes = new ArrayList <>();

    /**
     * Array de Bolseiros na instituicao
     */
    protected ArrayList<Bolseiro> arrayBolseiros = new ArrayList <>();

    /**
     * Array de projetos na instituicao
     */
    protected ArrayList<Projeto> arrayProjetos = new ArrayList <>();
    private GregorianCalendar dataAtual;     
   
    public ArrayList<Docente> getArrayDocentes() {
        return arrayDocentes;
    }

    public ArrayList<Bolseiro> getArrayBolseiros() {
        return arrayBolseiros;
    }

    public ArrayList<Projeto> getArrayProjetos() {
        return arrayProjetos;
    }
    
    /**
     * Construtor da instituicao
     * @param dataAtual data atual
     */
    public Cisuc(GregorianCalendar dataAtual){
        this.dataAtual = dataAtual;
    }

    
    public GregorianCalendar getDataAtual() {
        return dataAtual;
    }

    /**
     * Returns Projeto recebendo um nome
     * @param nome nome do projeto
     * @return projeto
     */
    public Projeto getProjeto(String nome) {
        
        for(Projeto projeto: arrayProjetos) {
           
            if (projeto.getNome().equals(nome))
                return projeto;
        }
        return null;
    }
   
    /**
     * Returns Docente recebendo um indice
     * @param index indice no arraydocentes
     * @return docente, null if error
     */
    public Docente getDocente(int index){
        for(Docente docente: arrayDocentes) {
           
            if (arrayDocentes.indexOf(docente) == index)
                return docente;
        }
        return null;
    }
    
    /**
     * Returns Projeto recebendo um indice e um num que indica se o docente esta num proj
     * @param index indice no arraydocentes
     * @param num indica se o docente esta num proj
     * @return Docente
     */
    public Docente getDocente(int index, int num){
        int aux = 0;
        for(Docente docente: arrayDocentes) {
            if (docente.getIP() == num){
                if (aux == index)
                    return docente; 
                aux++;
            }
        }
        return null;
    }
    
    /**
     * Returns Docente recebendo um nome
     * @param nome nome do docente
     * @return Docente
     */
    public Docente getDocente(String nome){
        for(Docente docente: arrayDocentes) {
           
            if (docente.getNome().equals(nome))
                return docente;
        }
        return null;
    }
    
    /**
     * Returns Bolseiro recebendo um nome
     * @param nome nome do bolseiro
     * @return Bolseiro
     */
    public Bolseiro getBolseiro(String nome){
        for(Bolseiro bolseiro: arrayBolseiros) {
           
            if (bolseiro.getNome().equals(nome))
                return bolseiro;
        }
        return null;
    }
    
    /**
     * remove um projeto 
     * @param projeto objeto projeto
     */
    public void removeProjeto(Projeto projeto){
        
        int indice = arrayProjetos.indexOf(projeto);
        getDocente(projeto.getInvestigadorPrincipal().getNome()).setIp(0);
        if (indice != -1){
            arrayProjetos.remove(indice);
            
        }
        else
            System.out.println("ERRO -- PROJETO NAO EXISTENTE");

    }
    
    /**
     * Adicionam um docente 
     * @param pessoa objeto pessoa
     */
    public void addDocente(Docente pessoa){
        arrayDocentes.add(pessoa);
    }
    
    /**
     * Remove um docente
     * @param pessoa objeto Docente
     */
    public void removeDocente(Docente pessoa){
        
        int indice = arrayDocentes.indexOf(pessoa);
       
        if (indice != -1)
            arrayDocentes.remove(indice);
        else
            System.out.println("ERRO -- DOCENTE NAO EXISTENTE");
    }
    
    /**
     * Adiciona um bolseiro ao cisuc
     * @param pessoa objeto Bolseiro
     */
    public void addBolseiro(Bolseiro pessoa){
        arrayBolseiros.add(pessoa);
    }
    
    /**
     * Remove um bolseiro do cisuc
     * @param pessoa objeto Bolseiro
     */
    public void removeBolseiro(Bolseiro pessoa){
        
        int indice = arrayBolseiros.indexOf(pessoa);
        
        if (indice != -1)
            arrayBolseiros.remove(indice);
        else
            System.out.println("ERRO -- BOLSEIRO NAO EXISTENTE");
    }
    
    /**
     * Adiciona um projeto ao cisuc
     * @param projeto objeto Projeto
     */
    public void addProjeto(Projeto projeto){
        arrayProjetos.add(projeto);
    }
    
    /**
     * Cria um projeto a partir de dados iniciais
     * @param nome nome do projeto
     * @param acronimo acronimo do projeto
     * @param dataInicio data de inicio do projeto
     * @param dataEstimada data estimada do fim do projeto
     * @param investigadorPrincipal nome do investigador principal
     * @return null if error, else the created project
     */
    
    public Projeto criaProjeto(String nome, String acronimo, GregorianCalendar dataInicio, GregorianCalendar dataEstimada, String investigadorPrincipal){
        
        for (Docente docente : arrayDocentes){
            System.out.printf("%s %s  %d\n",docente.getNome(),investigadorPrincipal,docente.getIP());
            if (docente.getNome().equals(investigadorPrincipal) && docente.getIP() != 1){
                Projeto projeto = new Projeto(nome, acronimo, dataInicio, dataEstimada, docente);
                arrayProjetos.add(projeto);
                docente.setProjeto(projeto);
                projeto.addDocente(docente);
                return projeto;
            }  
        }
        return null;
    }
    
    /**
     * Cria um docente a partir de dados iniciais
     * @param nome nome do docente
     * @param email email do docente
     * @param numero numero mecanografico do docente
     * @param area area de investigacao do docente
     * @return 1 if error, else 0
     */
    public int criaDocente(String nome, String email, int numero, String area){   
        
        for (Docente docente : arrayDocentes){
            if (docente.getNome().equals(nome) || docente.getEmail().equals(email) || docente.getNumMecanografico() == numero)
                return 1;
        }
            
        Docente docente = new Docente(nome, email, numero, area);
        this.addDocente(docente);
        return 0;
    }
    
    /**
     * Cria um doutorado a partir de dados iniciais
     * @param nome nome do doutorado
     * @param email email do doutorado
     * @param inicioBolsa data de inicio da bolsa
     * @param fimBolsa data de fim da bolsa
     * @return 1 if error, else 0
     */
    public int criaDoutorado(String nome, String email, GregorianCalendar inicioBolsa, GregorianCalendar fimBolsa){
        
        for ( Bolseiro bolseiro : arrayBolseiros){
            if (bolseiro.getNome().equals(nome) || bolseiro.getEmail().equals(email))
                return 1;
        }
        
        Doutorado doutorado = new Doutorado(nome, email, inicioBolsa, fimBolsa);
        this.addBolseiro(doutorado);
        return 0;
    }
    
    /**
     * Cria um estudante a partir de dados iniciais
     * @param nome nome do estudante
     * @param email email do estudante
     * @param inicioBolsa data de inicio da bolsa
     * @param fimBolsa data de fim da bolsa
     * @param nomeDocente nome do seu docente
     * @return 1 if error, else 0
     */
    public int criaEstudante(String nome, String email, GregorianCalendar inicioBolsa, GregorianCalendar fimBolsa, String nomeDocente){
        
        for (Bolseiro bolseiro : arrayBolseiros){
            if (bolseiro.getNome().equals(nome) || bolseiro.getEmail().equals(email))
                return 1;
        }
        
        for (Docente docente : arrayDocentes){
            if (docente.getNome().equals(nomeDocente)){
                Doutorado doutorado = new Doutorado(nome, email, inicioBolsa, fimBolsa);
                this.addBolseiro(doutorado);
                return 0;
            }
        }
        return 1;
    }
    
    /**
     * Print todos os projetos nao concluidos
     */
    public void naoConcluidos(){
        
        System.out.println("PROJETOS NAO CONCLUÍDOS:\n");

        for(Projeto projeto: arrayProjetos) {
           
            if (projeto.getAcabado() == 0)
                System.out.println(projeto.getNome());
        }
        System.out.println("----\n");
    }
    
    /**
     * Print todos os projetos concluidos
     */
    public void concluidos(){

        System.out.println("PROJETOS CONCLUÍDOS:\n");

        for(Projeto projeto: arrayProjetos) {

            if (projeto.getAcabado() == 1)
                System.out.println(projeto.getNome());
        }
        System.out.println("----");
    }
    
    /**
     * Print todas as pessoas no cisuc
     */
    public void printPessoas(){
        
        System.out.println("PESSOAS:\n");

        for(Pessoa pessoa: arrayBolseiros) {
            System.out.printf("BOLSEIRO: %s\n", pessoa.getNome());
        }
        
        for(Pessoa pessoa: arrayDocentes) {
            System.out.printf("DOCENTE: %s\n", pessoa.getNome());
        }
        System.out.println("----\n");
    }
    
    /**
     * print todas as tarefas no cisuc
     */
    public void printTarefas(){

        for(Projeto projeto: arrayProjetos) {
            projeto.listarTarefas();
        }
    }
    
    /**
     * print todas os IPS no cisuc
     */
    public void printIP(){
        
        for(Projeto projeto: arrayProjetos) {
            System.out.println(projeto.getInvestigadorPrincipal().getNome());
        }
    }
}
