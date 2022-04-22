package model;

import java.sql.Date;

public class Assinatura
{
    private int idAssinatura;
    private double valorAssinatura;
    private boolean paga;
    private Date dataDaAssinatura , vencimento;
    private Cliente cliente;
    private Plano plano;
    private Vaga vaga;
    
    public Assinatura()
    {
        super();
    }

    public Assinatura(int idAssinatura , Date dataDaAssinatura , double valorAssinatura , Date vencimento , boolean paga ,
                      Cliente cliente , Plano plano , Vaga vaga)
    {
        super();
        this.idAssinatura = idAssinatura;
        this.dataDaAssinatura = dataDaAssinatura;
        this.valorAssinatura = valorAssinatura;
        this.vencimento = vencimento;
        this.paga = paga;
        this.cliente = cliente;
        this.plano = plano;
        this.vaga = vaga;
    }

    public int getIdAssinatura()
    {
        return idAssinatura;
    }

    public void setIdAssinatura(int idAssinatura)
    {
        this.idAssinatura = idAssinatura;
    }

    public boolean isPaga()
    {
        return paga;
    }

    public void setPaga(boolean paga)
    {
        this.paga = paga;
    }

    public Date getDataDaAssinatura()
    {
        return dataDaAssinatura;
    }

    public void setDataDaAssinatura(Date dataDaAssinatura)
    {
        this.dataDaAssinatura = dataDaAssinatura;
    }

    public double getValorAssinatura()
    {
        return valorAssinatura;
    }

    public void setValorAssinatura(double valorAssinatura)
    {
        this.valorAssinatura = valorAssinatura;
    }

    public Date getVencimento()
    {
        return vencimento;
    }

    public void setVencimento(Date vencimento)
    {
        this.vencimento = vencimento;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Plano getPlano()
    {
        return plano;
    }

    public void setPlano(Plano plano)
    {
        this.plano = plano;
    }

    public Vaga getVaga()
    {
        return vaga;
    }

    public void setVaga(Vaga vaga)
    {
        this.vaga = vaga;
    }
}