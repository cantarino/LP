package interpretador;

import java.io.*;  
import java.util.*;

class Interpretador {
   private ArquivoFonte arq;
   private Vector comandos;   
   private String palavraAtual;
   private Variaveis var;
   		
   public Interpretador(String nome) {
      arq= new ArquivoFonte(nome);
      comandos= new Vector();
      arq.LeArquivo();
      var = new Variaveis();
   }
   
   public void listaArquivo() {
      String palavra;
      
      do {
         palavra= arq.proximaPalavra();
         System.out.println ("Palavra: " + palavra);
      } while (!palavra.equals("EOF"));
   }
   
   public void leArquivo() {
       
      String comandoAtual;
      int linha= 0;
      String str = "";
      do {
         comandoAtual= arq.proximaPalavra();
            
         if(comandoAtual.equals("endp")){
            trataComandoEndp(linha);
            linha++;
         }
         else if(comandoAtual.equals("writeln")){
            trataComandoWriteln(linha);
            linha++;
         }
         else if(comandoAtual.equals("read")){
            str = arq.pegaResto(comandoAtual);
            trataComandoRead(linha,str);
            linha++;
         }
         else if(comandoAtual.equals("writeStr")){
            str = arq.pegaResto(comandoAtual);
            trataComandoWriteStr(linha,str);
            linha++;
         }
         else if(comandoAtual.equals("writeVar")){
            str = arq.pegaResto(comandoAtual);
            trataComandoWriteVar(linha,str);
            linha++;
         }
             
         System.out.println(comandoAtual);
      } while (!comandoAtual.equals("endp"));
   }
   
   private void trataComandoEndp(int lin) {
      
      ComandoEndp c= new ComandoEndp(lin);
      comandos.addElement(c);
   }
   	   	
   private void trataComandoWriteln(int lin) {
      
      ComandoWriteln c= new ComandoWriteln(lin);
      comandos.addElement(c);
   }
   
    private void trataComandoRead(int lin, String txt) {

        ComandoRead c = new ComandoRead(lin, txt);
        comandos.addElement(c);
    }

    private void trataComandoWriteStr(int lin, String txt) {
        
        ComandoWriteStr c = new ComandoWriteStr(lin,txt);
        comandos.addElement(c);
    }
    
    private void trataComandoWriteVar(int lin,String txt) {
      ComandoWriteVar c= new ComandoWriteVar(lin,txt);
      comandos.addElement(c);
   }
   
   public void executa() {
      
      Comando cmd;
      ComandoRead c;
      int pc= 0;
      do {
         cmd= (Comando) comandos.elementAt(pc);
         pc= cmd.executa();
         if(cmd instanceof ComandoRead){
             c= (ComandoRead) cmd;
             var.setVariavel(c.getVariavel(), c.getNum());
         }
          if (cmd instanceof ComandoWriteVar) {
              ((ComandoWriteVar) cmd).executa(var);
         }
      } while (pc != -1);
   }   
}
