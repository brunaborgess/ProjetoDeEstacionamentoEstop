package model;

public class Preco
{
    private int idPreco;
    private double ateUmaHora , ateDuasHoras , ateTresHoras , aposTresHoras , pernoite;
    
    public Preco()
    {
        super();
    }

    public Preco(int idPreco , double ateUmaHora , double ateDuasHoras , double ateTresHoras , double aposTresHoras , double pernoite)
    {
        super();
        this.idPreco = idPreco;
        this.ateUmaHora = ateUmaHora;
        this.ateDuasHoras = ateDuasHoras;
        this.ateTresHoras = ateTresHoras;
        this.aposTresHoras = aposTresHoras;
        this.pernoite = pernoite;
    }

    public int getIdPreco()
    {
        return idPreco;
    }

    public void setIdPreco(int idPreco)
    {
        this.idPreco = idPreco;
    }

    public double getAteUmaHora()
    {
        return ateUmaHora;
    }

    public void setAteUmaHora(double ateUmaHora)
    {
        this.ateUmaHora = ateUmaHora;
    }

    public double getAteDuasHoras()
    {
        return ateDuasHoras;
    }

    public void setAteDuasHoras(double ateDuasHoras)
    {
        this.ateDuasHoras = ateDuasHoras;
    }

    public double getAteTresHoras()
    {
        return ateTresHoras;
    }

    public void setAteTresHoras(double ateTresHoras)
    {
        this.ateTresHoras = ateTresHoras;
    }

    public double getAposTresHoras()
    {
        return aposTresHoras;
    }

    public void setAposTresHoras(double aposTresHoras)
    {
        this.aposTresHoras = aposTresHoras;
    }

    public double getPernoite()
    {
        return pernoite;
    }

    public void setPernoite(double pernoite)
    {
        this.pernoite = pernoite;
    }    
}