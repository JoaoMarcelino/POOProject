/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.util.Collections.list;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author hp
 */
public class ProjetoInterface {
    
    Projeto projeto;
    JFrame frame;
    JList list;
    JMenuBar bar;
    
    JMenu menu1, menu2;
    JMenuItem MainMenu, alterar, verTarefas, criarTarefa, eliminarTarefa;
    int x =400;
    int y =300;
    public ProjetoInterface(Projeto projeto){
        this.projeto = projeto;
        frame = new JFrame();
        bar = new JMenuBar();
        
        menu1 = new JMenu("Main");
        menu2 = new JMenu("Tarefas");
        MainMenu = new JMenuItem("Main");
        alterar = new JMenuItem("Alterar");
        verTarefas = new JMenuItem("Ver");
        criarTarefa = new JMenuItem("Criar");
        eliminarTarefa = new JMenuItem("Eliminar");
        
        bar.add(menu1);
        bar.add(menu2);
        
        menu1.add(MainMenu);
        menu1.add(alterar);
        menu2.add(verTarefas);
        menu2.add(criarTarefa);
        menu2.add(eliminarTarefa);
  
        frame.setJMenuBar(bar);
        frame.setResizable(false);
        frame.setTitle(String.format("%s - %s",projeto.getAcronimo(),projeto.getNome()));
        frame.setSize(x, y);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    
    }
    
}
