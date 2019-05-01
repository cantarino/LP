package Comando;

import Variavel.*;
import java.io.*;
import java.util.Scanner;

public class ComandoRead extends Comando {

    Scanner teclado = new Scanner(System.in);
    char variavel;

    public ComandoRead(int lin, String txt) {
        linha = lin;
        variavel = txt.charAt(0);
    }

    public int executa(Memoria local, Memoria global) {

        try {
            double d = teclado.nextDouble();
            if (local.var[variavel - 97] != -1) {
                local.var[variavel - 97] = d;
            } else {
                global.var[variavel - 97] = d;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
        
        return linha + 1;
    }
}
