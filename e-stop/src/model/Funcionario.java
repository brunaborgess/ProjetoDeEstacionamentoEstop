package model;

public class Funcionario
{
    private int idFuncionario , nivelPermissao;

    private String nomeFuncionario , nomeUsuario , senha;
    
    public Funcionario()
    {
        super();
    }

    public Funcionario(int idFuncionario , String nomeFuncionario , String nomeUsuario , String senha ,
                    int nivelPermissao)
    {
        super();
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nivelPermissao = nivelPermissao;
    }

    public int getIdFuncionario()
    {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario)
    {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario()
    {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario)
    {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setNomeUsuario(String nomeUsuario)
    {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario()
    {
        return nomeUsuario;
    }

    public void setNomeDeUsuario(String nomeUsuario)
    {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public int getNivelPermissao()
    {
        return nivelPermissao;
    }

    public void setNivelPermissao(int nivelPermissao)
    {
        this.nivelPermissao = nivelPermissao;
    }

    @Override
    public String toString()
    {
        return "Funcionario [idFuncionario=" + idFuncionario + ", nomeFuncionario=" + nomeFuncionario + ", nomeUsuario="
               + nomeUsuario + ", Senha=" + senha + ", nivelPermissao=" + nivelPermissao + "]";
    }
}