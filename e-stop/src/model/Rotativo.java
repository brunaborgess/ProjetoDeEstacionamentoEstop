package model;

import java.sql.Time;
import java.util.Date;

public class Rotativo
{
    private int idRotativo;
    private String placaVeiculo;
    private Date dataEntrada , dataSaida;
    private Time horaEntrada , horaSaida;
    private Veiculo veiculo;
    private Vaga vaga;

    public Rotativo(int idRotativo , String placaVeiculo , Date dataEntrada , Date dataSaida , Time horaEntrada ,
                    Time horaSaida , Veiculo veiculo , Vaga vaga)
    {
        super();
        this.idRotativo = idRotativo;
        this.placaVeiculo = placaVeiculo;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.veiculo = veiculo;
        this.vaga = vaga;
    }
    
    public int getIdRotativo()
    {
        return idRotativo;
    }

    public void setIdRotativo(int idRotativo)
    {
        this.idRotativo = idRotativo;
    }

    public String getPlacaVeiculo()
    {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo)
    {
        this.placaVeiculo = placaVeiculo;
    }

    public Date getDataEntrada()
    {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada)
    {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida()
    {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida)
    {
        this.dataSaida = dataSaida;
    }

    public Time getHoraEntrada()
    {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada)
    {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSaida()
    {
        return horaSaida;
    }

    public void setHoraSaida(Time horaSaida)
    {
        this.horaSaida = horaSaida;
    }

    public Rotativo()
    {
        super();
    }
    
    public Veiculo getVeiculo()
    {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo)
    {
        this.veiculo = veiculo;
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