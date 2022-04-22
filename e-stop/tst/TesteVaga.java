import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import model.DAO.VagaDAO;

public class TesteVaga
{

    @Test
    public void testeCadastro()
    {
        assertEquals(VagaDAO.buscarPorIdVaga(1).getTipoDeVeiculo() , "Carro");
    }
}