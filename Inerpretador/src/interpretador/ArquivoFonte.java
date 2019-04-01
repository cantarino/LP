/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

/**
 *
 * @author cantarino
 */
public class ArquivoFonte {
    private String nomedoArquivo;
    private Vector palavras;
    private int contador;
    //Construtor
    public ArquivoFonte(String nome){
        this.nomedoArquivo = nome;
        contador = 0;
        palavras = new Vector();
    }
    
    //Retorna a proxima linha de comando
    public void LeArquivo(){
        
        FileReader leitor = null;
        try {
            leitor = new FileReader(nomedoArquivo);
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
            System.exit(0);
        }
        
        BufferedReader bleitor = new BufferedReader(leitor); 
        String s = "";
        int i=0;
        while (s != null) {
            try {
                s = bleitor.readLine();
            } catch (IOException ex) {
                System.out.println("IOException" + ex);
            }
            palavras.addElement(s);
            i++;
        }
        palavras.remove(i-1);
        palavras.addElement("EOF");

    }
    
    public String proximaPalavra(){
        //Retornar somente o comando -> separar a string pra so ter o comando
        contador++;
        String s = (String) palavras.elementAt(contador-1);
        if(s.contains("writeln"))
            return "writeln";
        else if (s.contains("endp"))
            return "endp";
        else if (s.contains("writeStr"))
            return "writeStr";
        else if (s.contains("read"))
            return "read";
        else if (s.contains("writeVar"))
            return "writeVar";
        else if (s.contains("EOF"))
            return "EOF";
        return "erro";
    }
    
    public void imprime(){
        for(int i=0;i<palavras.size();i++)
            System.out.println(palavras.elementAt(i));
    }
    
    public void zeraCont(){
        this.contador = 0;
    }
    
        //Retornar o resto
    public String pegaResto(String comandoAtual){
        String s = (String) palavras.elementAt(contador-1);
        if(comandoAtual.equals("read") || comandoAtual.equals("writeVar")){
             //Split nao funciona 
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '('){
                    String r = String.valueOf(s.charAt(i+1));
                    return r;
                }
            }
             
         }
         if(comandoAtual.equals("writeStr")){
            String [] a = s.split("\"");
            return a[1];
         }
        return "erro";
    }
    

    
    
}
