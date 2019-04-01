    package TP01;
   import java.io.*;  
   import java.util.*;

    @SuppressWarnings("unused")
	public class tiny {
   
       public static void main(String[] args) {
      
         Interpretador inter= new Interpretador(args[0]);
         int i = 1;
         if (i == 1) {
            inter.leArquivo();
            inter.executa();
         }
         else
            inter.listaArquivo();
      }
   }