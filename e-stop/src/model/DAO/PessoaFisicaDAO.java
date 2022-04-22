package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PessoaFisica;
import util.Conexao;

public class PessoaFisicaDAO
{
    public static PessoaFisica inserir(String cpf , String nome , int idCliente)
    {
        PessoaFisica pessoaFisica = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "insert into pessoaFisica(cpf , nome , idCliente) values (? , ? , ?)";
            
            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , cpf);
            comando.setString(2 , nome);
            comando.setInt(3 , idCliente);

            if (comando.executeUpdate() > 0)
            {
                    pessoaFisica = new PessoaFisica(cpf , nome , ClienteDAO.buscarPorIdCliente(idCliente));
            }
            comando.close();
        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println("Mensagem de Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return pessoaFisica;
    }
    
    public static List<PessoaFisica> buscarTodos()
    {
        List<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from PessoaFisica";
            
            Statement comando = conn.createStatement();
            
            ResultSet rs = comando.executeQuery(sql);
            
            while(rs.next())
            {
                PessoaFisica pessoaFisica = new PessoaFisica();
                
                pessoaFisica.setCpf(rs.getString("cpf"));
                pessoaFisica.setNome(rs.getString("nome"));
                pessoaFisica.setCliente(ClienteDAO.buscarPorIdCliente(rs.getInt("idCliente")));
                
                pessoasFisicas.add(pessoaFisica);
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
        return pessoasFisicas;
    }
    
    public static PessoaFisica buscarPorCpf(String cpf)
    {
        PessoaFisica pessoaFisica = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from PessoaFisica where cpf = ?";
            
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setString(1 , cpf);
            
            ResultSet rs = comando.executeQuery();

            if (rs.next())
            {
                pessoaFisica = new PessoaFisica(rs.getString("cpf") , rs.getString("nome") ,
                                                ClienteDAO.buscarPorIdCliente(rs.getInt("idCliente")));
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return pessoaFisica;
    }
    
    public static List<PessoaFisica> buscarPorNome(String nome)
    {
        List<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        String sql = "select * from PessoaFisica where nome like ?";
        
        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setString(1 , "%" + nome + "%");
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next())
            {
                PessoaFisica pessoaFisica = new PessoaFisica();
                
                pessoaFisica.setCpf(rs.getString("cpf"));
                pessoaFisica.setNome(rs.getString("nome"));
                pessoaFisica.setCliente(ClienteDAO.buscarPorIdCliente(rs.getInt("idCliente")));
                
                pessoasFisicas.add(pessoaFisica);
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
        return pessoasFisicas;
    }

    public static boolean atualizar(String nome , String cpfAntigo)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update PessoaFisica set nome = ? where cpf = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , nome);
            comando.setString(2 , cpfAntigo);

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

    public static List<PessoaFisica> buscarPorNomeOuCpf(String string)
    {
List<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        String sql = "select * from PessoaFisica where nome like ? || cpf = ?";
        
        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setString(1 , "%" + string + "%");
            comando.setString(2 , string);
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next())
            {
                PessoaFisica pessoaFisica = new PessoaFisica();
                
                pessoaFisica.setCpf(rs.getString("cpf"));
                pessoaFisica.setNome(rs.getString("nome"));
                pessoaFisica.setCliente(ClienteDAO.buscarPorIdCliente(rs.getInt("idCliente")));
                
                pessoasFisicas.add(pessoaFisica);
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
        return pessoasFisicas;
    }
}