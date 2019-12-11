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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 *
 * @author hp
 */
public class mainInterface implements ActionListener {  
    
    Cisuc cisuc;
    
    int x =828;
    int y = 466;
        
    JFrame frame;
    JList list;
    JMenuBar bar;
    JMenu menu1;
    JMenu menu2;
    JMenu menu3;
    
    JMenu verItemProjeto;
    JMenuItem itemTodos;
    JMenuItem itemNConc;
    JMenuItem itemConc;
    JMenuItem criarItemProjeto;
    JMenuItem eliminarItemProjeto;

    JMenuItem itemDocente1;
    JMenuItem itemDocente2;
    JMenuItem itemDocente3;

    JMenuItem itemBolseiro1;
    JMenuItem itemBolseiro2;
    JMenuItem itemBolseiro3;

    
    JButton buttonProjeto;
    JButton buttonElProjeto;
    JButton buttonDocente;
    JButton buttonElDocente;
    JButton buttonBolseiro;
    JButton buttonElBolseiro;
    JButton buttonCriarDocente;
    
    mainInterface(Cisuc cisuc) throws IOException{
       
        this.cisuc = cisuc;
        frame = new JFrame();
        bar = new JMenuBar();
    

        menu1 = new JMenu("Projetos");
        menu2 = new JMenu("Docentes");
        menu3 = new JMenu("Bolseiros");
        
        verItemProjeto = new JMenu("Ver");
        criarItemProjeto = new JMenuItem("Criar");
        eliminarItemProjeto = new JMenuItem("Eliminar");

        itemDocente1 = new JMenuItem("Ver");
        itemDocente2 = new JMenuItem("Criar");
        itemDocente3 = new JMenuItem("Eliminar");

        itemBolseiro1 = new JMenuItem("Ver");
        itemBolseiro2 = new JMenuItem("Criar");
        itemBolseiro3 = new JMenuItem("Eliminar");
        
        itemTodos = new JMenuItem("Todos");
        itemNConc = new JMenuItem("Não Concluidos");
        itemConc = new JMenuItem("Concluidos");
        
        verItemProjeto.addActionListener(this);
        criarItemProjeto.addActionListener(this);
        eliminarItemProjeto.addActionListener(this);
        itemDocente1.addActionListener(this);
        itemDocente2.addActionListener(this);
        itemDocente3.addActionListener(this);
        itemBolseiro1.addActionListener(this);
        itemBolseiro2.addActionListener(this);
        itemBolseiro3.addActionListener(this);
        
        itemTodos.addActionListener(this);
        itemNConc.addActionListener(this);
        itemConc.addActionListener(this);

        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        
        menu1.add(verItemProjeto);
        menu1.add(criarItemProjeto);
        menu1.add(eliminarItemProjeto);
        
        menu2.add(itemDocente1);
        menu2.add(itemDocente2);
        menu2.add(itemDocente3);
        
        menu3.add(itemBolseiro1);
        menu3.add(itemBolseiro2);
        menu3.add(itemBolseiro3);

        verItemProjeto.add(itemTodos);
        verItemProjeto.add(itemNConc);
        verItemProjeto.add(itemConc);
        
        
        frame.setJMenuBar(bar);
        frame.setResizable(false);
        frame.setTitle("Quem Ler Isto é Gay");
        frame.setSize(x, y+60);
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
        
        if(e.getSource()==itemTodos){
            verProjetoMenu(2);
        }
        
        
        else if(e.getSource()==itemNConc){
            verProjetoMenu(0);
        }
        
        
        else if(e.getSource()==itemConc){
            verProjetoMenu(1);
        }
        
        else if(e.getSource()==criarItemProjeto){
            JPanel p1=new JPanel();
            p1.setLayout(null);
            JLabel label1 = new JLabel("Nome");
            JLabel label2 = new JLabel("E-mail");
            JLabel label3 = new JLabel("Número Mecanográfico");
            JLabel label4 = new JLabel("Area de Investigação");
            buttonCriarDocente = new JButton("Criar");
            
            JTextField nome = new JTextField(10);
            JTextField email = new JTextField(10);
            JTextField nmecan = new JTextField(10);
            JTextField area = new JTextField(10);
            
            label1.setBounds(x/8,0,x/4,y/8);
            label2.setBounds(x/8,y/4,x/2,y/8);
            label3.setBounds(x/8,2*y/4,x/2,y/8);
            label4.setBounds(x/8,3*y/4,x/2,y/8);
            
            nome.setBounds(x/2,0,x/2,y/8);
            email.setBounds(x/2,y/4,x/2,y/8);
            nmecan.setBounds(x/2,2*y/4,x/2,y/8);
            area.setBounds(x/2,3*y/4,x/2,y/8);
            
            buttonCriarDocente.setBounds(x/4,y*7/8,x/2,y/8);
            p1.add(label1);
            p1.add(label2);
            p1.add(label3);
            p1.add(label4);
            
            p1.add(nome);
            p1.add(email);
            p1.add(nmecan);
            p1.add(area);
            
            p1.add(buttonCriarDocente);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
            
        }
        
        else if(e.getSource()==eliminarItemProjeto){
            EliminarProjetoMenu();
        }
        
        else if(e.getSource()==itemDocente1){
            verDocenteMenu();
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
            EliminarDocenteMenu();
        }
        else if(e.getSource()==itemBolseiro1){
            verBolseiroMenu();
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
           EliminarBolseiroMenu();
        }

        else if(e.getSource() == buttonProjeto){
            Projeto projeto = cisuc.getProjeto((String) list.getSelectedValue());
            ProjetoInterface projetoInt = new ProjetoInterface(projeto);
        }
        
        else if(e.getSource() == buttonDocente){
            Docente docente = cisuc.getDocente((String) list.getSelectedValue());
            DocenteInterface docenteInt = new DocenteInterface(docente);
        }
        
        else if(e.getSource() == buttonBolseiro){
            Bolseiro bolseiro = cisuc.getBolseiro((String) list.getSelectedValue());
            BolseiroInterface bolseiroInt = new BolseiroInterface(bolseiro);
        }
        
        else if (e.getSource() == buttonElProjeto){
            Projeto projeto = cisuc.getProjeto((String) list.getSelectedValue());
            cisuc.removeProjeto(projeto);
            EliminarProjetoMenu();
        }
        
        else if (e.getSource() == buttonElDocente){
            Docente docente = cisuc.getDocente((String) list.getSelectedValue());
            cisuc.removeDocente(docente);
            EliminarDocenteMenu();
        }
        else if (e.getSource() == buttonElBolseiro){
            Bolseiro bolseiro = cisuc.getBolseiro((String) list.getSelectedValue());
            cisuc.removeBolseiro(bolseiro);
            EliminarBolseiroMenu();
        }
    }
    
    
    
