/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author hp
 */
public class ProjetoInterface implements ActionListener{
    
    Projeto projeto;
    JFrame frame;
    JList list;
    JMenuBar bar;
    
    JMenu menu1, menu2,menu3;
    JMenuItem MainMenu, alterar, verTarefas, criarTarefa, eliminarTarefa,verDocente,eliminarDocente, verBolseiro, eliminarBolseiro;
    JButton buttonRemoverDocente, buttonVerTarefas, buttonRemoveTarefa;
    
    ArrayList<String> dia = new ArrayList();
    ArrayList<String> mes = new ArrayList();
    ArrayList<String> ano = new ArrayList();
    ArrayList<String> lista = new ArrayList();
    
    int x =400;
    int y =300;
    
    public ProjetoInterface(Projeto projeto){
        
        this.projeto = projeto;
        frame = new JFrame();
        bar = new JMenuBar();
        
        for (int i =1; i<=31; i++){
            dia.add(String.format("%d",i));
        }
        
        for (int i =1; i<=12; i++){
            mes.add(String.format("%d",i));
        }
        for (int i =1980; i<=2100; i++){
            ano.add(String.format("%d",i));
        }
        
        menu1 = new JMenu("Main");
        menu2 = new JMenu("Tarefas");
        menu3 = new JMenu("Pessoas");
        MainMenu = new JMenuItem("Main");
        alterar = new JMenuItem("Alterar");
        verTarefas = new JMenuItem("Ver");
        criarTarefa = new JMenuItem("Criar");
        eliminarTarefa = new JMenuItem("Eliminar");
        verDocente = new JMenuItem("Ver Docente");
        eliminarDocente = new JMenuItem("Eliminar Docente");
        verBolseiro = new JMenuItem("Ver Bolseiro");
        eliminarBolseiro = new JMenuItem("Eliminar Bolseiro");
        
        
        MainMenu.addActionListener(this);
        alterar.addActionListener(this);
        verTarefas.addActionListener(this);
        criarTarefa.addActionListener(this);
        eliminarTarefa.addActionListener(this);
        verDocente.addActionListener(this);
        verBolseiro.addActionListener(this);
        eliminarDocente.addActionListener(this);
        eliminarBolseiro.addActionListener(this);
        
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        
        menu1.add(MainMenu);
        menu1.add(alterar);
        menu2.add(verTarefas);
        menu2.add(criarTarefa);
        menu2.add(eliminarTarefa);
        menu3.add(verDocente);
        menu3.add(verBolseiro);
        menu3.add(eliminarDocente);
        menu3.add(eliminarBolseiro);
        
  
        
        frame.setJMenuBar(bar);
        frame.setResizable(false);
        frame.setTitle(String.format("%s - %s",projeto.getAcronimo(),projeto.getNome()));
        frame.setSize(x, y);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        MainMenu();
        
        frame.setVisible(true);
 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == MainMenu){
            MainMenu();
        }
        else if (e.getSource() == verTarefas){
            verTarefasMenu();
        }
        else if (e.getSource() == criarTarefa){
            String[] types = {"Design", "Desenvolvimento", "Documentação"};
            
            for (Tarefa tarefa: projeto.arrayTarefas){
                lista.add(tarefa.getNome());
            }
            JPanel p1=new JPanel();
            p1.setLayout(null);
            JLabel label1 = new JLabel("Nome");
            JLabel label2 = new JLabel("E-mail");
            JLabel label3 = new JLabel("Ensino Superior");
            JLabel label6 = new JLabel ("Docente Responsável **");
            JLabel label4 = new JLabel("Dia de Inicio da Bolsa");
            JLabel label5 = new JLabel("Dia de Fim da Bolsa");
            buttonCriarBolseiro = new JButton("Criar");
            
            nome = new JTextField(10);
            email = new JTextField(10);
            jComboBoxAction = new JComboBox(types);
            jComboBoxAction1 = new JComboBox(lista.toArray());
            dia1 = new JComboBox(dia.toArray());
            mes1 = new JComboBox(mes.toArray());
            ano1 = new JComboBox(ano.toArray());
            dia2 = new JComboBox(dia.toArray());
            mes2 = new JComboBox(mes.toArray());
            ano2 = new JComboBox(ano.toArray());
            
            label1.setBounds(x/8,y/8-y/12,x/4,y/12);
            label2.setBounds(x/8,y*2/8-y/12,x/4,y/12);
            label3.setBounds(x/8,y*3/8-y/12,x/4,y/12);
            label6.setBounds(x/8,y*4/8-y/12,x/4,y/12);
            label4.setBounds(x/8,y*5/8-y/12,x/4,y/12);
            label5.setBounds(x/8,y*6/8-y/12,x/4,y/12);
            
            nome.setBounds(x/2 + x/8, y/8-y/12, x/4, y/12);
            email.setBounds(x/2 + x/8, y*2/8-y/12, x/4, y/12);
            jComboBoxAction.setBounds(x/2 + x/8, y*3/8-y/12, x/4, y/12);
            jComboBoxAction1.setBounds(x/2 + x/8, y*4/8-y/12, x/4, y/12);
            dia1.setBounds(x/2 + x/8, y*5/8-y/12, x/12, y/12);
            mes1.setBounds(x/2 + x/8 + x/12,y*5/8-y/12, x/12, y/12);
            ano1.setBounds(x/2 + x/8 + x*2/12, y*5/8-y/12, x/12, y/12);
            dia2.setBounds(x/2 + x/8, y*6/8-y/12, x/12, y/12);
            mes2.setBounds(x/2 + x/8 + x/12, y*6/8-y/12, x/12, y/12);
            ano2.setBounds(x/2 + x/8 +x*2/12, y*6/8-y/12, x/12, y/12);
            
            buttonCriarBolseiro.setBounds(x/8,y*6/8 + 10,x/2 + x/4,y/8);
            buttonCriarBolseiro.addActionListener(this);
            p1.add(label1);
            p1.add(label2);
            p1.add(label3);
            p1.add(label4);
            p1.add(label5);
            p1.add(label6);
            
            p1.add(nome);
            p1.add(email);
            p1.add(jComboBoxAction);
            p1.add(jComboBoxAction1);
            p1.add(dia1);
            p1.add(mes1);
            p1.add(ano1);
            p1.add(dia2);
            p1.add(mes2);
            p1.add(ano2);
            
            p1.add(buttonCriarBolseiro);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
        }
        else if(e.getSource() == eliminarTarefa){
            eliminarTarefasMenu();
        }
        else if (e.getSource() == verDocente){
            verDocenteMenu();
        }
        else if (e.getSource() == eliminarDocente){
            eliminarDocenteMenu();
        }
    }
       
    
    public void MainMenu(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel label1 = new JLabel(String.format("Nome: %s",projeto.getNome()));
        JLabel label2 = new JLabel(String.format("Acronimo: %s",projeto.getAcronimo()));
        JLabel label4 = new JLabel(String.format("Data Estimada:%d-%d-%d",projeto.getDataEstimada().get(GregorianCalendar.YEAR),projeto.getDataEstimada().get(GregorianCalendar.MONTH),projeto.getDataEstimada().get(GregorianCalendar.DAY_OF_MONTH)));
        if (projeto.getAcabado() == 1){
            JLabel label41 = new JLabel(String.format("Data Final%d-%d-%d",projeto.getDataFinal().get(GregorianCalendar.YEAR),projeto.getDataFinal().get(GregorianCalendar.MONTH),projeto.getDataFinal().get(GregorianCalendar.DAY_OF_MONTH)));
            label41.setBounds(x/2,y*5/8,x/2,y/12);
            panel.add(label41);
        }
        JLabel label3 = new JLabel(String.format("Data Inicial: %d-%d-%d",projeto.getDataInicio().get(GregorianCalendar.YEAR),projeto.getDataInicio().get(GregorianCalendar.MONTH),projeto.getDataInicio().get(GregorianCalendar.DAY_OF_MONTH)));
        
        label1.setBounds(x/4,y/8,x/2,y/12);
        label2.setBounds(x/4,y*2/8,x/2,y/12);
        label3.setBounds(x/4,y*3/8,x/2,y/12);
        label4.setBounds(x/4,y*4/8,x/2,y/12);
        

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    
    public void verTarefasMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Lista de Tarefa");
        buttonVerTarefas = new JButton("Vizualizar");
        buttonVerTarefas.setBounds(x*6/8,y/16,x/8,y/8);
        buttonVerTarefas.addActionListener(this);
        label.setBounds(x/8,0,x/2,y/4);
        
        for(Tarefa tarefa: projeto.arrayTarefas){
            listValues.addElement(tarefa.getNome());
        }
        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);
        
        p1.add(label);
        p1.add(buttonVerTarefas);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    public void eliminarTarefasMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Remover Tarefa");
        buttonRemoveTarefa = new JButton("Remove");
        label.setBounds(x/8,0,x/2,y/4);
        buttonRemoveTarefa.setBounds(x*6/8,y/16,x/8,y/8);
        buttonRemoveTarefa.addActionListener(this);

        for(Tarefa tarefa: projeto.arrayTarefas){
            listValues.addElement(tarefa.getNome());
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonRemoveTarefa);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    public void verDocenteMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Lista de Docentes");
        label.setBounds(x/8,0,x/2,y/4);
        
        for(Pessoa docente: projeto.arrayDocentes){
            listValues.addElement(docente.getNome());
        }
        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    public void eliminarDocenteMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Remover Docente");
        buttonRemoverDocente = new JButton("Remove");
        label.setBounds(x/8,0,x/2,y/4);
        buttonRemoverDocente.setBounds(x*6/8,y/16,x/8,y/8);
        buttonRemoverDocente.addActionListener(this);
        
        for(Pessoa docente: projeto.arrayDocentes){
            listValues.addElement(docente.getNome());
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonRemoverDocente);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
}
