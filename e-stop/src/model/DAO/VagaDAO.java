package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Vaga;
import util.Conexao;

public class VagaDAO
{
    public static Vaga inserir(boolean coberta , String tipoDeVeiculo)
    {
        Vaga vaga = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "insert into vaga(coberta , tipoDeVeiculo) values (? , ?)";

            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setBoolean(1 , coberta);
            comando.setString(2 , tipoDeVeiculo);

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();

                if (rs.next())
                {
                    int idVaga = rs.getInt(1);

                    vaga = new Vaga();

                    vaga = VagaDAO.buscarPorIdVaga(idVaga);
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
        return vaga;
    }

    public static List<Vaga> buscarTodos()
    {
        List<Vaga> vagas = new ArrayList<Vaga>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from vaga";
            Statement comando = conn.createStatement();
            ResultSet rs = comando.executeQuery(sql);

            while (rs.next())
            {
                Vaga vaga = new Vaga();

                vaga.setIdVaga(rs.getInt("idVaga"));
                vaga.setDisponivel(rs.getBoolean("disponivel"));
                vaga.setCoberta(rs.getBoolean("coberta"));
                vaga.setTipoDeVeiculo(rs.getString("tipoDeVeiculo"));

                vagas.add(vaga);
            }
            rs.close();
            comando.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
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
        return vagas;
    }

    public static List<Vaga> buscarLivres()
    {
        List<Vaga> vagas = new ArrayList<Vaga>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from vaga where disponivel = true";

            Statement comando = conn.createStatement();

            ResultSet rs = comando.executeQuery(sql);

            while (rs.next())
            {
                Vaga vaga = new Vaga();

                vaga.setIdVaga(rs.getInt("idVaga"));
                vaga.setDisponivel(rs.getBoolean("disponivel"));
                vaga.setCoberta(rs.getBoolean("coberta"));
                vaga.setTipoDeVeiculo(rs.getString("tipoDeVeiculo"));

                vagas.add(vaga);
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
        return vagas;
    }

    public static Vaga buscarPorIdVaga(int idVaga)
    {
        Vaga vaga = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {

            String sql = "select * from vaga where idVaga = ?";

            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setInt(1 , idVaga);

            ResultSet rs = comando.executeQuery();

            if (rs.next())
            {
                vaga = new Vaga(rs.getInt("idVaga") , rs.getBoolean("disponivel") , rs.getBoolean("coberta") ,
                                rs.getString("tipoDeVeiculo"));
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }
        return vaga;
    }

    public static boolean atualizar(boolean coberta , String tipoDeVeiculo , int idVaga)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update vaga set coberta = ? , tipoDeVeiculo = ? where idVaga = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setBoolean(1 , coberta);
            comando.setString(2 , tipoDeVeiculo);
            comando.setInt(3 , idVaga);

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

    public static boolean alterarDisponibilidade(int idVaga)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update vaga set disponivel = ? where idVaga = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setBoolean(1 , ! VagaDAO.buscarPorIdVaga(idVaga).isDisponivel());
            comando.setInt(2 , idVaga);

            ok = comando.executeUpdate() > 0;

            comando.close();

        }
        catch (Exception e)
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
        return ok;
    }

    public static Vaga excluir(int idVaga)
    {
        Vaga vaga = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "delete from Vaga where idVaga = ?";

            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setInt(1 , idVaga);

            comando.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return vaga;
    }

    public static List<Vaga> buscarLivresPorTipoDeVeiculo(String tipoDeVeiculo)
    {
        List<Vaga> vagas = new ArrayList<Vaga>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {

            String sql = "select * from vaga where tipoDeVeiculo = ? && disponivel = true";

            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , tipoDeVeiculo);

            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                Vaga vaga = new Vaga(rs.getInt("idVaga") , rs.getBoolean("disponivel") , rs.getBoolean("coberta") ,
                                rs.getString("tipoDeVeiculo"));

                vagas.add(vaga);
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }
        return vagas;
    }

    public static List<String> buscarTiposDeVeiculo()
    {
        List<String> tiposDeVeiculo = new ArrayList<String>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select tipoDeVeiculo from vaga group by tipoDeVeiculo";

            Statement comando = conn.createStatement();

            ResultSet rs = comando.executeQuery(sql);

            while (rs.next())
            {
                String tipoDeVeiculo = rs.getString("tipoDeVeiculo");

                tiposDeVeiculo.add(tipoDeVeiculo);
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }
        return tiposDeVeiculo;
    }
}