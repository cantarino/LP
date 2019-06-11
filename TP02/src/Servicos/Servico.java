/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Pessoa.Profissional;
import java.util.ArrayList;

/**
 *
 * @author cantarino
 */
public class Servico {
    public final boolean INATIVO = true;
    public final boolean ATIVO = false;
    
    private boolean statusServico;
    private String descricaoServico;
    
    private ArrayList <Profissional> profissionais;
    private ArrayList <Integer> precos;

    public boolean isServicoAtivo() {
        return statusServico;
    }

    public void setStatusServico(boolean statusServico) {
        this.statusServico = statusServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }
    
    public Servico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
        this.statusServico = INATIVO;
        profissionais = new ArrayList();
        precos = new ArrayList();
    }
    
    public void addProf(String profs){
        profs = profs.substring(1);
        String s[] = profs.split(" ");
        for(int i=0; i<s.length; i++){
            if(!s[i].equals("")){
                String s2[] = s[i].split("-");
                profissionais.add(new Profissional(s2[0]));
                precos.add(Integer.valueOf(s2[1]));
            }
        }
    }
    
    public void setProf(String prof, int preco){
        profissionais.add(new Profissional(prof));
        precos.add(preco);
    }
    
    public int getSize(){
        return precos.size();
    }
    
    public String getProf(int i){
        return profissionais.get(i).getNomeDeUsuario();
    }
    
    public int getPreco(int i){
        return precos.get(i);
    }
    
    public ArrayList<String> getPrecos(){
        ArrayList<String> preco = new ArrayList();
        for(int i=0; i<precos.size();i++){
            preco.add(getProf(i) + " - " + getPreco(i));
        }
        return preco;
    }
}
