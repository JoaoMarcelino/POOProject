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
    protected ArrayList<Projeto> arrayProjeto = new ArrayList <>();
    
    private GregorianCalendar dataAtual;     
   
    public Cisuc(GregorianCalendar dataAtual){
        this.dataAtual = dataAtual;
    }
    
    public GregorianCalendar getDataAtual() {
        return dataAtual;
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
        arrayProjeto.add(projeto);
    }
    
    
    public void naoConcluidos(){
        
        System.out.println("PROJETOS NAO CONCLUÍDOS:");

        for(Projeto projeto: arrayProjeto) {
           
            if (projeto.getDataFinal().compareTo(this.dataAtual) < 0)
                System.out.println(projeto);
        }
        System.out.println("----");
    }
    
    
    public void concluidos(){

        System.out.println("PROJETOS CONCLUÍDOS:");

        for(Projeto projeto: arrayProjeto) {

            if (projeto.getDataFinal().compareTo(this.dataAtual) >= 0)
                System.out.println(projeto);
        }
        System.out.println("----");
    }
}
