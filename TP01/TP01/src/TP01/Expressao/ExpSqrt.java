 package TP01.Expressao;
 
 import TP01.Variavel.*;
 
    public class ExpSqrt extends Expressao{
   
      String sqrt;
   	
       public ExpSqrt(String sqrt) {
         this.sqrt= sqrt;
      }
   
       public double avalia() {
         
         //insira seu c�digo aqui
                  
         return Math.sqrt(Variaveis.var[(int)(sqrt.charAt(0)-97)]);
      }
      
   }