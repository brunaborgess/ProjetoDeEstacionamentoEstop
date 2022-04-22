import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import model.DAO.PlanoDAO;

public class TestePlano
{

	@Test
	public void testeCadastro() {
		assertTrue(PlanoDAO.inserir("Mensal", 300) != null);
		assertEquals(PlanoDAO.buscarPorIdPlano(1).getIdPlano(),"Mensal");
	}

	@Test
	public void testeAlterar() {
		assertTrue(PlanoDAO.atualizarDados("Mensal", 250, 1));
		assertEquals(PlanoDAO.buscarPorIdPlano(1).getIdPlano(),"Mensal");
	}
}