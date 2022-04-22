import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.DAO.*;

public class TesteVeiculo
{
	@Test
	public void testeCadastro() {
		assertTrue(VeiculoDAO.inserir("Fiat") != null);
		assertEquals(VeiculoDAO.buscarPorIdVeiculo(1).getDescricao(),"Fiat");
	}

	@Test
	public void testeAlterar() {
		assertTrue(VeiculoDAO.atualizar("Fiat Uno", 1));
		assertEquals(VeiculoDAO.buscarPorIdVeiculo(1).getDescricao(),"Fiat Uno");
	}
}