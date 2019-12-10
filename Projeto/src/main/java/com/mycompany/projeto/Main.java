package com.mycompany.projeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * @author José Esperança 2018278596
 * @author João Marcelino 2018279700
 */

public class Main {
    
    public static void readText(File f, int aux, Cisuc cisuc){
           
        if(f.exists() && f.isFile()) {
            
            try {
                
                FileReader fileReader = new FileReader(f);
                try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    String line;
                    String split[];
                    Pessoa pessoa;
                    Projeto projeto;
                    Tarefa tarefa;
                    GregorianCalendar data1;
                    GregorianCalendar data2;
                    
                    while((line = bufferedReader.readLine()) != null) {
                        split = line.split("//");
                        
                        switch (aux) {
                            case 0:
                                if (split[0].equals("D")){
                                    pessoa = new Docente(split[1],split[2],Integer.parseInt(split[3]),split[4]);
                                    cisuc.addDocente(pessoa);
                                }
                                
                                else{
                                    data1 = new GregorianCalendar(Integer.parseInt(split[3].split("-")[2]),Integer.parseInt(split[3].split("-")[1]),Integer.parseInt(split[3].split("-")[0]));
                                    switch (split[0]) {
                                        case "BD":
                                            pessoa = new Doutorado(split[1],split[2],data1);
                                            break;
                                        case "BM":
                                            pessoa = new Mestre(split[1],split[2],data1);
                                            break;
                                        default:
                                            pessoa = new Licenciado(split[1],split[2],data1);
                                            break;
                                    }
                                    
                                    cisuc.addBolseiro(pessoa);
                                }   break;
                                
                            case 1:
                                
                                data1 = new GregorianCalendar(Integer.parseInt(split[2].split("-")[2]),Integer.parseInt(split[2].split("-")[1]),Integer.parseInt(split[2].split("-")[0]));
                                data2 = new GregorianCalendar(Integer.parseInt(split[3].split("-")[2]),Integer.parseInt(split[3].split("-")[1]),Integer.parseInt(split[3].split("-")[0]));
                                projeto = new Projeto(split[0], split[1], data1, data2);
                                cisuc.addProjeto(projeto);
                                
                                break;
                                
                            default:
                                data1 = new GregorianCalendar(Integer.parseInt(split[2].split("-")[2]),Integer.parseInt(split[2].split("-")[1]),Integer.parseInt(split[2].split("-")[0]));
                                data2 = new GregorianCalendar(Integer.parseInt(split[3].split("-")[2]),Integer.parseInt(split[3].split("-")[1]),Integer.parseInt(split[3].split("-")[0]));
                                
                                switch (split[4]) {
                                    case "Documentacao":
                                        tarefa = new Documentacao(split[0],data1,data2);
                                        break;
                                    case "Design":
                                        tarefa = new Design(split[0],data1,data2);
                                        break;
                                    default:
                                        tarefa = new Desenvolvimento(split[0],data1,data2);
                                        break;
                                }
                                
                                projeto = cisuc.getProjeto(split[1]);
                                if ("NOTEXISTENT".equals(projeto.getNome()))
                                    break;
                                projeto.addTarefa(tarefa);
                                
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
    
    public static void readTextFiles(Cisuc cisuc){
        
        File tarefas = new File("Tarefas.txt");
        File projetos = new File("Projetos.txt");
        File pessoas = new File("Pessoas.txt");     
        
        readText(pessoas, 0, cisuc);
        readText(projetos, 1, cisuc);
        readText(tarefas, 2, cisuc);
    }
    
    public static void readObjFiles(){
        
        
    }
    
    public static void main(String[] args) throws IOException {
        
        GregorianCalendar dataAtual = new GregorianCalendar();
        Cisuc cisuc = new Cisuc(dataAtual);
        
        mainInterface mainInterface = new mainInterface(cisuc);
        
        readTextFiles(cisuc);
        
        cisuc.printPessoas();
        cisuc.naoConcluidos();
        cisuc.printTarefas();
    }
}