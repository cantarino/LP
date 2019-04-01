   package TP01.Comando;
	
  import TP01.Variavel.*;
import java.io.*;
import java.util.Scanner;
	 
    public class ComandoRead extends Comando {
   
      Scanner teclado = new Scanner (System.in);
      char variavel;
   	
        public ComandoRead(int lin, String txt) {
            linha = lin;
            variavel = txt.charAt(0);
        }
   
       public int executa() {
       	
         try {
             double d = teclado.nextDouble();
             Variaveis.var[variavel-97] = d;
            
         }
             catch( Exception e) {
               System.out.println("ERRO: "+e);
            }
         return linha+1;
      }
   }

