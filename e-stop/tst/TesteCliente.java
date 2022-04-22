import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Cliente;
import model.DAO.ClienteDAO;

public class TesteCliente
{   
    Cliente[] arrayClientes;

    Cliente cliente;
    

    @Before
    public void instancia()
    {
        arrayClientes = new Cliente[4];
        cliente = new Cliente();
    }

    @Test
    public void cadastra()
    {
        cliente.setLogradouro("Avenida Senhor dos Passos");
        cliente.setNumero(541);
        cliente.setComplemento("Loja A");
        cliente.setBairro("Centro");
        cliente.setCidade("Rio de Janeiro");
        cliente.setUf("RJ");
        cliente.setCep("21370-541");
        cliente.setTelefone1("(21) 3351-2059");
        cliente.setTelefone2("(21) 3351-2060");
        cliente.setEmail("loja@oi.com");

        inserir(cliente);

        assertEquals("Centro" , arrayClientes[0].getBairro());
    }

    @Test
    public void alteraEmail()
    {
        cadastra();

        assertEquals("loja@oi.com" , arrayClientes[0].getEmail());

        arrayClientes[0].setEmail("loja@tim.com");

        assertEquals("loja@tim.com" , arrayClientes[0].getEmail());
    }

    @Test
    public void alteraEndereco()
    {
        cadastra();
        
        assertEquals("Avenida Senhor dos Passos" , arrayClientes[0].getLogradouro());

        arrayClientes[0].setLogradouro("Avenida Senhor das Pisadas");

        assertNotEquals("Avenida Senhor dos Passos" , arrayClientes[0].getLogradouro());
    }

    @Test
    public void alteraTelefone1()
    {
        cadastra();

        assertEquals("(21) 3351-2059" , arrayClientes[0].getTelefone1());

        arrayClientes[0].setTelefone1("(21) 2039-3981");

        assertEquals("(21) 2039-3981" , arrayClientes[0].getTelefone1());
    }

    public void inserir(Cliente cliente)
    {
        arrayClientes[0] = cliente;
    }
}