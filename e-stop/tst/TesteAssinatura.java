import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.sql.Date;
import org.junit.Test;
import model.DAO.*;

public class TesteAssinatura{

	@Test
	public void testeCadastro() {
		assertTrue(AssinaturaDAO.inserir(250.00, new Date(2013, 01, 02), ClienteDAO.buscarPorIdCliente(1), PlanoDAO.buscarPorIdPlano(1)) != null);
		assertEquals(AssinaturaDAO.buscarPorIdAssinatura(1).getValorAssinatura(),250);
	}
}