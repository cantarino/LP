package TP01.Comando;
	
import TP01.Variavel.*;
import TP01.Expressao.*;
	 
public class ComandoAtrib extends Comando {
   
   char variavel;
   Expressao exp;
   	
   public ComandoAtrib(int lin, char var, Expressao raizArvoreExpressao) {
         variavel = var;
         exp = raizArvoreExpressao;
         linha = lin;
                 
   }
   
   public int executa() {
       Variaveis.var[variavel-97] = exp.avalia();
       return linha+1;
   }
}

