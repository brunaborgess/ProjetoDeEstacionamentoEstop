package controller;

import javax.swing.JPanel;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.DAO.ClienteDAO;
import model.DAO.PessoaFisicaDAO;
import model.DAO.PessoaJuridicaDAO;
import view.HomeClientes;
import view.PainelAssinaturas;
import view.TelaAvisoGenerica;

public class GerenciadorClientes
{
    public static void cadastrarPf(String[] campos , JPanel painelPai , JPanel painelCadastro)
    {
        PessoaFisica pessoaFisica = new PessoaFisica();
        
        pessoaFisica.setCpf(campos[0]);
        pessoaFisica.setNome(campos[1]);
        pessoaFisica.setTelefone1(campos[2]);
        pessoaFisica.setTelefone2(campos[3]);
        pessoaFisica.setEmail(campos[4]);
        pessoaFisica.setLogradouro(campos[5]);
        pessoaFisica.setBairro(campos[6]);
        pessoaFisica.setCidade(campos[7]);
        pessoaFisica.setUf(campos[8]);
        pessoaFisica.setCep(campos[9]);
        pessoaFisica.setNumero(Integer.parseInt(campos[10]));
        pessoaFisica.setComplemento(campos[11]);
        
        Cliente clienteInserido = ClienteDAO.inserir(pessoaFisica.getLogradouro() , pessoaFisica.getNumero() , pessoaFisica.getComplemento() , pessoaFisica.getBairro() ,
                                                     pessoaFisica.getCidade() , pessoaFisica.getUf() , pessoaFisica.getCep() , pessoaFisica.getTelefone1() ,
                                                     pessoaFisica.getTelefone2() , pessoaFisica.getEmail());
        
        if (clienteInserido != null)
        {
            pessoaFisica.setIdCliente(clienteInserido.getIdCliente());
            
            PessoaFisica pessoaFisicaInserida = PessoaFisicaDAO.inserir(pessoaFisica.getCpf() , pessoaFisica.getNome() ,
                                                                        pessoaFisica.getIdCliente());
            
            if (pessoaFisicaInserida != null)
            {
                new TelaAvisoGenerica("Cadastro concluído com sucesso!");
                painelCadastro.setVisible(false);
                painelPai.add(new PainelAssinaturas(painelPai , null , clienteInserido));
            }
            else
            {
                new TelaAvisoGenerica("Cadastro mal sucedido.");
                painelCadastro.setVisible(false);
                painelPai.add(new HomeClientes(painelPai));
            }
        }
        else
        {
            new TelaAvisoGenerica("Cadastro mal sucedido.");
            painelCadastro.setVisible(false);
            painelPai.add(new HomeClientes(painelPai));
        }
    }
    
    public static void cadastrarPj(String[] campos , JPanel painelPai , JPanel painelCadastro)
    {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        
        pessoaJuridica.setCnpj(campos[0]);
        pessoaJuridica.setRazaoSocial(campos[1]);
        pessoaJuridica.setTelefone1(campos[2]);
        pessoaJuridica.setTelefone2(campos[3]);
        pessoaJuridica.setEmail(campos[4]);
        pessoaJuridica.setLogradouro(campos[5]);
        pessoaJuridica.setBairro(campos[6]);
        pessoaJuridica.setCidade(campos[7]);
        pessoaJuridica.setUf(campos[8]);
        pessoaJuridica.setCep(campos[9]);
        pessoaJuridica.setNumero(Integer.parseInt(campos[10]));
        pessoaJuridica.setComplemento(campos[11]);
        
        Cliente clienteInserido = ClienteDAO.inserir(pessoaJuridica.getLogradouro() , pessoaJuridica.getNumero() , pessoaJuridica.getComplemento() , pessoaJuridica.getBairro() ,
                                                     pessoaJuridica.getCidade() , pessoaJuridica.getUf() , pessoaJuridica.getCep() , pessoaJuridica.getTelefone1() ,
                                                     pessoaJuridica.getTelefone2() , pessoaJuridica.getEmail());
        
        if (clienteInserido != null)
        {
            pessoaJuridica.setIdCliente(clienteInserido.getIdCliente());
            
            PessoaJuridica pessoaJuridicaInserida = PessoaJuridicaDAO.inserir(pessoaJuridica.getCnpj() , pessoaJuridica.getRazaoSocial() ,
                                                                        pessoaJuridica.getIdCliente());
            
            if (pessoaJuridicaInserida != null)
            {
                new TelaAvisoGenerica("Cadastro concluído com sucesso!");
                painelPai.add(new PainelAssinaturas(painelPai , null , clienteInserido));
                painelCadastro.setVisible(false);
            }
            else
            {
                new TelaAvisoGenerica("Cadastro mal sucedido.");
                painelPai.add(new HomeClientes(painelPai));
                painelCadastro.setVisible(false);
            }
        }
        else
        {
            new TelaAvisoGenerica("Cadastro mal sucedido.");
            painelPai.add(new HomeClientes(painelPai));
            painelCadastro.setVisible(false);
        }
    }
    
    public static void alterarPessoaFisica(int idCliente , String telefone1 , String telefone2 , String email ,
                                           String logradouro , int numero , String complemento , String bairro ,
                                           String cidade , String uf , String cep ,
                                           String nome , String cpf)
    {   
        if (PessoaFisicaDAO.atualizar(nome , cpf))
        {
            
            if (ClienteDAO.atualizarEndereco(logradouro, numero , complemento , bairro , cidade , uf , cep , idCliente) &&
                ClienteDAO.atualizarTelefone(telefone1 , telefone2 , idCliente) && ClienteDAO.atualizarEmail(email ,idCliente))
                new TelaAvisoGenerica("Atualização de dados concluída com sucesso.");
            else
                new TelaAvisoGenerica("Atualização não efetuada.");
        }
        else
            new TelaAvisoGenerica("Atualização não efetuada.");
    }

    public static void alterarPessoaJuridica(int idCliente , String telefone1 , String telefone2 , String email , String logradouro ,
                    int numero , String complemento , String bairro , String cidade , String uf , String cep ,
                    String razaoSocial , String cnpj)
    {
            if (ClienteDAO.atualizarEndereco(logradouro, numero , complemento , bairro , cidade , uf , cep , idCliente) &&
                ClienteDAO.atualizarTelefone(telefone1 , telefone2 , idCliente) && ClienteDAO.atualizarEmail(email ,idCliente))
                new TelaAvisoGenerica("Atualização de dados concluída com sucesso.");
            else
                new TelaAvisoGenerica("Atualização não efetuada.");
        
    }
}