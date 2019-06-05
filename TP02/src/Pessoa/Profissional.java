/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

import Servicos.Servico;
import java.util.ArrayList;

/**
 *
 * @author cantarino
 */
public class Profissional extends Pessoa{
    private ArrayList <Servico> servicosPrestados;
    private ArrayList <Integer> precos;
    public Profissional(String nome, String endereco, String email, String telefone, String nomeDeUsuario, String senha) {
        super(nome, endereco, email, telefone, nomeDeUsuario, senha);
    }
    
    public void addServico(String descricaoServico, int valor){
        servicosPrestados.add(new Servico(descricaoServico));
        precos.add(valor);
    }
    
    public Profissional (String usuario, String senha){
       super(null, null, null, null, usuario, senha); 
    }
    
}
