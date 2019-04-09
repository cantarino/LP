package TP01.Comando;

import TP01.Variavel.*;
import TP01.Expressao.*;

public class ComandoFor extends Comando {

    int linhaEnd,linha,varValor;
    double limite;
    char variavel;
    String tipo;
    Expressao exp;
    boolean inicio = true;

    public ComandoFor(int lin, String var, String vValor, String tipo, Expressao raizArvoreExpressao) {
        linha = lin;
        variavel = var.charAt(0);
        limite = Double.parseDouble(vValor);
        this.tipo = tipo;
        exp = raizArvoreExpressao;
        varValor = (int) Variaveis.var[variavel-97];
    }

    public char getVar() {
        return variavel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setLinhaEnd(int lin) {
        linhaEnd = lin;
    }

    public int executa() {
        if(exp.avalia()==0)
            return linhaEnd;
        return linha+1;
    }
}
