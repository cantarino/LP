package Comando;
	
import Variavel.*;
import Expressao.*;
	 
public class ComandoAtrib extends Comando {
   
   char variavel;
   Expressao exp;
   	
   public ComandoAtrib(int lin, char var, Expressao raizArvoreExpressao) {
         variavel = var;
         exp = raizArvoreExpressao;
         linha = lin;
       
   }
   
   public int executa( Memoria local, Memoria global) {
       if(local.var[variavel-97] != -1)
           local.var[variavel - 97] = exp.avalia(local, global);
       else
           global.var[variavel - 97] = exp.avalia(local, global);
       return linha+1;
   	 	
   }
}

