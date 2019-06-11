/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pessoa;

/**
 *
 * @author cantarino
 */
public class Profissional extends Pessoa{
    public Profissional(String nome, String endereco, String email, String telefone, String nomeDeUsuario, String senha) {
        super(nome, endereco, email, telefone, nomeDeUsuario, senha);
    }
    
    public Profissional (String usuario, String senha){
       super(null, null, null, null, usuario, senha); 
    }
    
    public Profissional (String usuario){
        super(null, null, null, null, usuario, null); 
    }
    
}
