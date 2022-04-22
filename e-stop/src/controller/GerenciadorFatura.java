package controller;

import model.Assinatura;
import model.Fatura;
import model.Rotativo;
import model.DAO.FaturaDAO;
import model.DAO.OperacaoCaixaDAO;

public class GerenciadorFatura
{
    public static void registrarFaturaRotativo(String formaPagamento , double valor , Rotativo rotativo)
    {
        Fatura fatura = FaturaDAO.inserirFaturaRotativo(formaPagamento , valor , rotativo);
        
        OperacaoCaixaDAO.inserir("Rotativo" , valor , OperacaoCaixaDAO.buscarUltimoRegistro().getValorCaixa()  + valor ,
                                 fatura , Acesso.getFuncionario());
    }
    
    public static void registrarFaturaAssinatura(String formaPagamento , double valor , Assinatura assinatura)
    {
        Fatura fatura = FaturaDAO.inserirFaturaAssinatura(formaPagamento , valor , assinatura);
        
        OperacaoCaixaDAO.inserir("Assinatura" , valor , OperacaoCaixaDAO.buscarUltimoRegistro().getValorCaixa()  + valor ,
                                 fatura , Acesso.getFuncionario());
    }
}