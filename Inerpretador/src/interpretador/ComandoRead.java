package interpretador;

import java.io.*;  
import java.util.*;


class ComandoRead extends Comando {
   
   Scanner teclado = new Scanner (System.in);
   char variavel;
   float num;
   	
   ComandoRead(int lin, String txt) {
      linha= lin;
      variavel= txt.charAt(0);
      num=0;
   }
   
   public int executa() {
       	
      try {
         //Insira seu codigo
         num = teclado.nextFloat();
      }
      catch(InputMismatchException e) {
         System.out.println("ERRO: Tipo de variavel incompativel");
         System.exit(0);
      }
      return linha+1;
   }
   
   public char getVariavel(){
       return this.variavel;
   }
   
   public float getNum(){
       return this.num;
   }
}