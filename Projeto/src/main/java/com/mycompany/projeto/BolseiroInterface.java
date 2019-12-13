/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class BolseiroInterface {
    private Bolseiro bolseiro;
    private Cisuc cisuc;
    private int x = 400;
    private int y = 300;
    private JFrame frame;
    
    public BolseiroInterface(Bolseiro bolseiro, Cisuc cisuc){
        this.bolseiro = bolseiro;
        this.cisuc = cisuc;
        frame = new JFrame();
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel label1 = new JLabel(String.format("Nome: %s",bolseiro.getNome()));
        JLabel label2 = new JLabel(String.format("E-Mail: %s",bolseiro.getEmail()));
        JLabel label3 = new JLabel(String.format("Salário: %d",bolseiro.getOrdenado()));
        JLabel label5 = new JLabel(String.format("Data Final: %d-%d-%d",bolseiro.getFimBolsa().get(GregorianCalendar.YEAR),bolseiro.getFimBolsa().get(GregorianCalendar.MONTH),bolseiro.getFimBolsa().get(GregorianCalendar.DAY_OF_MONTH)));
        JLabel label4 = new JLabel(String.format("Data Inicial: %d-%d-%d",bolseiro.getInicioBolsa().get(GregorianCalendar.YEAR),bolseiro.getInicioBolsa().get(GregorianCalendar.MONTH),bolseiro.getInicioBolsa().get(GregorianCalendar.DAY_OF_MONTH)));

        
        label1.setBounds(x/4,y/8,x/2,y/8);
        label2.setBounds(x/4,y*2/8,x/2,y/8);
        label3.setBounds(x/4,y*3/8,x/2,y/8);
        label4.setBounds(x/4,y*4/8,x/2,y/8);
        label5.setBounds(x/4,y*5/8,x/2,y/8); 
        
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        
        frame.setResizable(false);
        frame.setTitle(String.format("Bolseiro"));
        frame.setSize(x, y );
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    } 
}
