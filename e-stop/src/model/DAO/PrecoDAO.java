package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Preco;
import util.Conexao;

public class PrecoDAO
{
    public static Preco inserir(double umaHora , double duasHoras , double tresHoras , double aposTresHoras ,
                                double pernoite)
    {
        Preco preco = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "insert Preco(umaHora , duasHoras , tresHoras , aposTres , pernoite)" 
                       + " values (? , ? , ? , ? , ?)";
            
            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setDouble(1 , umaHora);
            comando.setDouble(2 , duasHoras);
            comando.setDouble(3 , tresHoras);
            comando.setDouble(4 , aposTresHoras);
            comando.setDouble(5 , pernoite);

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();
                
                if (rs.next())
                {
                    int idPreco = rs.getInt(1);
                    preco = new Preco(idPreco , umaHora , duasHoras , tresHoras , aposTresHoras , pernoite);
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
        return preco;
    }
    
    public static List<Preco> buscarTodos()
    {
        List<Preco> precos = new ArrayList<Preco>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from preco order by idPreco desc";
            
            Statement comando = conn.createStatement();
            
            ResultSet rs = comando.executeQuery(sql);
            
            while (rs.next())
            {
                Preco preco = new Preco();
                
                preco.setIdPreco(rs.getInt("idPreco"));
                preco.setAteUmaHora(rs.getDouble("umaHora"));
                preco.setAteDuasHoras(rs.getDouble("duasHoras"));
                preco.setAteTresHoras(rs.getDouble("tresHoras"));
                preco.setAposTresHoras(rs.getDouble("aposTres"));
                preco.setPernoite(rs.getDouble("pernoite"));
                
                precos.add(preco);
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
        return precos;
    }
    
    public static Preco buscarUltimoRegistro()
    {
        // Definir tratamento de erro
        Preco preco = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select max(idPreco) from preco";
            
            Statement comando = conn.createStatement();
            
            ResultSet rs = comando.executeQuery(sql);
            
            if (rs.next())
            {
                int idPreco = rs.getInt(1);
                
                preco = PrecoDAO.buscarPorIdPreco(idPreco);
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
        return preco;
    }

    public static Preco buscarPorIdPreco(int idPreco)
    {
        Preco preco = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from preco where idPreco = ?";
            
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setInt(1 , idPreco);
            
            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                preco = new Preco(rs.getInt("idPreco") , rs.getDouble("umaHora") , rs.getDouble("duasHoras") ,
                                  rs.getDouble("tresHoras") , rs.getDouble("aposTres") , rs.getDouble("pernoite"));

            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }
        return preco;
    }
}