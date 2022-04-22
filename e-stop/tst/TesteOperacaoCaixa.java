import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.DAO.*;

public class TesteOperacaoCaixa
{

	@Test
	public void testeCadastro() {
		assertTrue(OperacaoCaixaDAO.inserir("Fechamento", 250, 500, FaturaDAO.buscarPorIdFatura(1), FuncionarioDAO.buscarPorIdFuncionario(1)) != null);
		assertEquals(OperacaoCaixaDAO.buscarPorIdOperacaoCaixa(1).getTipoOperacao(),"Fechamento");
	}
	
}