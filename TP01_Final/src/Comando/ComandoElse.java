package Comando;
	
import Variavel.*;
	 
public class ComandoElse extends Comando implements Condicao {
   
   int linhaEnd;
 
   public ComandoElse(int lin) {
       linhaEnd = lin;
   }
   
   public void setLinhaEnd(int lin){
       linhaEnd = lin;
   }
	
   public int executa( Memoria local, Memoria global) {	
       return linhaEnd;
   }
}

