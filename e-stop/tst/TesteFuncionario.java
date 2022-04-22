import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import model.DAO.*;

public class TesteFuncionario
{

	@Test
	public void testeCadastro() {
		assertTrue(FuncionarioDAO.inserir("João dos Alfaces", "João da Madrugada", "123", 1) != null);
		assertEquals(FuncionarioDAO.buscarPorIdFuncionario(1).getNomeFuncionario(),"João dos Alfaces");
	}
	@Test
	public void testeAlterarNivelDePermissao() {
		assertTrue(FuncionarioDAO.atualizarNivelDePermissao(2, 1));
		assertEquals(FuncionarioDAO.buscarPorIdFuncionario(1).getNivelPermissao(),2);
	}
	@Test
	public void testeAlterarUsuarioESenha() {
		assertTrue(FuncionarioDAO.atualizarUsuarioESenha("JoãoDaMadrugada", "12378913", 1));
		assertEquals(FuncionarioDAO.buscarPorIdFuncionario(1).getNomeUsuario(),"JoãoDaMadrugada");
	}
}