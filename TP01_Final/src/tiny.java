
import java.io.*;
import java.util.*;
import lp.*;

@SuppressWarnings("unused")
public class tiny {

    public static void main(String[] args) {

        Interpretador inter = new Interpretador("/Users/cantarino/NetBeansProjects/TP01_Final/src/Testes/proc6.tiny");
        int i = 1;
        if (i == 1) {
            inter.leArquivo();
            inter.executa();
        }if(i == 2) {
            inter.listaArquivo();
        }
    }
}
