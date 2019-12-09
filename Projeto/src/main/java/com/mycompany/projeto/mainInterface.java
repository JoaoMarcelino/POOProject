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
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 *
 * @author hp
 */
public class mainInterface implements ActionListener {  
    
    JFrame frame;
    JMenuBar bar;
    JMenu menu1;
    JMenu menu2;
    JMenu menu3;
    
    JMenuItem itemProjeto1;
    JMenuItem itemProjeto2;
    JMenuItem itemProjeto3;

    JMenuItem itemDocente1;
    JMenuItem itemDocente2;
    JMenuItem itemDocente3;

    JMenuItem itemBolseiro1;
    JMenuItem itemBolseiro2;
    JMenuItem itemBolseiro3;

    mainInterface() throws IOException{
       
        frame = new JFrame();
        bar = new JMenuBar();
    
        
        menu1 = new JMenu("Projetos");
        menu2 = new JMenu("Docentes");
        menu3 = new JMenu("Bolseiros");
        
        itemProjeto1 = new JMenuItem("Ver");
        itemProjeto2 = new JMenuItem("Criar");
        itemProjeto3 = new JMenuItem("Eliminar");

        itemDocente1 = new JMenuItem("Ver");
        itemDocente2 = new JMenuItem("Criar");
        itemDocente3 = new JMenuItem("Eliminar");

        itemBolseiro1 = new JMenuItem("Ver");
        itemBolseiro2 = new JMenuItem("Criar");
        itemBolseiro3 = new JMenuItem("Eliminar");
        

        itemProjeto1.addActionListener(this);
        itemProjeto2.addActionListener(this);
        itemProjeto3.addActionListener(this);
        itemDocente1.addActionListener(this);
        itemDocente2.addActionListener(this);
        itemDocente3.addActionListener(this);
        itemBolseiro1.addActionListener(this);
        itemBolseiro2.addActionListener(this);
        itemBolseiro3.addActionListener(this);
        
        
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        
        menu1.add(itemProjeto1);
        menu1.add(itemProjeto2);
        menu1.add(itemProjeto3);
        
        menu2.add(itemDocente1);
        menu2.add(itemDocente2);
        menu2.add(itemDocente3);
        
        menu3.add(itemBolseiro1);
        menu3.add(itemBolseiro2);
        menu3.add(itemBolseiro3);

        
        frame.setJMenuBar(bar);
        frame.setResizable(false);
        frame.setTitle("MENU");
        frame.setSize(828, 466);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel panel = new JPanel();
        
        BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\hp\\Desktop\\Universidade\\Memes\\1s8pvzd1bwv31.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);
        
        frame.add(panel);
        
        frame.setVisible(true);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        
        if(e.getSource()==itemProjeto1){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor1");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.println("123");
        }
        else if(e.getSource()==itemProjeto2){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor2");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.printf("2");   
        }
        else if(e.getSource()==itemProjeto3){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor3");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.printf("2");   
        }
        else if(e.getSource()==itemDocente1){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor4");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.printf("2");   
        }
        else if(e.getSource()==itemDocente2){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor5");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.printf("2");   
        }
        else if(e.getSource()==itemDocente3){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor6");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.printf("2");   
        }
        else if(e.getSource()==itemBolseiro1){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor7");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.printf("2");   
        }
        else if(e.getSource()==itemBolseiro2){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor8");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.printf("2");   
        } 
        else if(e.getSource()==itemBolseiro3){
            JPanel p1=new JPanel();
            JLabel label1 = new JLabel("Valor9");
            p1.add(label1);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            System.out.printf("2");   
        }

        
        
        
    }     
    
    public static void main(String[] args) throws IOException {
        mainInterface mainInterface = new mainInterface();
    }


}
