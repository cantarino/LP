package interpretador;

import java.io.*;  
import java.util.*;
    

public class tiny {
   
   public static void main(String[] args) {
      
      Interpretador inter= new Interpretador(args[0]);
      /*
      if (args.length == 1) {
         inter.leArquivo();
         inter.executa();
      }
      else if ((args.length == 2) && (args[1].equals("-l")))
         inter.listaArquivo();
*/
       int i = 1;
       if (i == 1) {
           inter.leArquivo();
           inter.executa();
       } else {
           inter.listaArquivo();
       }
    }
}
