package TP01.Comando;
	
import TP01.Variavel.*;
	 
public class ComandoElse extends Comando implements Condicao {
   
   int linhaEnd;
 
   public ComandoElse(int lin) {
       linhaEnd=lin;
   }
   
   public void setLinhaEnd(int lin){
       linhaEnd=lin;
   }
	
   public int executa() {
        return linhaEnd+1;
   }
}

