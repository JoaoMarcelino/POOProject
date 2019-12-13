/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;
import java.util.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class TarefaInterface implements ActionListener {
    
    Tarefa tarefa;
    Cisuc cisuc;
    String tipo;
    int x = 400;
    int y = 300;
    JFrame frame;
    JButton botao, botao2;
    JTextField text;
    
    
    public TarefaInterface(Tarefa novo, Cisuc cisuc) {
        this.tarefa = novo;
        this.cisuc = cisuc;

        
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle(String.format("%s",tarefa.getNome()));
        frame.setSize(x, y + 60);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
        Menu();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  botao){
            ProgressoMenu();
            
        }
        else if (e.getSource() ==  botao2){
            tarefa.setProgesso(Integer.parseInt(text.getText()));
            if (tarefa.getProgesso() == 100){
                GregorianCalendar end = new GregorianCalendar();
                tarefa.setDataFinal(end);
            }
            Menu();
            
        }

    }
    
    public void Menu(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel label0 = new JLabel(String.format("Nome: %s",tarefa.getNome()));
        JLabel label1 = new JLabel(String.format("Pessoa: %s",tarefa.getResponsavel().getNome()));
        JLabel label2 = new JLabel(String.format("Taxa de Esforço: %s",tarefa.getTaxaEsforco()));
        JLabel label3 = new JLabel(String.format("Progresso: %s",tarefa.getProgesso()));
        JLabel label4 = new JLabel(String.format("Data Inicial: %d-%d-%d",tarefa.getDataInicio().get(GregorianCalendar.YEAR),tarefa.getDataInicio().get(GregorianCalendar.MONTH)+1,tarefa.getDataInicio().get(GregorianCalendar.DAY_OF_MONTH)));
        JLabel label5 = new JLabel(String.format("Data Estimada: %d-%d-%d",tarefa.getDataEstimada().get(GregorianCalendar.YEAR),tarefa.getDataEstimada().get(GregorianCalendar.MONTH)+1,tarefa.getDataEstimada().get(GregorianCalendar.DAY_OF_MONTH)));
        botao = new JButton("Alterar Progresso"); 
        
        if (tarefa.getProgesso() == 100){
            JLabel label51 = new JLabel(String.format("Data Final: %d-%d-%d",tarefa.getDataFinal().get(GregorianCalendar.YEAR),tarefa.getDataFinal().get(GregorianCalendar.MONTH)+1,tarefa.getDataFinal().get(GregorianCalendar.DAY_OF_MONTH)));
            label51.setBounds(x/4,y*6/8,x/2,y/8);
            panel.add(label51);
        }
        
        botao.addActionListener(this);
        label0.setBounds(x/4,0,x/2,y/8);
        label1.setBounds(x/4,y/8,x/2,y/8);
        label2.setBounds(x/4,y*2/8,x/2,y/8);
        label3.setBounds(x/4,y*3/8,x/2,y/8);
        label4.setBounds(x/4,y*4/8,x/2,y/8);
        label5.setBounds(x/4,y*5/8,x/2,y/8);
        botao.setBounds(x/4,y*7/8,x/2,y/8);

        panel.add(label0);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(botao);
        
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    
    public void ProgressoMenu(){
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel label1 = new JLabel("Progresso");
        text = new JTextField(10);
        botao2 = new JButton("Alterar");
        
        botao2.addActionListener(this);
        
        label1.setBounds(x/4,y*3/8,x/2,y/8);
        text.setBounds(x/4,y*4/8,x/2,y/8);
        botao2.setBounds(x/4,y*7/8,x/2,y/8);
        
        panel.add(label1);
        panel.add(text);
        panel.add(botao2);
     
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    
}
