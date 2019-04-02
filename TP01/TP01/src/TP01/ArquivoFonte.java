/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

/**
 *
 * @author cantarino
 */
public class ArquivoFonte {

    private String nomedoArquivo;
    private Vector palavras;
    private int contador;

    //Construtor
    public ArquivoFonte(String nome) {
        this.nomedoArquivo = nome;
        contador = 0;
        palavras = new Vector();
    }
    public int getCont(){
        return contador;
    }

    //Le arquivo
    public void LeArquivo() {

        FileReader leitor = null;
        Vector linhas = new Vector();
        try {
            leitor = new FileReader(nomedoArquivo);
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
            System.exit(0);
        }

        BufferedReader bleitor = new BufferedReader(leitor);
        String s = "";
        int i = 0;
        while (s != null) {
            try {
                s = bleitor.readLine();
            } catch (IOException ex) {
                System.out.println("IOException" + ex);
            }
            linhas.addElement(s);
            i++;
        }
        linhas.remove(i - 1);
        linhas.addElement("EOF");
        processaArquivo(linhas);

    }

    //Separa palavras
    private void processaArquivo(Vector linhas) {
        String s = "";
        for (int i = 0; i < linhas.size(); i++) {
            s = (String) linhas.elementAt(i);
            if (s.contains("writeln")) {
                palavras.addElement("writeln");
            } else if (s.contains("endp")) {
                palavras.addElement("endp");
            } else if (s.contains("writeStr")) {
                palavras.addElement("writeStr");
                pegaRestoWriteStr(s);
            } else if (s.contains("read")) {
                palavras.addElement("read");
                pegaRestoRead(s);
            } else if (s.contains("writeVar")) {
                palavras.addElement("writeVar");
                pegaRestoRead(s);
            } else if (s.contains("EOF")) {
                palavras.addElement("EOF");
            } else if (s.contains("endif")) {
                palavras.addElement("endif");
            } else if (s.contains("if")) {
                palavras.addElement("if");
                pegaRestoIf(s);
            } else if (s.contains("else")) {
                palavras.addElement("else");
            } else if (s.contains(":=")) {
                pegaRestoAtrib(s);
            }
        }

    }

    public String proximaPalavra() {
        contador++;
        return (String) palavras.elementAt(contador - 1);
    }

    public void imprime() {
        for (int i = 0; i < palavras.size(); i++) {
            System.out.println(palavras.elementAt(i));
        }
    }

    public void zeraCont() {
        this.contador = 0;
    }

    //Processar o resto
    private void pegaRestoWriteStr(String s) {
        String r[] = s.split("\"");
        palavras.addElement(r[1]);
    }

    private void pegaRestoRead(String s) {
        String r[] = s.split("\\(");
        palavras.addElement(String.valueOf(r[1].charAt(0)));
    }

    private void pegaRestoIf(String s) {
        String r[] = s.split("if");
        pegaResto(r[1]);

    }

    private void pegaResto(String s) {
        int j;
        for (int i = 0; i < s.length(); i++) {
            if (isATokenSimples(s, i)) {
                palavras.addElement(String.valueOf(s.charAt(i)));
            }
            if ((s.length() - i) > 2) {
                i = isATokenComparativo(s, i);
            }
            if ((s.length() - i) >= 4) {
                j = isATokenPalavra(s, i);
                if (j == i + 4) {
                    return;
                } else {
                    i = j;
                }
            }
        }

    }

    private boolean isATokenSimples(String s, int i) {
        char c = s.charAt(i);
        if(c == ';')
            return true;
        char c2 = s.charAt(i + 1);
        return c == '(' || c == ')'
                || ((c >= 'a' && c <= 'z') && (c2 <= 'a' || c2 >= 'z')) //nao e uma palavra
                || c == '*' || c == '/' || c == '+' || c == '-' || c == '='
                || (c >= '0' && c <= '9');
    }

    private int isATokenComparativo(String s, int i) {
        char c = s.charAt(i);
        char c2 = s.charAt(i + 1);
        if (c == '>') {
            if (c2 == '=') {
                palavras.addElement(">=");
                return i + 1;
            }
            palavras.addElement(">");
            return i;
        }
        if (c == '<') {
            if (c2 == '=') {
                palavras.addElement("<=");
                return i + 1;
            }
            if (c2 == '>') {
                palavras.addElement("<>");
                return i + 1;
            }
            palavras.addElement("<");
            return i;
        }
        return i;
    }

    private int isATokenPalavra(String s, int i) {
        //and or not sqrt then
        char c1 = s.charAt(i);
        char c2 = s.charAt(i + 1);
        char c3 = s.charAt(i + 2);
        char c4 = s.charAt(i + 3);
        if (c1 == 'a' && c2 == 'n' && c3 == 'd') {
            palavras.addElement("and");
            return i + 2;
        }
        if (c1 == 'o' && c2 == 'r') {
            palavras.addElement("or");
            return i + 1;
        }
        if (c1 == 'n' && c2 == 'o' && c3 == 't') {
            palavras.addElement("not");
            return i + 2;
        }
        if (c1 == 's' && c2 == 'q' && c3 == 'r' && c4 == 't') {
            palavras.addElement("sqrt");
            return i + 3;
        }
        if (c1 == 't' && c2 == 'h' && c3 == 'e' && c4 == 'n'){ 
            palavras.addElement("then");
            return i + 4;
        }
        return i;
    }

    private void pegaRestoAtrib(String s) {
        String r[] = s.split(":=");
        String a = r[0];
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z') {
                palavras.addElement(String.valueOf(a.charAt(i)));
            }
        }
        pegaResto(r[1]);
    }

}
