package TP01.Expressao;

import TP01.Variavel.*;

public class ExpBinaria extends Expressao{
   
      String op;
      Object exp1, exp2;
      Expressao cmd1, cmd2;
   	
       public ExpBinaria(String op, Object exp1, Object exp2) {
         this.op= op;
         this.exp1= exp1;
         this.exp2= exp2;
      }
   
   
       public double avalia() {
           
           cmd1 = (Expressao) exp1;
           cmd2 = (Expressao) exp2;
       //insira seu c�digo aqui 
       if(op.equals("+"))
           return cmd2.avalia() + cmd1.avalia();
       if(op.equals("-")){
           return cmd2.avalia() - cmd1.avalia();
       }
       if(op.equals("*"))
           return cmd2.avalia() * cmd1.avalia();
       if(op.equals("/")){
           if(cmd1.avalia() == 0){
               System.out.println("Divisao por zero");
               System.exit(0);
           }
           return cmd2.avalia() / cmd1.avalia();
       }
       System.out.println("erro");
       System.exit(0);
       return 0;
      }
       
   }	
