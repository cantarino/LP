package interpretador;

import java.io.*;  
import java.util.*;


class ComandoWriteVar extends Comando {
   
   char variavel;
   	
   ComandoWriteVar(int lin, String txt) {
      linha= lin;
      variavel= txt.charAt(0);
   }
   
   public int executa() {
      //Insira seu codigo
      //System.out.println(variavel);
      return linha+1;
   }
   
   public void executa(Variaveis var){
       System.out.print(var.getVariavel(variavel));
   }
}