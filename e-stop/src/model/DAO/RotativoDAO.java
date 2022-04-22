package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Rotativo;
import model.Vaga;
import model.Veiculo;
import util.Conexao;

public class RotativoDAO
{
    public static Rotativo inserir(String placaVeiculo , Veiculo veiculo , Vaga vaga)
    {
        Rotativo rotativo = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "insert rotativo(placaVeiculo , dataEntrada , horaEntrada , dataSaida , horaSaida ,"
                       + " idVeiculo , idVaga) values (? , now() , now() , null , null , ? , ?)";
            
            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , placaVeiculo);
            comando.setInt(2 , veiculo.getIdVeiculo());
            comando.setInt(3 , vaga.getIdVaga());

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();
                
                if (rs.next())
                {
                    rotativo = new Rotativo();
                    
                    int idRotativo = rs.getInt(1);
                    
                    rotativo = RotativoDAO.buscarPorIdRotativo(idRotativo);                                    
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
        return rotativo;
    }

    public static Rotativo buscarPorIdRotativo(int idRotativo)
    {
        Rotativo rotativo = null;
        
        Conexao conex = new Conexao();
        Connection con = conex.obterConexao();
        
        try
        {

            String sql = "select * from rotativo where idRotativo = ?";
            
            PreparedStatement comando = con.prepareStatement(sql);
            
            comando.setInt(1 , idRotativo);
            
            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                rotativo = new Rotativo(rs.getInt("idRotativo") , rs.getString("placaVeiculo") ,
                                rs.getDate("dataEntrada") , rs.getDate("dataSaida") , rs.getTime("horaEntrada") ,
                                rs.getTime("horaSaida") , VeiculoDAO.buscarPorIdVeiculo(rs.getInt("idVeiculo")) ,
                                VagaDAO.buscarPorIdVaga(rs.getInt("idVaga")));
            }
            rs.close();
            comando.close();
            con.close();
        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }
        return rotativo;
    }

    public static boolean atualizar(int idRotativo)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update rotativo set dataSaida = now() , horaSaida = now() where idRotativo = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setInt(1 , idRotativo);

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

    public static Rotativo checarSeOcupada(int idVaga)
    {
        Rotativo rotativo = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from Rotativo where dataSaida is null && idVaga = ?";
            
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setInt(1 , idVaga);
            
            ResultSet rs = comando.executeQuery();
            
            if (rs.next())
            {
                rotativo = new Rotativo();
                
                rotativo.setIdRotativo(rs.getInt("idRotativo"));
                rotativo.setPlacaVeiculo(rs.getString("placaVeiculo"));
                rotativo.setDataEntrada(rs.getDate("dataEntrada"));
                rotativo.setHoraEntrada(rs.getTime("horaEntrada"));
                rotativo.setDataSaida(rs.getDate("dataSaida"));
                rotativo.setHoraSaida(rs.getTime("horaSaida"));
                rotativo.setVeiculo(VeiculoDAO.buscarPorIdVeiculo(rs.getInt("idVeiculo")));
                rotativo.setVaga(VagaDAO.buscarPorIdVaga(rs.getInt("idVaga")));
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
        return rotativo;
    }

    public static Rotativo buscarPorPlaca(String placa)
    {
        Rotativo rotativo = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from Rotativo where dataSaida is null && placaVeiculo = ?";
            
            PreparedStatement comando = conn.prepareStatement(sql);
            
            comando.setString(1 , placa);
            
            ResultSet rs = comando.executeQuery();
            
            if (rs.next())
            {
                rotativo = new Rotativo();
                
                rotativo.setIdRotativo(rs.getInt("idRotativo"));
                rotativo.setPlacaVeiculo(rs.getString("placaVeiculo"));
                rotativo.setDataEntrada(rs.getDate("dataEntrada"));
                rotativo.setHoraEntrada(rs.getTime("horaEntrada"));
                rotativo.setDataSaida(rs.getDate("dataSaida"));
                rotativo.setHoraSaida(rs.getTime("horaSaida"));
                rotativo.setVeiculo(VeiculoDAO.buscarPorIdVeiculo(rs.getInt("idVeiculo")));
                rotativo.setVaga(VagaDAO.buscarPorIdVaga(rs.getInt("idVaga")));
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
        return rotativo;
    }
}