package Proc;

import Variavel.*;
import Comando.*;
import java.util.*;

public class Procedimento {

    String nome;     										// nome do procedimento  
    Vector comandos;    									// vetor de comandos 
    String[] parametros;									// parametros formais 
    String[] variaveisLocal;								// vari�veis local
    static Memoria global = new Memoria();			// variaveis globais

    public Procedimento(String n, String[] p) {
        nome = n;
        parametros = p;
    }

    public String getNome() {
        return nome;
    }

    public static void setVariaveisGlobal(String[] vG) {
        char var;
        for (int i = 0; vG[i] != null; i++) {
            global.var[vG[i].charAt(0) - 97] = 0; //Se !-1, varaivel valida
        }
    }

    public void setVariaveisLocal(String[] vL) {
        variaveisLocal = vL;
    }

    public void setListaComandos(Vector c) {
        comandos = c;

    }

    public void executa(double[] argumentos) {
        Memoria local = new Memoria(); 				// variaveis local
        char var;

        // adiciona vari�veis locais na mem�ria local
        if (variaveisLocal != null) {
            for (int i = 0; variaveisLocal[i] != null; i++) {
                local.var[variaveisLocal[i].charAt(0) - 97] = 0; // Se !-1, variavel valida								
            }
        }
        // associa argumentos a seus respectivos par�metros formais

        for (int i = 0; parametros[i] != null; i++) {
            local.var[parametros[i].charAt(0) - 97] = argumentos[i];
        }

        int pc = 0;
        do {
            //System.out.println("pc " + pc);
            pc = ((Comando) comandos.elementAt(pc)).executa(local, global);

        } while (pc < comandos.size());
    }
}
