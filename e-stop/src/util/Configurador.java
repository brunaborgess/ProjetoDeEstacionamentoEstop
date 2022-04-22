package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurador
{
    private String idioma , regiao;
    private String arquivoAjuda;
    private String url , driver , login , senha;

    public Configurador()
    {
        try
        {
            // Abre o arquivo de propriedades
            FileInputStream arq = new FileInputStream("config.ini");

            // Cria um objeto para armazenar as propriedades
            Properties prop = new Properties();

            // Carrega o conteudo do arquivo de propriedades
            prop.load(arq);

            // Fecha o arquivo propriedades
            prop.load(arq);

            // Carrega as respectivas propriedades em cada atributo
            idioma = prop.getProperty("idioma");
            regiao = prop.getProperty("região");
            arquivoAjuda = prop.getProperty("ajuda");
            url = prop.getProperty("url");
            driver = prop.getProperty("driver");
            login = prop.getProperty("login");
            senha = prop.getProperty("senha");
        }
        catch (IOException e)
        {
            System.out.println("Arquivo Config.ini não encontrado.");
        }
    }

    public String getIdioma()
    {
        return idioma;
    }

    public String getRegiao()
    {
        return regiao;
    }

    public String getArquivoAjuda()
    {
        return arquivoAjuda;
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