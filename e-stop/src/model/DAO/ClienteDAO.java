package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Cliente;
import util.Conexao;

public class ClienteDAO
{
    public static Cliente inserir(String logradouro , int numero , String complemento , String bairro ,
                                  String cidade , String uf , String cep , String telefone1 , String telefone2 ,
                                  String email)
    {
        Cliente cliente = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "insert into cliente(telefone1 , telefone2 , email , logradouro , numero , complemento , "
                       + "bairro , cidade , uf , cep) values (? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , telefone1);
            comando.setString(2 , telefone2);
            comando.setString(3 , email);
            comando.setString(4 , logradouro);
            comando.setInt(5 , numero);
            comando.setString(6 , complemento);
            comando.setString(7 , bairro);
            comando.setString(8 , cidade);
            comando.setString(9 , uf);
            comando.setString(10 , cep);

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();
                
                if (rs.next())
                {
                    int idCliente = rs.getInt(1);
                    
                    cliente = new Cliente(idCliente , numero , telefone2 , email , logradouro , telefone1 ,
                                          complemento , bairro , cidade , uf , cep);
                }
                rs.close();
            }
            comando.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
            e.printStackTrace();
        }
        
        try
        {
            conn.close();
        }
        catch (SQLException e)
        {
            
        }
        return cliente;
    }
    
    public static List<Cliente> buscarTodos()
    {
        List<Cliente> clientes = new LinkedList<Cliente>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from cliente";
            
            Statement comando = conn.createStatement();
            
            ResultSet rs = comando.executeQuery(sql);
            
            while (rs.next())
            {
                Cliente cliente = new Cliente();
                
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setTelefone1(rs.getString("telefone1"));
                cliente.setTelefone2(rs.getString("telefone2"));
                cliente.setEmail(rs.getString("email"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setCep(rs.getString("cep"));
                
                clientes.add(cliente);
            }
            rs.close();
            comando.close();            
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (Exception e)
            {
                
            }
        }
        return clientes;
    }

    public static Cliente buscarPorIdCliente(int idCliente)
    {
        Cliente cliente = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from cliente where idCliente = ?";

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1 , idCliente);
            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                cliente = new Cliente();
                
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setTelefone1(rs.getString("telefone1"));
                cliente.setTelefone2(rs.getString("telefone2"));
                cliente.setEmail(rs.getString("email"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setCep(rs.getString("cep"));
            }
            rs.close();
            comando.close();
        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (Exception e)
            {
                
            }
        }
        return cliente;
    }

    public static boolean atualizarEndereco(String logradouro , int numero , String complemento , String bairro ,
                                            String cidade , String uf , String cep , int idCliente)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update cliente set logradouro = ? , numero = ? , complemento = ? , bairro = ? , cidade = ? , "
                   + "uf = ? , cep = ? where idCliente = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , logradouro);
            comando.setInt(2 , numero);
            comando.setString(3 , complemento);
            comando.setString(4 , bairro);
            comando.setString(5 , cidade);
            comando.setString(6 , uf);
            comando.setString(7 , cep);
            comando.setInt(8 , idCliente);

            ok = comando.executeUpdate() > 0;

            comando.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return ok;
    }

    public static boolean atualizarTelefone(String telefone1 , String telefone2 , int idCliente)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update cliente set telefone1 = ?,telefone2 = ? where idCliente = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , telefone1);
            comando.setString(2 , telefone2);
            comando.setInt(3 , idCliente);

            ok = comando.executeUpdate() > 0;

            comando.close();
            conn.close();

        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return ok;
    }

    public static boolean atualizarEmail(String email , int idCliente)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update cliente set email = ? where idCliente = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , email);
            comando.setInt(2 , idCliente);

            ok = comando.executeUpdate() > 0;

            comando.close();
            conn.close();

        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return ok;
    }
}