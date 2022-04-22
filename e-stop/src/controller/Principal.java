package controller;

import view.TelaLogin;
import view.TelaPrincipal;

public class Principal
{
    // Armazena instancia da classe TelaPrincipal para referencias
    public static TelaPrincipal telaPrincipal;
    
    public static void main(String[] args)
    {
        // Inicia primeira tela do programa
        instanciarTelaLogin();
    }
    
    public static TelaPrincipal getTelaPrincipal()
    {
        return telaPrincipal;
    }
    
    public static void setTelaPrincipal(TelaPrincipal telaPrincipal)
    {
        Principal.telaPrincipal = telaPrincipal;
    }
    
    public static void instanciarTelaLogin()
    {
        new TelaLogin();
    }
}