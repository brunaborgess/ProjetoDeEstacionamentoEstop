package model;

import java.util.Date;

import controller.Acesso;
import model.DAO.OperacaoCaixaDAO;
import view.TelaAvisoGenerica;

public class OperacaoCaixa
{
    private int idOperacaoCaixa;
    private Date dataOperacao;
    private String tipoOperacao;
    private double valorOperacao , valorCaixa;
    private Fatura fatura;
    private Funcionario funcionario;
    
    public OperacaoCaixa()
    {
        super();
    }
    
    public OperacaoCaixa(int idOperacaoCaixa , Date dataOperacao , String tipoOperacao , double valorOperacao ,
                    double valorCaixa , Fatura fatura , Funcionario funcionario)
    {
        super();
        this.idOperacaoCaixa = idOperacaoCaixa;
        this.dataOperacao = dataOperacao;
        this.tipoOperacao = tipoOperacao;
        this.valorOperacao = valorOperacao;
        this.valorCaixa = valorCaixa;
        this.fatura = fatura;
        this.funcionario = funcionario;
    }

    public int getIdOperacaoCaixa()
    {
        return idOperacaoCaixa;
    }

    public void setIdOperacaoCaixa(int idOperacaoCaixa)
    {
        this.idOperacaoCaixa = idOperacaoCaixa;
    }

    public Date getDataOperacao()
    {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao)
    {
        this.dataOperacao = dataOperacao;
    }

    public String getTipoOperacao()
    {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao)
    {
        this.tipoOperacao = tipoOperacao;
    }
    
    public double getValorOperacao()
    {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao)
    {
        this.valorOperacao = valorOperacao;
    }

    public double getValorCaixa()
    {
        return valorCaixa;
    }

    public void setValorCaixa(double valorCaixa)
    {
        this.valorCaixa = valorCaixa;
    }

    public Fatura getFatura()
    {
        return fatura;
    }

    public void setFatura(Fatura fatura)
    {
        this.fatura = fatura;
    }

    public Funcionario getFuncionario()
    {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario)
    {
        this.funcionario = funcionario;
    }
    
    public static void abrirCaixa()
    {
        // Digitar o valor com o qual deseja abrir o caixa
    }

    public static void fecharCaixa()
    {
        // TODO Corrigir nome da variavel em OperacaoCaixa
        double valorEmCaixa = OperacaoCaixaDAO.buscarUltimoRegistro().getValorCaixa();
        
        if (! caixaEstaFechado())
            OperacaoCaixaDAO.inserir("Fechamento de Caixa" , - (valorEmCaixa) , 0 , null , Acesso.getFuncionario());
        else
            new TelaAvisoGenerica("Caixa já está fechado!");
    }
    
    public static boolean caixaEstaFechado()
    {
        try
        {
        if (OperacaoCaixaDAO.buscarUltimoRegistro().getTipoOperacao().equals("Fechamento de Caixa"))
            return true;
        return false;
        }
        catch (Exception e)
        {
            return true;
        }
    }
}