package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao
{    
    private String url , driver , login , senha;

    public Conexao()
    {
        super();
        
        Configurador configurador = new Configurador();
        
        this.url = configurador.getUrl();
        this.driver = configurador.getDriver();
        this.login = configurador.getLogin();
        this.senha = configurador.getSenha();
        
        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Erro ao carregar o Driver. Classe não encontrada");
            System.out.println("Mensagem de erro: " + e.getMessage());
            
            e.printStackTrace();
        }
    }

    public Connection obterConexao()
    {
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(this.url , this.login , this.senha);
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao acessar o Banco de dados.");
            System.out.println("Verifique os parâmetros de conexão.");
            System.out.println("Mensagem de Erro: " + e.getMessage());
            
            e.printStackTrace();
        }
        return conn;
    }

    public String getUrl()
    {
        return url;
    }

    public String getDriver()
    {
        return driver;
    }

    public String getLogin()
    {
        return login;
    }

    public String getSenha()
    {
        return senha;
    }
}