package interpretador;

import java.io.*;  
import java.util.*;


class ComandoWriteStr extends Comando {
   
   String texto;
   
   ComandoWriteStr(int lin, String txt) {
      linha= lin;
      texto= txt;
   }
   
   
   public int executa() {
      //Insira seu codigo
      System.out.print(texto);
      return linha+1;
   }
}