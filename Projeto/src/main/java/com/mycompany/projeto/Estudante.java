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
public class Estudante extends Bolseiro{
    Docente docente;
    protected Estudante(String nome, String email){
        super(nome,email);
    }
}
