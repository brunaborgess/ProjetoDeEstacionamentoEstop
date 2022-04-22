package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Assinatura;
import model.Cliente;
import model.Plano;
import util.Conexao;

public class AssinaturaDAO
{
    public static Assinatura inserir(double valorAssinatura , Date vencimento , Cliente cliente ,
                                     Plano plano)
    {
        Assinatura assinatura = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        // TODO Remover gambiarra
        vencimento.setYear(vencimento.getYear() - 1900);
        vencimento.setMonth(vencimento.getMonth() - 1);
        
        try
        {
            String sql = "insert into assinatura(dataDaAssinatura , valorAssinatura , vencimento , idCliente , idPlano)" 
                       + " values (now() , ? , ? , ? , ?)";

            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setDouble(1 , valorAssinatura);
            comando.setDate(2 , vencimento);
            comando.setInt(3 , cliente.getIdCliente());
            comando.setInt(4 , plano.getIdPlano());

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();
                
                if (rs.next())
                {
                    assinatura = AssinaturaDAO.buscarPorIdAssinatura(rs.getInt(1));
                }
                rs.close();
                comando.close();
            }
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
        return assinatura;
    }
    
    public static List<Assinatura> buscarPorCliente(Cliente cliente)
    {
        List<Assinatura> assinaturas = new ArrayList<Assinatura>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from assinatura where idCliente = ?";
            
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setInt(1 , cliente.getIdCliente());
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next())
            {
                Assinatura assinatura = new Assinatura();
                
                assinatura.setIdAssinatura(rs.getInt("idAssinatura"));
                assinatura.setValorAssinatura(rs.getDouble("valorAssinatura"));
                assinatura.setDataDaAssinatura(rs.getDate("dataDaAssinatura"));
                assinatura.setVencimento(rs.getDate("vencimento"));
                assinatura.setCliente(cliente);
                assinatura.setPlano(PlanoDAO.buscarPorIdPlano(rs.getInt("idPlano")));
                assinatura.setVaga(VagaDAO.buscarPorIdVaga(rs.getInt("idVaga")));
                assinatura.setPaga(rs.getBoolean("paga"));
                
                assinaturas.add(assinatura);
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
        return assinaturas;
    }
    
    public static Assinatura buscarPorIdAssinatura(int idAssinatura)
    {
        Assinatura assinatura = null;

        try
        {
            String sql = "select * from assinatura where idAssinatura = ?";

            Conexao conexao = new Conexao();
            Connection conn = conexao.obterConexao();

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1 , idAssinatura);
            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                assinatura = new Assinatura(rs.getInt("idAssinatura") , rs.getDate("dataDaAssinatura") ,
                             rs.getDouble("valorAssinatura") , rs.getDate("vencimento") , rs.getBoolean("paga") , 
                             ClienteDAO.buscarPorIdCliente(rs.getInt("idCliente")) , PlanoDAO.buscarPorIdPlano(rs.getInt("idPlano")) ,
                             VagaDAO.buscarPorIdVaga(rs.getInt("idVaga")));
                
                assinatura.setPaga(rs.getBoolean("paga"));
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return assinatura;
    }

    public static boolean atualizar(boolean paga , int idAssinatura)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update assinatura set paga = ? where idAssinatura = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setBoolean(1 , paga);
            comando.setInt(2 , idAssinatura);

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

    public static boolean atualizarVencimento(Date vencimento , int idAssinatura)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update Assinatura set vencimento = ? where idAssinatura = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setDate(1 , vencimento);
            comando.setInt(2 , idAssinatura);

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