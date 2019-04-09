package TP01.Comando;

import TP01.Variavel.*;
import TP01.Expressao.*;

public class ComandoWhile extends Comando {

    int linhaEnd;
    int linha;
    Expressao exp;

    public ComandoWhile(int lin, Expressao raizArvoreExpressao) {
        linha = lin;
        exp = raizArvoreExpressao;
    }

    public void setLinhaEnd(int lin) {
            linhaEnd = lin;

    }

    public int executa() {
        if(exp.avalia() == 0)
            return linhaEnd;
        return linha+1;
    }
}
