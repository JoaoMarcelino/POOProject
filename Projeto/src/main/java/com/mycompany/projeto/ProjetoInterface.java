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
public class ProjetoInterface {
    
    Projeto projeto;
    
    public ProjetoInterface(Projeto projeto){
        this.projeto = projeto;
        
        System.out.printf("%s\n",projeto.getNome());
    }
}
