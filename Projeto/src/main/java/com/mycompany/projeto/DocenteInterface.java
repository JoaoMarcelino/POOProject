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
public class DocenteInterface {
    Docente docente;
    
    public DocenteInterface(Docente docente, Cisuc cisuc){
        this.docente = docente;
        
        System.out.printf("%s\n",docente.getNome());
    }
}
