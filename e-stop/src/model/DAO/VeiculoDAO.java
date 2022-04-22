package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Veiculo;
import util.Conexao;

public class VeiculoDAO
{
    public static Veiculo inserir(String descricao)
    {
        Veiculo veiculo = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "insert into Veiculo(descricao) values (?)";

            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , descricao);

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();
                
                if (rs.next())
                {
                    int idVeiculo = rs.getInt(1);
                    
                    veiculo = new Veiculo(idVeiculo , descricao);
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
        return veiculo;
    }

    public static Veiculo buscarPorIdVeiculo(int idVeiculo)
    {
        Veiculo veiculo = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from veiculo where idVeiculo = ?";

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1 , idVeiculo);
            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                veiculo = new Veiculo(rs.getInt("idVeiculo") , rs.getString("descricao"));

            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return veiculo;
    }

    public static boolean atualizar(String descricao , int idVeiculo)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update veiculo set descricao = ? where idVeiculo = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , descricao);
            comando.setInt(2 , idVeiculo);

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