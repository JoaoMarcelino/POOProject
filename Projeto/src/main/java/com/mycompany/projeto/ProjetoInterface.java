/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.*;
/**
 *
 * @author hp
 */
public class ProjetoInterface implements ActionListener{
    
    private Cisuc cisuc;
    private Projeto projeto;
    private JFrame frame;
    private JList list;
    private JMenuBar bar;
    
    private JMenu menu1, menu2,menu3,verTarefas;
    private JMenuItem verTodas,verNaoIniciadas, Conc, NConc;
    private JMenuItem MainMenu, alterar, criarTarefa, eliminarTarefa,addDocente,verDocente,eliminarDocente, addBolseiro,verBolseiro, eliminarBolseiro;
    private JButton buttonRemoveDocente, buttonVerTarefas, buttonCriarTarefa, buttonRemoveTarefa, buttonRemoveBolseiro,buttonVerDocente,buttonVerBolseiro,buttonAddDocente,buttonAddBolseiro;
    
    private JTextField nome;
    private JTextField acronimo;
    private JComboBox jComboBoxAction, jComboBoxAction1;
    private JComboBox dia1;
    private JComboBox mes1;
    private JComboBox ano1;
    private JComboBox dia2;
    private JComboBox mes2;
    private JComboBox ano2;
    
    private ArrayList<String> dia = new ArrayList();
    private ArrayList<String> mes = new ArrayList();
    private ArrayList<String> ano = new ArrayList();
    private ArrayList<String> lista = new ArrayList();
    
    private int x =500;
    private int y =300;
    
    public ProjetoInterface(Projeto projeto, Cisuc cisuc){
        
        this.projeto = projeto;
        this.cisuc = cisuc;
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
        alterar = new JMenuItem("Concluir Projeto");
        verTarefas = new JMenu("Ver");
        
        verTodas = new JMenuItem("Todas");
        verNaoIniciadas = new JMenuItem("Não Iniciadas");
        Conc= new JMenuItem("Concluidas");
        NConc= new JMenuItem("Não Concluidas na Data");
        criarTarefa = new JMenuItem("Criar");
        eliminarTarefa = new JMenuItem("Eliminar");
        addDocente = new JMenuItem("Adicionar Docente");
        verDocente = new JMenuItem("Ver Docente");
        eliminarDocente = new JMenuItem("Eliminar Docente");
        addBolseiro = new JMenuItem("Adicionar Bolseiro");
        verBolseiro = new JMenuItem("Ver Bolseiro");
        eliminarBolseiro = new JMenuItem("Eliminar Bolseiro");
        
        
        MainMenu.addActionListener(this);
        alterar.addActionListener(this);
        verTodas.addActionListener(this);
        verNaoIniciadas.addActionListener(this);
        Conc.addActionListener(this);
        NConc.addActionListener(this);
        criarTarefa.addActionListener(this);
        eliminarTarefa.addActionListener(this);
        verDocente.addActionListener(this);
        verBolseiro.addActionListener(this);
        addDocente.addActionListener(this);
        addBolseiro.addActionListener(this);
        eliminarDocente.addActionListener(this);
        eliminarBolseiro.addActionListener(this);
        
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        
        verTarefas.add(verTodas);
        verTarefas.add(verNaoIniciadas);
        verTarefas.add(Conc);
        verTarefas.add(NConc);
        
        menu1.add(MainMenu);
        menu1.add(alterar);
        menu2.add(verTarefas);
        menu2.add(criarTarefa);
        menu2.add(eliminarTarefa);
        menu3.add(verDocente);
        menu3.add(verBolseiro);
        menu3.add(addDocente);
        menu3.add(addBolseiro);
        menu3.add(eliminarDocente);
        menu3.add(eliminarBolseiro);
        
  
        
        frame.setJMenuBar(bar);
        frame.setResizable(false);
        frame.setVisible(true);
        System.out.printf("%s - %s",projeto.getAcronimo(),projeto.getNome());
        frame.setTitle(String.format("%s - %s",projeto.getAcronimo(),projeto.getNome()));
        frame.setSize(x, y + 60);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        MainMenu();
        
        frame.setVisible(true);
 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == MainMenu){
            MainMenu();
        }
        else if (e.getSource() == alterar ){
            if (projeto.checkTarefas() == 0){
                GregorianCalendar end = new GregorianCalendar();
                JOptionPane.showMessageDialog(null, "Projeto Concluido","Projeto Concluido", JOptionPane.PLAIN_MESSAGE);
                projeto.endProjeto();
                projeto.setDataFinal(end);
                MainMenu();
            }
            else {
                JOptionPane.showMessageDialog(null, "ERRO: Tarefas nao Concluidas","Erro", JOptionPane.PLAIN_MESSAGE);
            }
        }
        else if (e.getSource() == verTodas){
            verTarefasMenu(0);
        }
        else if (e.getSource() == NConc){
            verTarefasMenu(3);
        }
        else if (e.getSource() == Conc){
            verTarefasMenu(2);
        }
        else if (e.getSource() == verNaoIniciadas){
            verTarefasMenu(1);
        }
                
