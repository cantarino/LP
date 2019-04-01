package interpretador;

import java.io.*;  
import java.util.*;

class ComandoWriteln extends Comando {
   	
   ComandoWriteln(int lin) {
      linha= lin;
   }
   
   public int executa() {
      System.out.println();
      return linha+1;
   }
}