/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

/**
 *
 * @author cantarino
 */
public class Servico {
    public final boolean INATIVO = true;
    public final boolean ATIVO = false;
    
    private boolean statusServico;
    private String descricaoServico;
    private double valorServico;

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

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

    public Servico(String descricaoServico,double valorServico) {
        this.descricaoServico = descricaoServico;
        this.statusServico = INATIVO;
        this.valorServico = valorServico;
    }
    
    public Servico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
        this.statusServico = INATIVO;
    }
    
    
}
