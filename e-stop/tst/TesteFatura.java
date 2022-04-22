import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;

import model.DAO.*;

public class TesteFatura
{
	@Test
	public void testeCadastroAssinatura() {
		assertTrue(FaturaDAO.inserirFaturaAssinatura("Debito", 250, AssinaturaDAO.buscarPorIdAssinatura(1)) != null);
		assertEquals(FaturaDAO.buscarPorIdFatura(1).getFormaPagamento(), "Debito");
	}
	@Test
	public void testeCadastroRotativo() {
		assertTrue(FaturaDAO.inserirFaturaRotativo("Cheque", (double) 250, RotativoDAO.buscarPorIdRotativo(1)) != null);
		assertEquals(FaturaDAO.buscarPorIdFatura(5).getFormaPagamento(), "Cheque");
	}
	@Test
	public void testeAlterar() {
		assertTrue(FaturaDAO.atualizar(new Date(2013, 01, 02), new Time(4, 25, 10), "Debito Automatico", (double) 400, 1));
		assertEquals(FaturaDAO.buscarPorIdFatura(1).getFormaPagamento(),"Debito Automatico");
	}
}