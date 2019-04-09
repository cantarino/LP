package TP01.Comando;

import TP01.Variavel.*;

public class ComandoEndfor extends Comando {

    int linhaFor;
    char variavel;
    String tipo;

    public ComandoEndfor(int lin, int linFor, char var, String tipo) {
        linhaFor = linFor;
        variavel = var;
        this.tipo = tipo;
    }

    public int executa() {

        if (tipo.equals("to")) {
            Variaveis.var[variavel-97]++;

        } else {
            Variaveis.var[variavel-97]--;
        }

        return linhaFor;
    }
}
