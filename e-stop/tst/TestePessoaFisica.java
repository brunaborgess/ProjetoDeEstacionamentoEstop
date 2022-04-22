import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.PessoaFisica;

public class TestePessoaFisica
{
    PessoaFisica[] arrayPessoasFisicas;;
    PessoaFisica pessoaFisica;

    @Before
    public void instancia()
    {
        arrayPessoasFisicas = new PessoaFisica[1];
        pessoaFisica = new PessoaFisica();
    }

    @Test
    public void cadastra()
    {
        pessoaFisica.setNome("Júlio Augusto");
        pessoaFisica.setCpf("144.138.288-39");
        
        inserir(pessoaFisica);
        
        assertEquals("Júlio Augusto" , arrayPessoasFisicas[0].getNome());
    }

    @Test
    public void alteraNome()
    {
        cadastra();
        
        assertEquals("Júlio Augusto" , arrayPessoasFisicas[0].getNome());
        
        arrayPessoasFisicas[0].setNome("Júlio Agostino");
        
        assertEquals("Júlio Agostino" , arrayPessoasFisicas[0].getNome());
    }
    
    public void inserir(PessoaFisica pessoaFisica)
    {
        arrayPessoasFisicas[0] = pessoaFisica;
    }
}