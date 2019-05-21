/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Arquivos.Arquivos;
import Pessoa.Pessoa;
import Pessoa.Cliente;
import Pessoa.Administrador;
import Pessoa.Profissional;
import Servicos.Servico;
import Servicos.ServicoTroca;
import java.util.ArrayList;

/**
 *
 * @author cantarino
 */
public class Sistema {

    private ArrayList<Servico> servicos;
    private Pessoa usuario;
    private final Arquivos arquivos;

    public Sistema() {
        servicos = new ArrayList<Servico>();
        arquivos = new Arquivos();
        //cadastrar servicos a partir de arquivo
    }

    public boolean logar(String usuario, String senha) {
        this.usuario = arquivos.checkUsuario(usuario, senha);
        return (this.usuario != null);
    }

    public boolean isAdmin() {
        return (usuario instanceof Administrador);
    }

    public boolean isCliente() {
        return (usuario instanceof Cliente);
    }

    public boolean isProf() {
        return (usuario instanceof Profissional);
    }

    public void cadastrarAdministrador(String nome, String endereco, String email, String telefone, String nomeDeUsuario, String senha) {
        if (usuario instanceof Administrador) {
            arquivos.salvarPessoa(nome, endereco, email, telefone, nomeDeUsuario, senha, "admin");
        }            //colocar no arquivo novo Admin
    }

    public void cadastrarCliente(String nome, String endereco, String email, String telefone, String nomeDeUsuario, String senha) {
        arquivos.salvarPessoa(nome, endereco, email, telefone, nomeDeUsuario, senha, "cliente");
    }

    public void cadastrarProfissional(String nome, String endereco, String email, String telefone, String nomeDeUsuario, String senha) {
        arquivos.salvarPessoa(nome, endereco, email, telefone, nomeDeUsuario, senha, "prof");
    }

    public void cadastrarServico(String descricaoServico) {
        servicos.add(new Servico(descricaoServico));
        arquivos.cadastrarServico(new Servico(descricaoServico));
    }
    
    public void cadastrarServicos(){
        arquivos.cadastrarServicos(servicos);
    }

    public void apagarServico(String descricaoServico) {
        if (usuario instanceof Administrador) {
            for (int i = 0; i < servicos.size(); i++) {
                if (servicos.get(i).getDescricaoServico().equals(descricaoServico)) {
                    if (!servicos.get(i).isServicoAtivo()) {
                        servicos.remove(i);
                    }
                }
            }
            //salvar arquivo
        }
    }

    public void alterarServico(String descricaoServico, String nomeServico) {
        if (usuario instanceof Administrador) {
            for (int i = 0; i < servicos.size(); i++) {
                if (servicos.get(i).getDescricaoServico().equals(descricaoServico)) {
                    if (!servicos.get(i).isServicoAtivo()) {
                        servicos.get(i).setDescricaoServico(descricaoServico);
                    }
                }
            }
            //salvar arquivo
        }
    }

}
