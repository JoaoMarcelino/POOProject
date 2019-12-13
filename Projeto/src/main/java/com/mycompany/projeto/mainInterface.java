/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.projeto;
import static com.mycompany.projeto.Main.writeObjFiles;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.*;


/**
 *
 * @author hp
 */
public class mainInterface implements ActionListener {  
    
    private Cisuc cisuc;
    
    int x = 800;
    int y = 450;
        
    private JFrame frame;
    private JList list;
    private JMenuBar bar;
    private JMenu menu1, menu2, menu3, main, verItemProjeto;

    private JMenuItem save,mainMenu,itemTodos,itemNConc,itemConc,itemConcFora,criarItemProjeto,eliminarItemProjeto,itemDocente1,itemDocente2,itemDocente3,itemBolseiro1,itemBolseiro2,itemBolseiro3;

    
    private JButton buttonProjeto;
    private JButton buttonCriarProjeto;
    private JButton buttonElProjeto;
    private JButton buttonDocente;
    private JButton buttonCriarDocente;
    private JButton buttonElDocente;
    private JButton buttonBolseiro;
    private JButton buttonCriarBolseiro;
    private JButton buttonElBolseiro;
    

    
    private JTextField email;
    private JTextField nmecan;
    private JTextField area;
    
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

    
    mainInterface(Cisuc cisuc){
       
        
        for (int i =1; i<=31; i++){
            dia.add(String.format("%d",i));
        }
        
        for (int i =1; i<=12; i++){
            mes.add(String.format("%d",i));
        }
        for (int i =2010; i<=2100; i++){
            ano.add(String.format("%d",i));
        }
        
        this.cisuc = cisuc;
        frame = new JFrame();
        bar = new JMenuBar();
        
        
        
        main = new JMenu("Main Menu");
        menu1 = new JMenu("Projetos");
        menu2 = new JMenu("Docentes");
        menu3 = new JMenu("Bolseiros");
        
        mainMenu = new JMenuItem("Main Menu");
        save = new JMenuItem("Save");
        
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
        itemConcFora =  new JMenuItem("Não Concluidos na Data");
        
        
        mainMenu.addActionListener(this);
        save.addActionListener(this);
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
        itemConcFora.addActionListener(this);

        bar.add(main);
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        
        main.add(mainMenu);
        main.add(save);
        
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
        verItemProjeto.add(itemConcFora);
        
        
        frame.setJMenuBar(bar);
        frame.setResizable(false);
        frame.setTitle("PROGRAMA CISUC");
        frame.setSize(x, y+60);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        mainMenu();

    }

