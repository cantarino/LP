package TP01.Comando;
	
import TP01.Variavel.*;
import TP01.Expressao.*;
	 
public class ComandoIf extends Comando implements Condicao{
   
   int linhaEnd;
   int linha;
   Expressao exp;
 
   public ComandoIf(int lin, Expressao raizArvoreExpressao) {
       linha = lin;
       exp = raizArvoreExpressao;
   }
   
   public void setLinhaEnd(int lin){
       linhaEnd = lin;
   }
	
    public int executa() {
        if (exp.avalia() == 1) {
            return linha+1;
        } else {
            return linhaEnd;
        }
    }
}