        else if (e.getSource() == criarTarefa && projeto.getAcabado() == 0){
            String[] types = {"Design", "Desenvolvimento", "Documentação"};
            
            for (Docente pessoa: projeto.arrayDocentes){
                lista.add(pessoa.getNome());
            }
            for (Bolseiro pessoa: projeto.arrayBolseiros){
                if (pessoa.getUsed() == 0){
                    lista.add(pessoa.getNome());
                    
                }
            }
            
            
            JPanel p1=new JPanel();
            p1.setLayout(null);
            JLabel label1 = new JLabel("Nome");
            JLabel label2 = new JLabel("Tipo de Tarefa");
            JLabel label3 = new JLabel ("Pessoa Responsável");
            JLabel label4 = new JLabel("Dia de Inicio da Tarefa");
            JLabel label5 = new JLabel("Dia de Fim Estimado da Tarefa");
            buttonCriarTarefa = new JButton("Criar");
            
            nome = new JTextField(10);
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
            label4.setBounds(x/8,y*4/8-y/12,x/4,y/12);
            label5.setBounds(x/8,y*5/8-y/12,x/4,y/12);
            
            nome.setBounds(x/2, y/8-y/12, x*3/8, y/12);
            jComboBoxAction.setBounds(x/2 , y*2/8-y/12, x*3/8, y/12);
            jComboBoxAction1.setBounds(x/2 , y*3/8-y/12, x*3/8, y/12);
            dia1.setBounds(x/2 , y*4/8-y/12, x/8, y/12);
            mes1.setBounds(x/2  + x/8, y*4/8-y/12, x/8, y/12);
            ano1.setBounds(x/2  + x*2/8,y*4/8-y/12, x/8, y/12);
            dia2.setBounds(x/2  , y*5/8-y/12, x/8, y/12);
            mes2.setBounds(x/2  + x/8, y*5/8-y/12, x/8, y/12);
            ano2.setBounds(x/2  + x*2/8, y*5/8-y/12, x/8, y/12);
            
            buttonCriarTarefa.setBounds(x/8,y*6/8 + 10,x/2 + x/4,y/8);
            buttonCriarTarefa.addActionListener(this);
            p1.add(label1);
            p1.add(label2);
            p1.add(label3);
            p1.add(label4);
            p1.add(label5);
            
            p1.add(nome);
            p1.add(jComboBoxAction);
            p1.add(jComboBoxAction1);
            p1.add(dia1);
            p1.add(mes1);
            p1.add(ano1);
            p1.add(dia2);
            p1.add(mes2);
            p1.add(ano2);
            
            p1.add(buttonCriarTarefa);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(p1);
            frame.setVisible(true);
        }
        else if(e.getSource() == eliminarTarefa && projeto.getAcabado() == 0){
            eliminarTarefasMenu();
        }
        else if (e.getSource() == verDocente ){
            verDocenteMenu();
        }
        else if (e.getSource() == addDocente && projeto.getAcabado() == 0){
            addDocenteMenu();
        }
        else if (e.getSource() == eliminarDocente && projeto.getAcabado() == 0){
            eliminarDocenteMenu();
        }
        
