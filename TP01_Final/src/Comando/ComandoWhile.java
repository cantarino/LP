package Comando;

import Variavel.*;
import Expressao.*;

public class ComandoWhile extends Comando {

    int linhaEnd, linha;
    Expressao exp;

    public ComandoWhile(int lin, Expressao raizArvoreExpressao) {
        linha = lin;
        exp = raizArvoreExpressao;

    }

    public void setLinhaEnd(int lin) {
        linhaEnd = lin;

    }

    public int executa(Memoria local, Memoria global) {
        if (exp.avalia(local, global) == 0) {
            return linhaEnd;
        }
        return linha + 1;
    }
}
