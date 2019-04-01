package TP01.Expressao;

import TP01.Variavel.*;

public class ExpLogica extends Expressao {

    String op;
    Object exp1, exp2;
    Expressao opr1, opr2;
    static final double TRUE = 1;
    static final double FALSE = 0;

    public ExpLogica(String op, Object exp1, Object exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public double avalia() {

        boolean v = false,
                opr1B = false,
                opr2B = false;
        double valor = FALSE;

        opr1 = (Expressao) exp1;
        opr2 = (Expressao) exp2;

        //insira seu c�digo aqui
        if (op.equals("or")) {
            v = (opr1.avalia() + opr2.avalia()) >= 1;
        }
        if (op.equals("and")) {
            v = (opr1.avalia() + opr2.avalia()) == 2;
        }
        if (op.equals("not")) {
            v = (opr2.avalia()) == 0;
        }
        if (v == true) {
            valor = TRUE;
        } else {
            valor = FALSE;
        }

        return valor;

    }
}
