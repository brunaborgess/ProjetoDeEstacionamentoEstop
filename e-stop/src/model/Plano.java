package model;

public class Plano
{
    private int idPlano;

    private double valor;

    private String descricao;

    public Plano()
    {
        super();
    }

    public Plano(int idPlano , String descricao , double valor)
    {
        super();
        this.idPlano = idPlano;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getIdPlano()
    {
        return idPlano;
    }

    public void setIdPlano(int idPlano)
    {
        this.idPlano = idPlano;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }
}