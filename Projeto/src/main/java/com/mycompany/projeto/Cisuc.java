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
public class Cisuc {
    
    protected ArrayList<Pessoa> arrayDocentes = new ArrayList <>();
    protected ArrayList<Pessoa> arrayBolseiros = new ArrayList <>();
    protected ArrayList<Projeto> arrayProjetos = new ArrayList <>();
    
    public ArrayList<Pessoa> getArrayDocentes() {
        return arrayDocentes;
    }

    public ArrayList<Pessoa> getArrayBolseiros() {
        return arrayBolseiros;
    }

    public ArrayList<Projeto> getArrayProjetos() {
        return arrayProjetos;
    }
    
    private GregorianCalendar dataAtual;     
   
    public Cisuc(GregorianCalendar dataAtual){
        this.dataAtual = dataAtual;
    }

    
    public GregorianCalendar getDataAtual() {
        return dataAtual;
    }

    public Projeto getProjeto(String nome) {
        
        for(Projeto projeto: arrayProjetos) {
           
            if (projeto.getNome().equals(nome))
                return projeto;
        }
        Projeto proj = new Projeto();
        return proj;//SE HOUVER ERRO CRIA UM PROJETO COM NOME "NONEXISTANT" PARA RESOLUCAO DE ERROS.
    }
    
    public void addDocente(Pessoa pessoa){
        arrayDocentes.add(pessoa);
    }
    
    
    public void removeDocente(Pessoa pessoa){
        
        int indice = arrayDocentes.indexOf(pessoa);
       
        if (indice != -1)
            arrayDocentes.remove(indice);
        else
            System.out.println("ERRO -- DOCENTE NAO EXISTENTE");
    }
    
    
    public void addBolseiro(Pessoa pessoa){
        arrayBolseiros.add(pessoa);
    }
    
    
    public void removeBolseiro(Pessoa pessoa){
        
        int indice = arrayBolseiros.indexOf(pessoa);
        
        if (indice != -1)
            arrayBolseiros.remove(indice);
        else
            System.out.println("ERRO -- BOLSEIRO NAO EXISTENTE");
    }
    
    
    public void addProjeto(Projeto projeto){
        arrayProjetos.add(projeto);
    }
    
    
    public void naoConcluidos(){
        
        System.out.println("PROJETOS NAO CONCLUÍDOS:\n");

        for(Projeto projeto: arrayProjetos) {
           
            if (projeto.getAcabado() == 0)
                System.out.println(projeto.getNome());
        }
        System.out.println("----\n");
    }
    
    
    public void concluidos(){

        System.out.println("PROJETOS CONCLUÍDOS:\n");

        for(Projeto projeto: arrayProjetos) {

            if (projeto.getAcabado() == 1)
                System.out.println(projeto.getNome());
        }
        System.out.println("----");
    }
    
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
    
    public void printTarefas(){
        
        System.out.println("Tarefas:\n");

        for(Projeto projeto: arrayProjetos) {
            projeto.listarTarefas();
        }
        
        System.out.println("----\n");
    }
}