    @Override
    public void actionPerformed(ActionEvent e) {  
        
        if (e.getSource() == mainMenu){
            mainMenu();

        }
        else if(e.getSource() == save){
            writeObjFiles(cisuc);
            JOptionPane.showMessageDialog(null, "Guardado com Sucesso!", "Saved", JOptionPane.PLAIN_MESSAGE);

        }
        
        else if(e.getSource()==itemTodos){
            verProjetoMenu(2);
        }
        
        
        else if(e.getSource()==itemNConc){
            verProjetoMenu(0);
        }
        
        
        else if(e.getSource()==itemConc){
            verProjetoMenu(1);
        }
        else if (e.getSource()==itemConcFora){
            verProjetoMenu(3);
        }
        
        else if(e.getSource()==criarItemProjeto){
            criarProjetoMenu();
        }
        
        else if(e.getSource()==eliminarItemProjeto){
            EliminarProjetoMenu();
        }
        
        else if (e.getSource()==itemDocente1){
            verDocenteMenu();
        }
        else if(e.getSource()==itemDocente2){
            criarDocenteMenu();
              
        }
        else if(e.getSource()==itemDocente3){
            EliminarDocenteMenu();
        }
        
        else if (e.getSource()==itemBolseiro1){
            verBolseiroMenu();
        }
        
        else if(e.getSource()==itemBolseiro2){
           criarBolseiroMenu();
        } 
        
        else if(e.getSource()==itemBolseiro3){
           EliminarBolseiroMenu();
        }

        else if(e.getSource() == buttonProjeto){
            Projeto projeto = cisuc.getProjeto((String) list.getSelectedValue());
            ProjetoInterface projetoInt = new ProjetoInterface(projeto,cisuc);
        }
        
        else if(e.getSource() == buttonDocente){
            Docente docente = cisuc.getDocente((String) list.getSelectedValue());
            DocenteInterface docenteInt = new DocenteInterface(docente, cisuc);
        }
        
        else if(e.getSource() == buttonBolseiro){
            Bolseiro bolseiro = cisuc.getBolseiro((String) list.getSelectedValue());
            BolseiroInterface bolseiroInt = new BolseiroInterface(bolseiro, cisuc);
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
        else if (e.getSource() == buttonCriarProjeto){
            GregorianCalendar inicio = new GregorianCalendar();
            GregorianCalendar fim = new GregorianCalendar();

            inicio.set(ano1.getSelectedIndex()+2010, mes1.getSelectedIndex()+1, dia1.getSelectedIndex()+1);
            fim.set(ano2.getSelectedIndex()+2010,mes2.getSelectedIndex()+1, dia2.getSelectedIndex()+1);
           
            if (!nome.getText().equals("") && !acronimo.getText().equals("") && inicio.compareTo(fim) <= 0){
                Projeto novo = cisuc.criaProjeto(nome.getText(),acronimo.getText(), inicio, fim, cisuc.getDocente(jComboBoxAction.getSelectedIndex(),0).getNome());
                if (novo != null){
                    ProjetoInterface projetoInt = new ProjetoInterface(novo, cisuc);
                }
                else{
                   JOptionPane.showMessageDialog(null, "Erro na Criaçao de Projeto","You shouldn't be here", JOptionPane.PLAIN_MESSAGE); 
                }  
            }
            else{
                JOptionPane.showMessageDialog(null, "Dados Mal Inseridos","Erro", JOptionPane.PLAIN_MESSAGE);
            }
            criarProjetoMenu();
        }
        
        else if (e.getSource() == buttonCriarDocente){
            if(!nome.getText().equals("") && !email.getText().equals("") && !nmecan.getText().equals("") && !area.getText().equals("")){
                Docente novo = new Docente(nome.getText(), email.getText(), Integer.parseInt(nmecan.getText()),area.getText());
                cisuc.addDocente(novo);
                DocenteInterface docenteInt = new DocenteInterface(novo, cisuc);
            }
            else{
                JOptionPane.showMessageDialog(null, "Dados Mal Inseridos","Erro", JOptionPane.PLAIN_MESSAGE);
            }
        }
        
        else if(e.getSource() == buttonCriarBolseiro){
            GregorianCalendar inicio = new GregorianCalendar();
            GregorianCalendar fim = new GregorianCalendar();
            Bolseiro novo = null;
            inicio.set(ano1.getSelectedIndex()+2010, mes1.getSelectedIndex()+1, dia1.getSelectedIndex()+1);
            fim.set(ano2.getSelectedIndex()+2010,mes2.getSelectedIndex()+1, dia2.getSelectedIndex()+1);
            
            if (!nome.getText().equals("") && !email.getText().equals("") && inicio.compareTo(fim) <= 0){
                if (jComboBoxAction.getSelectedIndex() == 0){
                    novo = new Licenciado(nome.getText(),email.getText(),inicio,fim,cisuc.getDocente(jComboBoxAction1.getSelectedIndex()));
                }
                else if (jComboBoxAction.getSelectedIndex() == 1){
                    novo = new Mestre(nome.getText(),email.getText(),inicio,fim,cisuc.getDocente(jComboBoxAction1.getSelectedIndex()));
                }
                else{
                    novo = new Doutorado(nome.getText(),email.getText(),inicio,fim);
                }
                
                cisuc.addBolseiro(novo); 
                BolseiroInterface bolseiroInt = new BolseiroInterface(novo, cisuc);
            }
            else {
                JOptionPane.showMessageDialog(null, "Dados Mal Inseridos","Erro", JOptionPane.PLAIN_MESSAGE);
            }
            criarBolseiroMenu();
        }
    }
    
    
    
    void mainMenu(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel  label0 = new JLabel("CISUC - Projeto POO");
        JLabel  label1 = new JLabel("João Marcelino e José Esperança");
        

        label0.setBounds(x/3,y*3/8,x/2,y/8);
        label1.setBounds(x/3,y*4/8,x/2,y/8);
        
        panel.add(label0);
        panel.add(label1);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
    
    void criarProjetoMenu(){
        for (Docente docente: cisuc.arrayDocentes){
            System.out.printf("%d\n",docente.getIP());
            if (docente.getIP() == 0){
                lista.add(docente.getNome());
                System.out.printf("PRINTED %s\n",docente.getNome());
            }
        }
        JPanel p1=new JPanel();
        p1.setLayout(null);
        JLabel label1 = new JLabel("Nome");
        JLabel label2 = new JLabel("Acronimo");
        JLabel label3 = new JLabel ("Investigador Principal");
        JLabel label4 = new JLabel("Data de Inicio");
        JLabel label5 = new JLabel("Data Estimada");
        buttonCriarProjeto = new JButton("Criar");

        nome = new JTextField(10);
        acronimo = new JTextField(10);
        jComboBoxAction = new JComboBox(lista.toArray());
        lista.clear();
        dia1 = new JComboBox(dia.toArray());
        mes1 = new JComboBox(mes.toArray());
        ano1 = new JComboBox(ano.toArray());
        dia2 = new JComboBox(dia.toArray());
        mes2 = new JComboBox(mes.toArray());
        ano2 = new JComboBox(ano.toArray());

        label1.setBounds(x/8,y/8,x/4,y/12);
        label2.setBounds(x/8,y*2/8,x/4,y/12);
        label3.setBounds(x/8,y*3/8,x/4,y/12);
        label4.setBounds(x/8,y*4/8,x/4,y/12);
        label5.setBounds(x/8,y*5/8,x/4,y/12);

        nome.setBounds(x/2+ x/8,y/8,x/4,y/12);
        acronimo.setBounds(x/2+ x/8,y*2/8,x/4,y/12);
        jComboBoxAction.setBounds(x/2+ x/8,y*3/8,x/4,y/12);
        dia1.setBounds(x/2+ x/8,y*4/8,x/12,y/12);
        mes1.setBounds(x/2+ x/8 +x/12,y*4/8,x/12,y/12);
        ano1.setBounds(x/2+ x/8 +x*2/12,y*4/8,x/12,y/12);
        dia2.setBounds(x/2+ x/8,y*5/8,x/12,y/12);
        mes2.setBounds(x/2+ x/8 +x/12,y*5/8,x/12,y/12);
        ano2.setBounds(x/2+ x/8 +x*2/12,y*5/8,x/12,y/12);

        buttonCriarProjeto.setBounds(x/8,y*6/8 + 10,x/2 + x/4,y/8);
        buttonCriarProjeto.addActionListener(this);

        p1.add(label1);
        p1.add(label2);
        p1.add(label3);
        p1.add(label4);
        p1.add(label5);

        p1.add(nome);
        p1.add(acronimo);
        p1.add(jComboBoxAction);
        p1.add(dia1);
        p1.add(mes1);
        p1.add(ano1);
        p1.add(dia2);
        p1.add(mes2);
        p1.add(ano2);

        p1.add(buttonCriarProjeto);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(p1);
        frame.setVisible(true);
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
        else if (num == 3){
            tipo = "Concluidos fora da Data Estimada";
            for(Projeto projeto: cisuc.arrayProjetos){
                if (projeto.getAcabado() == 1 && projeto.getDataFinal().after(projeto.getDataEstimada()))
                    listValues.addElement(projeto.getNome());
            }
        }
        else{
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
    
    
    void criarDocenteMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        JLabel label1 = new JLabel("Nome");
        JLabel label2 = new JLabel("E-mail");
        JLabel label3 = new JLabel("Número Mecanográfico");
        JLabel label4 = new JLabel("Area de Investigação");
        buttonCriarDocente = new JButton("Criar");

        nome = new JTextField(10);
        email = new JTextField(10);
        nmecan = new JTextField(10);
        area = new JTextField(10);

        label1.setBounds(x/8,y/8,x/4,y/12);
        label2.setBounds(x/8,y*2/8,x/4,y/12);
        label3.setBounds(x/8,y*3/8,x/4,y/12);
        label4.setBounds(x/8,y*4/8,x/4,y/12);

        nome.setBounds(x/2 + x/8,y/8,x/4,y/12);
        email.setBounds(x/2+ x/8,y*2/8,x/4,y/12);
        nmecan.setBounds(x/2+ x/8,y*3/8,x/4,y/12);
        area.setBounds(x/2+ x/8,y*4/8,x/4,y/12);

        buttonCriarDocente.setBounds(x/8,y*6/8 + 10,x/2 + x/4,y/8);
        buttonCriarDocente.addActionListener(this);

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
    
    void verDocenteMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);
        

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Lista de Docentes ");
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
    
    void criarBolseiroMenu(){
        String[] types = {"Licenciado", "Mestrado", "Doutorado"};

       for (Docente docente: cisuc.arrayDocentes){
           lista.add(docente.getNome());
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
       lista.clear();
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
    
    void verBolseiroMenu(){
        JPanel p1=new JPanel();
        p1.setLayout(null);

        DefaultListModel listValues = new DefaultListModel();
        JLabel label = new JLabel("Lista de Bolseiro ");
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