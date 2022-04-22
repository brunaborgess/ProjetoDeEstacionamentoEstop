package controller;

import model.Funcionario;
import model.DAO.FuncionarioDAO;
import view.TelaAvisoGenerica;

public class GerenciadorFuncionario
{
    public static void cadastrarFuncionario(String nomeFuncionario , String nomeUsuario , String senha , String nivelPermissao)
    {
        Funcionario funcionario = null;
        
        switch (nivelPermissao)
        {
            case "Gerente":
                funcionario = FuncionarioDAO.inserir(nomeFuncionario , nomeUsuario , senha , 0);
                break;
            case "Funcionário":
                funcionario = FuncionarioDAO.inserir(nomeFuncionario , nomeUsuario , senha , 1);
                break;
                
            default:
                break;
        }
        
        if (funcionario != null)
            new TelaAvisoGenerica("Cadastro efetuado com sucesso!");
        else
            new TelaAvisoGenerica("Falha ao cadastrar.");
    }
}