package controller;

import model.DAO.PessoaFisicaDAO;
import model.DAO.PessoaJuridicaDAO;
import view.TelaAvisoGenerica;

public class ValidadorCpfECnpj
{
    private final static int CPF = 0;
    private final static int CNPJ = 1;
    
    public static boolean validar(String codigo , int opcao)
    {
        switch (opcao)
        {
            case CPF:
                if (checarSeCpfEUnico(codigo))
                    return true;
                new TelaAvisoGenerica("Já existe um cadastro com este CPF.");
                return false;
                
            case CNPJ:
                if (checarSeCnpjEUnico(codigo))
                    return true;
                new TelaAvisoGenerica("Já existe um cadastro com este CNPJ.");
                return false;
                
            default:
                break;
        }
        return false;
    }
    
    private static boolean checarSeCpfEUnico(String codigo)
    {
        return PessoaFisicaDAO.buscarPorCpf(codigo) == null;          
    }
    
    private static boolean checarSeCnpjEUnico(String codigo)
    {
        return PessoaJuridicaDAO.buscarPorCnpj(codigo) == null; 
    }
}