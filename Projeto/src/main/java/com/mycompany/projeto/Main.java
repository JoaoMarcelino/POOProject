package com.mycompany.projeto;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

/**
 * @author José Esperança 2018278596
 * @author João Marcelino 2018279700
 */

public class Main {
    
    /**
     * Funcao auxiliar para a leitura de ficheiros -- aux = 0 - pessoas | 1 - projetos | 2 - tarefas
     * @param f ficheiro
     * @param aux aux = 0 pessoas, = 1 projetos, = 2 tarefas
     * @param cisuc objeto da classe cisuc
     */
    public static void readText(File f, int aux, Cisuc cisuc){
        
        if(f.exists() && f.isFile()) {
            
            try {
                
                FileReader fileReader = new FileReader(f);
                try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    String line;
                    String split[];
                    Tarefa tarefa;
                    GregorianCalendar data1;
                    GregorianCalendar data2;
                    
                    while((line = bufferedReader.readLine()) != null) {
                        split = line.split("//");
                        
                        switch (aux) {
                            case 0:
                                if (split[0].equals("D")){
                                    Docente docente = new Docente(split[1],split[2],Integer.parseInt(split[3]),split[4]);
                                    cisuc.addDocente(docente);
                                }
                                
                                else{
                                    data1 = new GregorianCalendar(Integer.parseInt(split[3].split("-")[2]),Integer.parseInt(split[3].split("-")[1]),Integer.parseInt(split[3].split("-")[0]));
                                    data2 = new GregorianCalendar(Integer.parseInt(split[4].split("-")[2]),Integer.parseInt(split[4].split("-")[1]),Integer.parseInt(split[4].split("-")[0]));
                                    switch (split[0]) {
                                        case "BD":
                                            Bolseiro bolseiro = new Doutorado(split[1],split[2],data1,data2);
                                            cisuc.addBolseiro(bolseiro);
                                            break;
                                        case "BM":
                                            for(Docente docente : cisuc.getArrayDocentes()){
                                                if (docente.getNome().equals(split[5])){
                                                    Mestre mestre = new Mestre(split[1],split[2],data1,data2,docente);
                                                    docente.addEstudante(mestre);
                                                    cisuc.addBolseiro(mestre);
                                                    break;
                                                }
                                            }
                                            break;
                                        default:
                                            for(Docente docente : cisuc.getArrayDocentes()){
                                                if (docente.getNome().equals(split[5])){
                                                    Licenciado licenciado = new Licenciado(split[1],split[2],data1,data2,docente);
                                                    docente.addEstudante(licenciado);
                                                    cisuc.addBolseiro(licenciado);
                                                    break;
                                                }
                                            }                                            
                                            break;
                                    }
                                }  
                                break;
                                
                            case 1:
                                
                                data1 = new GregorianCalendar(Integer.parseInt(split[2].split("-")[2]),Integer.parseInt(split[2].split("-")[1]),Integer.parseInt(split[2].split("-")[0]));
                                data2 = new GregorianCalendar(Integer.parseInt(split[3].split("-")[2]),Integer.parseInt(split[3].split("-")[1]),Integer.parseInt(split[3].split("-")[0]));
                                
                                if (cisuc.criaProjeto(split[0],split[1],data1,data2,split[4]) == null)
                                    System.out.println("Erro a criar projeto");
                                break;
                                
                            default:
                                data1 = new GregorianCalendar(Integer.parseInt(split[2].split("-")[2]),Integer.parseInt(split[2].split("-")[1]),Integer.parseInt(split[2].split("-")[0]));
                                data2 = new GregorianCalendar(Integer.parseInt(split[3].split("-")[2]),Integer.parseInt(split[3].split("-")[1]),Integer.parseInt(split[3].split("-")[0]));
                                Projeto proj  = cisuc.getProjeto(split[1]);                                
                                Pessoa p = proj.getPessoa(split[5]);
                                
                                switch (split[4]) {
                                    case "Documentacao":
                                       if (p.getCarga() <= 0.75){
                                           tarefa = new Documentacao(split[0],data1,data2,p);
                                           
                                           proj.addTarefa(tarefa);
                                        }
                                        break;
                                    case "Design":
                                        if (p.getCarga() <= 0.5){
                                            tarefa = new Design(split[0],data1,data2,p);
                                            
                                            proj.addTarefa(tarefa);
                                        }
                                        break;
                                    default:
                                        if (p.getCarga() == 0){
                                            tarefa = new Desenvolvimento(split[0],data1,data2,p);
                                           
                                            proj.addTarefa(tarefa);
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                }
            } 
            
            catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir");
            }
            
            catch (IOException ex) {
                System.out.println("Erro a ler");
            }
        }
        
        else {
            System.out.println("Ficheiro não encontrado");
        }
    }
    
    /**
     * le os ficheiros de texto
     * @param cisuc objeto da classe cisuc
     */
    public static void readTextFiles(Cisuc cisuc){
        
        File tarefas = new File("Tarefas.txt");
        File projetos = new File("Projetos.txt");
        File pessoas = new File("Pessoas.txt");     
        
        readText(pessoas, 0, cisuc);
        readText(projetos, 1, cisuc);
        readText(tarefas, 2, cisuc);
        
    }
    
    /**
     * funcao auxiliar para a leitura de object files
     * @param cisuc objeto da classe cisuc
     * @param aux aux = 0 projetos, = 1 bolseiros, = 2 docentes
     * @param f ficheiro
     * @return 1 if error, else 0
     */
    public static int readObjects(Cisuc cisuc, int aux, File f){
        
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true){ 
                try{
                    switch (aux) {
                        case 0:
                            cisuc.addProjeto((Projeto)ois.readObject());
                            break;
                        case 1:
                            cisuc.addBolseiro((Bolseiro)ois.readObject());
                            break;
                        default:
                            cisuc.addDocente((Docente)ois.readObject());
                            break;
                    }
                } 
                catch (ClassNotFoundException ex) {
                    System.out.println("Erro a converter objeto");
                } 
                catch (EOFException ex){
                    ois.close();
                    return 0;
                }
            } 
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");      
        }
        return 1;
    }
    
