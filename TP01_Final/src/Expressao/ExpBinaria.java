package Expressao;

import Variavel.*;

public class ExpBinaria extends Expressao {

    String op;
    Object exp1, exp2;
    Expressao cmd1, cmd2;

    public ExpBinaria(String op, Object exp1, Object exp2) {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public double avalia(Memoria local, Memoria global) {

        cmd1 = (Expressao) exp1;
        cmd2 = (Expressao) exp2;
        if (op.equals("+")) {
            return cmd2.avalia(local, global) + cmd1.avalia(local, global);
        }
        if (op.equals("-")) {
            return cmd2.avalia(local, global) - cmd1.avalia(local, global);
        }
        if (op.equals("*")) {
            return cmd2.avalia(local, global) * cmd1.avalia(local, global);
        }
        if (op.equals("/")) {
            if (cmd1.avalia(local, global) == 0) {
                System.out.println("Divisao por zero");
                System.exit(0);
            }
            return cmd2.avalia(local, global) / cmd1.avalia(local, global);
        }
        System.out.println("erro");
        System.exit(0);
        return 0;
    }

}
