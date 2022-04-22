package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Plano;
import util.Conexao;

public class PlanoDAO
{
    public static Plano inserir(String descricao , double valor)
    {
        Plano plano = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "insert Plano(descricao , valor) values (? , ?)";
            
            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , descricao);
            comando.setDouble(2 , valor);

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();
                
                if (rs.next())
                {
                    int idPlano = rs.getInt(1);
                    
                    plano = new Plano(idPlano , descricao , valor);
                }
                rs.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return plano;
    }
    
    public static List<Plano> buscarTodos()
    {
        List<Plano> planos = new ArrayList<Plano>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from plano";
            
            Statement comando = conn.createStatement();
            ResultSet rs = comando.executeQuery(sql);
            
            while (rs.next())
            {
                Plano plano = new Plano();
                
                plano.setIdPlano(rs.getInt("idPlano"));
                plano.setValor(rs.getDouble("valor"));
                plano.setDescricao(rs.getString("descricao"));
                
                planos.add(plano);
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
        return planos;
    }

    public static Plano buscarPorIdPlano(int idPlano)
    {
        Plano plano = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from plano where idPlano = ?";
            
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1 , idPlano);
            
            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                plano = new Plano(rs.getInt("idPlano") , rs.getString("descricao") , rs.getDouble("valor"));
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }
        return plano;
    }

    public static boolean atualizarDados(String descricao , double valor , int idPlano)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update plano set descricao = ?, valor = ? where idPlano = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , descricao);
            comando.setDouble(2 , valor);
            comando.setInt(3 , idPlano);

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

    public static Plano buscarPorDescricao(String descricao)
    {
            Plano plano = null;
            
            Conexao conexao = new Conexao();
            Connection conn = conexao.obterConexao();
            
            try
            {
                String sql = "select * from plano where descricao = ?";
                
                PreparedStatement comando = conn.prepareStatement(sql);
                comando.setString(1 , descricao);
                
                ResultSet rs = comando.executeQuery();

                if (rs.next())
                {
                    plano = new Plano(rs.getInt("idPlano") , rs.getString("descricao") , rs.getDouble("valor"));
                }
                rs.close();
                comando.close();
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println("Mensagem de Erro: " + e.getMessage());
            }
            return plano;
        }
    
}