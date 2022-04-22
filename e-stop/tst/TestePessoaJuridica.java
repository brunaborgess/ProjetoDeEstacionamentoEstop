import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.PessoaJuridica;

public class TestePessoaJuridica
{
    PessoaJuridica[] arrayPessoasJuridicas;;
    PessoaJuridica pessoaJuridica;

    @Before
    public void instancia()
    {
        arrayPessoasJuridicas = new PessoaJuridica[1];
        pessoaJuridica = new PessoaJuridica();
    }

    @Test
    public void cadastra()
    {
        pessoaJuridica.setRazaoSocial("Júlio Augusto LTDA.");
        pessoaJuridica.setCnpj("44.404.123/3339-43");
        
        inserir(pessoaJuridica);
        
        assertEquals("Júlio Augusto LTDA." , arrayPessoasJuridicas[0].getRazaoSocial());
    }

    @Test
    public void alteraNome()
    {
        cadastra();
        
        assertEquals("Júlio Augusto LTDA." , arrayPessoasJuridicas[0].getRazaoSocial());
        
        arrayPessoasJuridicas[0].setRazaoSocial("Júlio Agostino LTDA.");
        
        assertEquals("Júlio Agostino LTDA." , arrayPessoasJuridicas[0].getRazaoSocial());
    }
    
    public void inserir(PessoaJuridica pessoaJuridica)
    {
        arrayPessoasJuridicas[0] = pessoaJuridica;
    }
}