/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;
import javax.swing.*;
/**
 *
 * @author hp
 */
public class DocenteInterface {
    private Docente docente;
    private Cisuc cisuc;
    private int x = 400;
    private int y = 300;
    private JFrame frame;
    
    public DocenteInterface(Docente docente, Cisuc cisuc){
        
        this.docente = docente;
        this.cisuc = cisuc;
        frame = new JFrame();
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel label1 = new JLabel(String.format("Nome: %s",docente.getNome()));
        JLabel label2 = new JLabel(String.format("E-Mail: %s",docente.getEmail()));
        JLabel label3 = new JLabel(String.format("Numero Mecanográfico: %d",docente.getNumMecanografico()));
        JLabel label4 = new JLabel(String.format("Area: %s",docente.getAreaInvestigacao()));
        
        label1.setBounds(x/4,y/8,x/2,y/8);
        label2.setBounds(x/4,y*2/8,x/2,y/8);
        label3.setBounds(x/4,y*3/8,x/2,y/8);
        label4.setBounds(x/4,y*4/8,x/2,y/8);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        
        frame.setResizable(false);
        frame.setTitle(String.format("Docente"));
        frame.setSize(x, y );
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