    /**
     * Le ficheiros de objetos
     * @param cisuc objeto da classe cisuc
     */
    public static void readObjFiles(Cisuc cisuc){
        
        File projetos = new File("Projetos.obj");
        File bolseiros = new File("Bolseiros.obj");   
        File docentes = new File("Docentes.obj");     
        
        readObjects(cisuc, 0, projetos);
        readObjects(cisuc, 1, bolseiros);
        readObjects(cisuc, 2, docentes);
    }
    
    /**
     * Escreve ficheiros de obejtos
     * @param cisuc objeto da classe cisuc
     */
    public static void writeObjFiles(Cisuc cisuc){
        
        File projetos = new File("Projetos.obj");
        File bolseiros = new File("Bolseiros.obj");   
        File docentes = new File("Docentes.obj");     
        
        writeObjects(cisuc, 0, projetos);
        writeObjects(cisuc, 1, bolseiros);
        writeObjects(cisuc, 2, docentes);
    }
    
    /**
     * Funcao que escreve os ficheiros de objetos
     * @param cisuc objeto da classe cisuc
     * @param aux aux = 0 projetos, = 1 bolseiros, = 2 docentes
     * @param f ficheiro
     */
    public static void writeObjects(Cisuc cisuc, int aux, File f){
            
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            switch (aux) {
                case 0:
                    for (Projeto projeto : cisuc.getArrayProjetos())
                        oos.writeObject(projeto);
                    break;
                case 1:
                    for (Pessoa bolseiro : cisuc.getArrayBolseiros())
                        oos.writeObject(bolseiro);
                    break;
                default:
                    for (Pessoa docente : cisuc.getArrayDocentes())
                        oos.writeObject(docente);
                    break;
            }
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");

        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }

    }
    
    public static void main(String[] args) throws IOException {
        
        GregorianCalendar dataAtual = new GregorianCalendar();
        Cisuc cisuc = new Cisuc(dataAtual);
        
        
        File pFile = new File("Projetos.obj");
        File bFile = new File("Bolseiros.obj");
        File dFile = new File("Docentes.obj");
        
        if (pFile.exists() && pFile.isFile() && bFile.exists() && bFile.isFile() && dFile.exists() && dFile.isFile())
            readObjFiles(cisuc);
            
        else
            readTextFiles(cisuc);
        
        mainInterface mainInterface = new mainInterface(cisuc);
        
    }
}