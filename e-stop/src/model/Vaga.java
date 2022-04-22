package model;

public class Vaga
{
    private int idVaga;
    private boolean disponivel , coberta;
    private String tipoDeVeiculo;
    
    public Vaga()
    {
        super();
    }

    public Vaga(int idVaga , boolean disponivel , boolean coberta , String tipoDeVeiculo)
    {
        super();
        this.idVaga = idVaga;
        this.disponivel = disponivel;
        this.coberta = coberta;
        this.tipoDeVeiculo = tipoDeVeiculo;
    }

    public int getIdVaga()
    {
        return idVaga;
    }

    public void setIdVaga(int idVaga)
    {
        this.idVaga = idVaga;
    }

    public boolean isDisponivel()
    {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel)
    {
        this.disponivel = disponivel;
    }

    public boolean isCoberta()
    {
        return coberta;
    }

    public void setCoberta(boolean coberta)
    {
        this.coberta = coberta;
    }

    public String getTipoDeVeiculo()
    {
        return tipoDeVeiculo;
    }

    public void setTipoDeVeiculo(String tipoDeVeiculo)
    {
        this.tipoDeVeiculo = tipoDeVeiculo;
    }
}