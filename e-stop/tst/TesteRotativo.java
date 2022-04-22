import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.DAO.*;

public class TesteRotativo
{

	@Test
	public void testeCadastro() {
		assertTrue(RotativoDAO.inserir("ABC1212", VeiculoDAO.buscarPorIdVeiculo(1), VagaDAO.buscarPorIdVaga(1)) != null);
		assertEquals(RotativoDAO.buscarPorIdRotativo(1).getPlacaVeiculo(), "ABC1212");
	}
}