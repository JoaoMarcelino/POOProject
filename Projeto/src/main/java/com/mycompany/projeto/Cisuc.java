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
     * @param dataAtual
     */
    public Cisuc(GregorianCalendar dataAtual){
        this.dataAtual = dataAtual;
    }

    
    public GregorianCalendar getDataAtual() {
        return dataAtual;
    }

    /**
     * Returns Projeto recebendo um nome
     * @param nome
     * @return
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
     * @param index
     * @return
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
     * @param index
     * @param num
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
     * @param nome
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
     * @param nome
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
     * @param projeto
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
     * @param pessoa
     */
    public void addDocente(Docente pessoa){
        arrayDocentes.add(pessoa);
    }
    
    /**
     * Remove um docente
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
     * Adiciona um bolseiro ao cisuc
     * @param pessoa
     */
    public void addBolseiro(Bolseiro pessoa){
        arrayBolseiros.add(pessoa);
    }
    
    /**
     * Remove um bolseiro do cisuc
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
     * Adiciona um projeto ao cisuc
     * @param projeto
     */
    public void addProjeto(Projeto projeto){
        arrayProjetos.add(projeto);
    }
    
    /**
     * Cria um projeto a partir de dados iniciais
     * @param nome
     * @param acronimo
     * @param dataInicio
     * @param dataEstimada
     * @param investigadorPrincipal
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
     * @param nome
     * @param email
     * @param numero
     * @param area
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
     * @param nome
     * @param email
     * @param inicioBolsa
     * @param fimBolsa
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
     * @param nome
     * @param email
     * @param inicioBolsa
     * @param fimBolsa
     * @param nomeDocente
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
