/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.util.GregorianCalendar;

/**
 *
 * @author hp
 */
public class Licenciado extends Estudante{
    
    private int ordenado;
    
    public Licenciado(String nome, String email, GregorianCalendar contrato, Docente docente){
        super(nome,email,contrato, docente);   
        this.ordenado = 800;
    }
}
