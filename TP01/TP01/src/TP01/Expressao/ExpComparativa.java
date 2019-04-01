package TP01.Expressao;

import TP01.Variavel.*;

public class ExpComparativa extends Expressao{
   
    String op;
    Object exp1, exp2;
    Expressao opr1, opr2;
    static final double TRUE = 1;
    static final double FALSE = 0;
		
       public ExpComparativa(String op, Object exp1, Object exp2) {
         this.op= op;
         this.exp1= exp1;
         this.exp2= exp2;
      }
   
    public double avalia() {

        boolean v = false;
        double valor = FALSE;

        opr1 = (Expressao) exp1;
        opr2 = (Expressao) exp2;

        //insira seu codigo aqui
        if(op.equals(">"))
            v = opr1.avalia() > opr2.avalia();
        if(op.equals("<"))
            v = opr1.avalia() < opr2.avalia();
        if(op.equals(">="))
            v = opr1.avalia() >= opr2.avalia();
        if(op.equals("<="))
            v = opr1.avalia() <= opr2.avalia();
        if(op.equals("="))
            v = opr1.avalia() == opr2.avalia();
        if(op.equals("<>"))
            v = opr1.avalia() != opr2.avalia();
        if (v == true) 
            valor = TRUE;
        else
            valor = FALSE;

        return valor;
      
      }
   }	
