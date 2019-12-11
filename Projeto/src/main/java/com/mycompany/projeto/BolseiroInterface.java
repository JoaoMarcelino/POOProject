/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

/**
 *
 * @author hp
 */
public class BolseiroInterface {
    Bolseiro bolseiro;
    
    public BolseiroInterface(Bolseiro bolseiro, Cisuc cisuc){
        this.bolseiro = bolseiro;
        
        System.out.printf("%s\n",bolseiro.getNome());
    } 
}
