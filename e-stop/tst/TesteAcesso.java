import static org.junit.Assert.*;

import org.junit.Test;

import controller.Acesso;

public class TesteAcesso
{
    @Test
    public void fazLoginComCredenciaisCorretas()
    {
        assertTrue(Acesso.login("jose123" , "123"));

        assertEquals(Acesso.getFuncionario().getNomeUsuario() , "jose123");
    }

    @Test
    public void fazLoginComNomeUsuarioIncorreto()
    {
        assertFalse(Acesso.login("jose321" , "123"));
    }

    @Test
    public void fazLoginComSenhaIncorreta()
    {
        assertFalse(Acesso.login("jose123" , "321"));
    }

    @Test
    public void fazLoginELogout()
    {
        assertTrue(Acesso.login("jose123" , "123"));

        Acesso.logout();

        // Necessita que instrução da linha 36 na classe Acesso seja desativada 
        assertEquals(null , Acesso.getFuncionario());
    }
}