    void verProjetoMenu(int num){
        String tipo="";
        JPanel p1=new JPanel();
        p1.setLayout(null);
        
        DefaultListModel listValues = new DefaultListModel();
        buttonProjeto = new JButton("Selecionar");
        buttonProjeto.setBounds(x*6/8,y/16,x/8,y/8);
        buttonProjeto.addActionListener(this);
        if (num ==2){
            tipo = "";
            for(Projeto projeto: cisuc.arrayProjetos)
                listValues.addElement(projeto.getNome());
        }
        else {
            if (num ==1) tipo = "Concluidos";
            else if (num == 0) tipo = "Não Concluidos";
            for(Projeto projeto: cisuc.arrayProjetos){
                if (projeto.getAcabado() == num)
                    listValues.addElement(projeto.getNome());
            }
        }
        
        tipo =String.format("Ver Projetos %s",tipo);
        
        
        JLabel label = new JLabel(tipo);
        label.setBounds(x/8,0,x/2,y/4);
        
        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonProjeto);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    
    void verDocenteMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Lista de valores ");
        buttonDocente = new JButton("Selecionar");
        label.setBounds(x/8,0,x/2,y/4);
        buttonDocente.setBounds(x*6/8,y/16,x/8,y/8);
        buttonDocente.addActionListener(this);
        for(Pessoa docente: cisuc.arrayDocentes){
            listValues.addElement(docente.getNome());
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonDocente);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    
    void verBolseiroMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Lista de valores ");
        buttonBolseiro = new JButton("Selecionar");
        label.setBounds(x/8,0,x/2,y/4);
        buttonBolseiro.setBounds(x*6/8,y/16,x/8,y/8);
        buttonBolseiro.addActionListener(this);
        for(Pessoa bolseiro: cisuc.arrayBolseiros){
            listValues.addElement(bolseiro.getNome());
        }
        

        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonBolseiro);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);

    }
    
    void EliminarProjetoMenu(){
        
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Remover Projeto");
        buttonElProjeto = new JButton("Remove");
        label.setBounds(x/8,0,x/2,y/4);
        buttonElProjeto.setBounds(x*6/8,y/16,x/8,y/8);
        buttonElProjeto.addActionListener(this);

        for(Projeto projeto: cisuc.arrayProjetos){
            listValues.addElement(projeto.getNome());
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonElProjeto);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    void EliminarDocenteMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Remover Docente");
        buttonElDocente = new JButton("Remove");
        label.setBounds(x/8,0,x/2,y/4);
        buttonElDocente.setBounds(x*6/8,y/16,x/8,y/8);
        buttonElDocente.addActionListener(this);
        for(Pessoa docente: cisuc.arrayDocentes){
            listValues.addElement(docente.getNome());
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonElDocente);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    void EliminarBolseiroMenu(){

        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Remover Bolseiro");
        buttonElBolseiro = new JButton("Remove");
        label.setBounds(x/8,0,x/2,y/4);
        buttonElBolseiro.setBounds(x*6/8,y/16,x/8,y/8);
        buttonElBolseiro.addActionListener(this);
        cisuc.arrayBolseiros.forEach((bolseiro) -> { listValues.addElement(bolseiro.getNome()); });

        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonElBolseiro);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    

}