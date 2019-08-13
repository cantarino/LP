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

    public int getNumServicos() {
        return servicos.size();
    }

    public String getServicoAt(int i) {
        return servicos.get(i).getDescricaoServico();
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

    public void atualizaServicos() {
        servicos = arquivos.retornaServicos();
    }

    public void cadastrarServicos() {
        arquivos.cadastrarServicos(servicos);
    }

    public void apagarServico(int i) {
        if (usuario instanceof Administrador) {
                servicos.remove(i);
                //salvar arquivo
                arquivos.cadastrarServicos(servicos);
                atualizaServicos();
        }
    }

    public void alterarServico(int i, String nomeServico) {
        if (usuario instanceof Administrador) {
            if (!servicos.get(i).isServicoAtivo()) {
                servicos.get(i).setDescricaoServico(nomeServico);
                //salvar arquivo
                arquivos.cadastrarServicos(servicos);
                atualizaServicos();
            }
        }
    }
    
    public void cadastraPreco(int index,int preco){
        servicos.get(index).setProf(usuario.getNomeDeUsuario().substring(9), preco);
        arquivos.cadastrarServicos(servicos);
        atualizaServicos();
    }
    
    public ArrayList<String> getPrecos(int index){
        return servicos.get(index).getPrecos();
    }
    
    public void salvaPedido(String descServico, String prof){
        arquivos.salvarPedido(descServico, prof, usuario.getNomeDeUsuario().substring(9));
    }
    
    public ArrayList<String> getPedidosProf(){
        return arquivos.getPedidosProf(usuario.getNomeDeUsuario().substring(9));
    }
    
    public void negaPedido(String pedido){
        arquivos.negarPedido(usuario.getNomeDeUsuario().substring(9), pedido);
    }
    
    public void executarPedido(String pedido){
        arquivos.executarPedido(usuario.getNomeDeUsuario().substring(9), pedido);   
    }
}
