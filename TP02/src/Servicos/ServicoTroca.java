/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import java.util.ArrayList;

/**
 *
 * @author cantarino
 */
public class ServicoTroca extends Servico {
    private ArrayList <String> listaPecas;

    public ArrayList<String> getListaPecas() {
        return listaPecas;
    }

    public void setListaPecas(ArrayList<String> listaPecas) {
        this.listaPecas = listaPecas;
    }
    
    public void addPeca(String peca){
        listaPecas.add(peca);
    }

    public ServicoTroca(ArrayList<String> listaPecas, String descricaoServico) {
        super(descricaoServico);
        this.listaPecas = listaPecas;
    }
    
}
