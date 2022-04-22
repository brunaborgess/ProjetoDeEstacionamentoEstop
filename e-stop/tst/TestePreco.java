import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Preco;

public class TestePreco
{
    Preco preco;
    Preco[] arrayPrecos;
    
    @Before
    public void instancia()
    {
        preco = new Preco();
        arrayPrecos = new Preco[1];
    }
    
    @Test
    public void cadastra()
    {
        preco.setAteUmaHora(18.00);
        preco.setAteDuasHoras(23.00);
        preco.setAteTresHoras(30.00);
        preco.setAposTresHoras(40.00);
        preco.setPernoite(35.00);
        
        insere(preco);
        
        assertEquals(18.00 , preco.getAteUmaHora() , 0);
    }
    
    public void insere(Preco preco)
    {
        arrayPrecos[0] = preco;
    }
}