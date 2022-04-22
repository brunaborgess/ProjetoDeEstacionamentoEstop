package model;

import java.sql.Date;
import java.sql.Time;

public class Fatura
{
    private int idFatura;
    private Date dataEmissao;
    private Time horaEmissao;
    private String formaPagamento;
    private double valorFatura;
    private Assinatura assinatura;
    private Rotativo rotativo;
    
    public Fatura()
    {
        super();
    }
    
    public Fatura(int idFatura , Date dataEmissao , Time horaEmissao , String formaPagamento , double valorFatura ,
                    Assinatura assinatura , Rotativo rotativo)
    {
        super();
        this.idFatura = idFatura;
        this.dataEmissao = dataEmissao;
        this.horaEmissao = horaEmissao;
        this.formaPagamento = formaPagamento;
        this.valorFatura = valorFatura;
        this.assinatura = assinatura;
        this.rotativo = rotativo;
    }

    public int getIdFatura()
    {
        return idFatura;
    }

    public void setIdFatura(int idFatura)
    {
        this.idFatura = idFatura;
    }

    public Date getDataEmissao()
    {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao)
    {
        this.dataEmissao = dataEmissao;
    }

    public Time getHoraEmissao()
    {
        return horaEmissao;
    }

    public void setHoraEmissao(Time horaEmissao)
    {
        this.horaEmissao = horaEmissao;
    }

    public String getFormaPagamento()
    {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento)
    {
        this.formaPagamento = formaPagamento;
    }

    public double getValorFatura()
    {
        return valorFatura;
    }

    public void setValorFatura(double valorFatura)
    {
        this.valorFatura = valorFatura;
    }
    
    public Assinatura getAssinatura()
    {
        return assinatura;
    }

    public void setAssinatura(Assinatura assinatura)
    {
        this.assinatura = assinatura;
    }

    public Rotativo getRotativo()
    {
        return rotativo;
    }

    public void setRotativo(Rotativo rotativo)
    {
        this.rotativo = rotativo;
    }
}