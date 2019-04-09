package TP01.Comando;

public class ComandoEndw extends Comando {

    int linhaW;

    public ComandoEndw(int lin, int linW) {
        linhaW = linW;
    }

    public int executa() {
        return linhaW;
    }
}