        else if (e.getSource() == eliminarBolseiro && projeto.getAcabado() == 0){
            eliminarBolseiroMenu();
        }
        else if (e.getSource() == addBolseiro && projeto.getAcabado() == 0){
            addBolseiroMenu();
        }
        else if (e.getSource() == verBolseiro){
            verBolseiroMenu();
        }
        else if (e.getSource() == buttonRemoveDocente){
            Docente docente = projeto.getDocente((String) list.getSelectedValue());
            projeto.removeDocente(docente);
            eliminarDocenteMenu();
        }
        else if (e.getSource() == buttonRemoveBolseiro){
            Bolseiro bolseiro = projeto.getBolseiro((String) list.getSelectedValue());
            projeto.removeBolseiro(bolseiro);
            eliminarBolseiroMenu();
        }
        else if (e.getSource() == buttonVerTarefas){
            Tarefa tarefa = projeto.getTarefa((String) list.getSelectedValue());
            TarefaInterface tarefaInt = new TarefaInterface(tarefa, cisuc);
        }
        else if (e.getSource() == buttonRemoveTarefa){
            Tarefa tarefa = projeto.getTarefa((String) list.getSelectedValue());
            projeto.removeTarefa(tarefa);
            eliminarTarefasMenu();
        }
        else if (e.getSource() == buttonCriarTarefa){
            GregorianCalendar inicio = new GregorianCalendar();
            GregorianCalendar fim = new GregorianCalendar();
            Tarefa novo = null;
            
            inicio.set(ano1.getSelectedIndex()+2010, mes1.getSelectedIndex()+1, dia1.getSelectedIndex()+1);
            fim.set(ano2.getSelectedIndex()+2010,mes2.getSelectedIndex()+1, dia2.getSelectedIndex()+1);
            
            if (!nome.getText().equals("") && inicio.compareTo(fim) <= 0){
                
                if ( projeto.getBolseiro(jComboBoxAction1.getSelectedIndex()) == null || projeto.getBolseiro(jComboBoxAction1.getSelectedIndex()).getFimBolsa().after(fim)){
                    //ERRO 
                    System.out.printf("%s\n",projeto.getCargaPessoa(nome.getText(), inicio));
                    //ERRO
                    switch (jComboBoxAction.getSelectedIndex()) {
                        case 0:
                            if (projeto.getCargaPessoa(nome.getText(), inicio) + 0.5 <=1){
                                novo = new Design(nome.getText(),inicio,fim,projeto.getPessoa(jComboBoxAction1.getSelectedIndex()));
                                break;
                            }
                        case 1:
                            if (projeto.getCargaPessoa(nome.getText(), inicio) + 1 <=1){
                                novo = new Desenvolvimento(nome.getText(),inicio,fim,projeto.getPessoa(jComboBoxAction1.getSelectedIndex()));
                                break;
                            }
                        default:
                            if (projeto.getCargaPessoa(nome.getText(), inicio) + 0.25 <=1){
                                novo = new Documentacao(nome.getText(),inicio,fim,projeto.getPessoa(jComboBoxAction1.getSelectedIndex()));
                                break;
                            }
                    }

                    projeto.addTarefa(novo); 
                    TarefaInterface tarefaInt = new TarefaInterface(novo, cisuc);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Bolseiro Invalido","ERRO", JOptionPane.PLAIN_MESSAGE);
                }
            }

            else {
                JOptionPane.showMessageDialog(null, "Erro a Criar Tarefa","ERRO", JOptionPane.PLAIN_MESSAGE);

            }
        }
        else if (e.getSource() == buttonVerDocente){
            Docente docente = projeto.getDocente((String) list.getSelectedValue());
            DocenteInterface docenteInt =  new DocenteInterface(docente,cisuc);
        }
        else if (e.getSource() == buttonVerBolseiro){
            Bolseiro bolseiro = projeto.getBolseiro((String) list.getSelectedValue());
            BolseiroInterface bolseiroInt =  new BolseiroInterface(bolseiro,cisuc);
        }
        else if (e.getSource() == buttonAddDocente){
            Docente docente = cisuc.getDocente((String) list.getSelectedValue());
            projeto.addDocente(docente);
            addDocenteMenu();
        }
        else if(e.getSource() == buttonAddBolseiro){
            Bolseiro bolseiro = cisuc.getBolseiro((String) list.getSelectedValue());
            projeto.addBolseiro(bolseiro);
            addBolseiroMenu();
        }
        
    }
  
    
    private void MainMenu(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel label1 = new JLabel(String.format("Nome: %s",projeto.getNome()));
        JLabel label2 = new JLabel(String.format("Acronimo: %s",projeto.getAcronimo()));
        JLabel label4 = new JLabel(String.format("Data Estimada: %d-%d-%d",projeto.getDataEstimada().get(GregorianCalendar.YEAR),projeto.getDataEstimada().get(GregorianCalendar.MONTH)+1,projeto.getDataEstimada().get(GregorianCalendar.DAY_OF_MONTH))); 
        if (projeto.getAcabado() == 1){
            JLabel label41 = new JLabel(String.format("Data Final: %d-%d-%d",projeto.getDataFinal().get(GregorianCalendar.YEAR),projeto.getDataFinal().get(GregorianCalendar.MONTH)+1,projeto.getDataFinal().get(GregorianCalendar.DAY_OF_MONTH)));
            label41.setBounds(x/8,y*6/8-y/12,x*3/8,y/12);
            panel.add(label41);
        }
        JLabel label3 = new JLabel(String.format("Data Inicial: %d-%d-%d",projeto.getDataInicio().get(GregorianCalendar.YEAR),projeto.getDataInicio().get(GregorianCalendar.MONTH)+1,projeto.getDataInicio().get(GregorianCalendar.DAY_OF_MONTH)));
        JLabel label5 = new JLabel(String.format("IP: %s",projeto.getInvestigadorPrincipal().getNome()));
        JLabel label6 = new JLabel(String.format("Custo do Projeto: %s",projeto.getCusto()));
        
        label1.setBounds(x/8,y/8-y/12,x*3/8,y/12);
        label2.setBounds(x/8 + x/2,y/8-y/12,x*3/8,y/12);
        label6.setBounds(x/8,y*2/8-y/12,x*3/8,y/12);
        label5.setBounds(x/8,y*3/8-y/12,x*3/8,y/12);
        label3.setBounds(x/8,y*4/8-y/12,x*3/8,y/12);
        label4.setBounds(x/8,y*5/8-y/12,x*3/8,y/12);
        

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    
    private void verTarefasMenu(int num){
        JPanel p1=new JPanel();
        p1.setLayout(null);
        //verTodas,verNaoIniciadas, Conc, NConc;

        DefaultListModel listValues = new DefaultListModel();
        if (num ==0){
            JLabel label = new JLabel("Lista de Todas as Tarefas");
            label.setBounds(x/8,0,x/2,y/4);
            p1.add(label);
            for(Tarefa tarefa: projeto.arrayTarefas){
                listValues.addElement(tarefa.getNome());
            }
        }
        else if (num == 1){
            JLabel label = new JLabel("Lista de Todas as Tarefas Não Iniciadas");
            label.setBounds(x/8,0,x/2,y/4);
            p1.add(label);
            for(Tarefa tarefa: projeto.arrayTarefas){
                if (tarefa.getProgesso() == 0)
                    listValues.addElement(tarefa.getNome());
            }
        }
        else if (num == 2){
            JLabel label = new JLabel("Lista de Todas de Tarefas Concluidas");
            label.setBounds(x/8,0,x/2,y/4);
            p1.add(label);
            for(Tarefa tarefa: projeto.arrayTarefas){
                if (tarefa.getProgesso() == 100)
                listValues.addElement(tarefa.getNome());
            }
        }
        else{
            JLabel label = new JLabel("Lista de Todas de Tarefas Nao Concluidas na Data Estimada");
            label.setBounds(x/8,0,x/2,y/4);
            p1.add(label);
            for(Tarefa tarefa: projeto.arrayTarefas){
                if (tarefa.getProgesso() == 100 && tarefa.getDataFinal().after(tarefa.getDataEstimada()))
                listValues.addElement(tarefa.getNome());
            }
        } 
        buttonVerTarefas = new JButton("Vizualizar");
        buttonVerTarefas.setBounds(x*6/8,y/16,x/8,y/8);
        buttonVerTarefas.addActionListener(this);
        
        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        
        p1.add(buttonVerTarefas);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    private void eliminarTarefasMenu(){
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
    
    private void verDocenteMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        buttonVerDocente = new JButton("Selecionar");
        buttonVerDocente.setBounds(x*6/8,y/16,x/8,y/8);
        buttonVerDocente.addActionListener(this);
        JLabel label = new JLabel("Lista de Docentes");
        label.setBounds(x/8,0,x/2,y/4);
        
        for(Pessoa docente: projeto.arrayDocentes){
            listValues.addElement(docente.getNome());
        }
        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);
        
        p1.add(buttonVerDocente);
        p1.add(label);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    private void eliminarDocenteMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Remover Docente");
        buttonRemoveDocente = new JButton("Remove");
        label.setBounds(x/8,0,x/2,y/4);
        buttonRemoveDocente.setBounds(x*6/8,y/16,x/8,y/8);
        buttonRemoveDocente.addActionListener(this);
        
        for(Pessoa docente: projeto.arrayDocentes){
            listValues.addElement(docente.getNome());
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonRemoveDocente);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    
    private void verBolseiroMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        buttonVerBolseiro = new JButton("Selecionar");
        buttonVerBolseiro.setBounds(x*6/8,y/16,x/8,y/8);
        buttonVerBolseiro.addActionListener(this);
        JLabel label = new JLabel("Lista de Bolseiros");
        label.setBounds(x/8,0,x/2,y/4);
        
        for(Pessoa bolseiro: projeto.arrayBolseiros){
            listValues.addElement(bolseiro.getNome());
        }
        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);
        
        p1.add(buttonVerBolseiro);
        p1.add(label);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    private void eliminarBolseiroMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Remover Bolseiro");
        buttonRemoveBolseiro = new JButton("Remove");
        label.setBounds(x/8,0,x/2,y/4);
        buttonRemoveBolseiro.setBounds(x*6/8,y/16,x/8,y/8);
        buttonRemoveBolseiro.addActionListener(this);
        
        for(Pessoa bolseiro: projeto.arrayBolseiros){
            listValues.addElement(bolseiro.getNome());
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonRemoveBolseiro);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    private void addDocenteMenu(){
        
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Adicionar Docente");
        buttonAddDocente = new JButton("Adicionar");
        label.setBounds(x/8,0,x/2,y/4);
        buttonAddDocente.setBounds(x*6/8,y/16,x/8,y/8);
        buttonAddDocente.addActionListener(this);
        
        for(Pessoa docente: cisuc.arrayDocentes){
            if (projeto.getDocente(docente.getNome()) == null) {
                listValues.addElement(docente.getNome());
            }
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonAddDocente);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
    
    private void addBolseiroMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Adicionar Bolseiro");
        buttonAddBolseiro = new JButton("Adicionar");
        label.setBounds(x/8,0,x/2,y/4);
        buttonAddBolseiro.setBounds(x*6/8,y/16,x/8,y/8);
        buttonAddBolseiro.addActionListener(this);
        
        for(Bolseiro bolseiro: cisuc.arrayBolseiros){
            if (bolseiro.getUsed() == 0)
            listValues.addElement(bolseiro.getNome());
        }


        list = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setBounds(x/8,y/4, x*3/4, y/2);

        p1.add(label);
        p1.add(buttonAddBolseiro);
        p1.add(listScroller);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
    }
}
