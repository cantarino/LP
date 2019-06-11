/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arquivos;

import Pessoa.Administrador;
import Pessoa.Cliente;
import Pessoa.Pessoa;
import Pessoa.Profissional;
import Servicos.Servico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cantarino
 */
public class Arquivos {

    private final String arquivoClientes = "/Users/cantarino/NetBeansProjects/LP/TP02/Arquivos/cliente.txt";
    private final String arquivoAdmins = "/Users/cantarino/NetBeansProjects/LP/TP02/Arquivos/admin.txt";
    private final String arquivoProfissionais = "/Users/cantarino/NetBeansProjects/LP/TP02/Arquivos/prof.txt";
    private final String arquivoLogins = "/Users/cantarino/NetBeansProjects/LP/TP02/Arquivos/usuarios.txt";
    private final String arquivoServicos = "/Users/cantarino/NetBeansProjects/LP/TP02/Arquivos/servicos.txt";
    private final String arquivoPedidos = "/Users/cantarino/NetBeansProjects/LP/TP02/Arquivos/pedidos.txt";

    public void salvarPessoa(String nome, String endereco, String email,
            String telefone, String nomeDeUsuario, String senha, String tipo) {
        String arquivo = null;
        if (tipo.equals("admin")) {
            arquivo = arquivoAdmins;
        }
        if (tipo.equals("cliente")) {
            arquivo = arquivoClientes;
        }
        if (tipo.equals("prof")) {
            arquivo = arquivoProfissionais;
        }
        try {
            File fArquivo = new File(arquivo);
            FileReader fr = new FileReader(fArquivo);
            BufferedReader br = new BufferedReader(fr);
            //chega no final
            String s = br.readLine();
            String s2 = s;
            while (s2 != null) {
                s2 = br.readLine();
                if (s2 != null) {
                    s += "\n" + s2;
                }
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(fArquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.newLine();
            bw.newLine();
            bw.write("Nome: " + nome + "\n");
            bw.write("Endereco: " + endereco + "\n");
            bw.write("email: " + email + "\n");
            bw.write("Telefone: " + telefone + "\n");
            bw.write("Usuario: " + nomeDeUsuario + "\n");
            bw.write("Senha: " + senha + "\n");
            bw.flush();
            fw.close();

            File fArquivoID = new File(arquivoLogins);
            FileReader fr1 = new FileReader(fArquivoID);
            BufferedReader br1 = new BufferedReader(fr1);
            //chega no final

            s = br1.readLine();
            s2 = s;
            while (s2 != null) {
                s2 = br1.readLine();
                if (s2 != null) {
                    s += "\n" + s2;
                }
            }

            FileWriter fw1 = new FileWriter(fArquivoID);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write(s);
            bw1.newLine();
            bw1.newLine();
            bw1.write("Usuario: " + nomeDeUsuario + "\n");
            bw1.write("Senha: " + senha + "\n");
            bw1.write(tipo);
            bw1.flush();
            fw1.close();
        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + arquivoAdmins + " could not be found! " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Pessoa checkUsuario(String nomeDeUsuario, String senha) {
        try {
            File fArquivo = new File(arquivoLogins);
            FileReader fr = new FileReader(fArquivo);
            BufferedReader br = new BufferedReader(fr);
            Pessoa p;
            String s = br.readLine();
            String s2, s3 = null;
            while (s != null) {
                if (s.equals("Usuario: " + nomeDeUsuario)) {
                    s2 = br.readLine();
                    if (s2.equals("Senha: " + senha)) {
                        s3 = br.readLine();
                        if (s3.equals("admin")) {
                            fr.close();
                            br.close();
                            p = new Administrador(s, s2);
                            return p;
                        }
                        if (s3.equals("cliente")) {
                            fr.close();
                            br.close();
                            p = new Cliente(s, s2);
                            return p;
                        }
                        if (s3.equals("prof")) {
                            fr.close();
                            br.close();
                            p = new Profissional(s, s2);
                            return p;
                        }
                    }
                }
                s = br.readLine();
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + arquivoAdmins + " could not be found! " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void cadastrarServico(Servico servico) {
        try {
            File fArquivo = new File(arquivoServicos);
            FileReader fr = new FileReader(fArquivo);
            BufferedReader br = new BufferedReader(fr);

            //chega no final
            String s = br.readLine();
            String s2 = s;
            while (s2 != null) {
                s2 = br.readLine();
                if (s2 != null) {
                    s += "\n" + s2;
                }
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(fArquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.newLine();
            bw.newLine();
            bw.write("Descricao: " + servico.getDescricaoServico() + "\n");
            bw.write("Profissionais: \n");
            bw.flush();
            fw.close();

        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + arquivoServicos + " could not be found! " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Servico> retornaServicos() {
        ArrayList<Servico> servicos = new ArrayList<>();
        try {
            File fArquivo = new File(arquivoServicos);
            FileReader fr = new FileReader(fArquivo);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            Servico ser;
            while (s != null) {
                String s1[] = s.split(": ");
                ser = new Servico(s1[1]);
                s = br.readLine();

                s1 = s.split("Profissionais");
                if (!s1[1].equals(": ")) {
                    ser.addProf(s1[1]);
                }

                servicos.add(ser);

                s = br.readLine();
                s = br.readLine();
            }

        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + arquivoLogins + " could not be found! " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return servicos;
    }

    public void cadastrarServicos(ArrayList<Servico> servicos) {
        try {
            File fArquivo = new File(arquivoServicos);
            FileWriter fw = new FileWriter(fArquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < servicos.size(); i++) {
                bw.write("Descricao: " + servicos.get(i).getDescricaoServico() + "\n");
                bw.write("Profissionais: ");
                for (int j = 0; j < servicos.get(i).getSize(); j++) {
                    bw.write(servicos.get(i).getProf(j) + "-"
                            + servicos.get(i).getPreco(j) + " ");
                }
                bw.newLine();
                bw.newLine();
            }
            bw.flush();
            fw.close();
        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + arquivoServicos + " could not be found! " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvarPedido(String descServico, String prof, String cliente) {
        try {
            File fArquivo = new File(arquivoPedidos);
            FileReader fr = new FileReader(fArquivo);
            BufferedReader br = new BufferedReader(fr);
            //chega no final
            String s = br.readLine();
            String s2 = s;
            while (s2 != null) {
                s2 = br.readLine();
                if (s2 != null) {
                    s += "\n" + s2;
                }
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(fArquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.newLine();
            bw.newLine();
            bw.write("Descricao: " + descServico + "\n");
            bw.write("Profissional: " + prof + "\n");
            bw.write("Cliente: " + cliente + '\n');
            bw.write("Status: Aguardando\n\n");
            
            bw.flush();
            fw.close();
        } catch (FileNotFoundException ex) {//if the file cannot be found an exception will be thrown
            System.out.println("The file " + arquivoPedidos + " could not be found! " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Arquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
