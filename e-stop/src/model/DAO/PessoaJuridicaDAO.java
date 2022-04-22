package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PessoaJuridica;
import util.Conexao;

public class PessoaJuridicaDAO
{
    public static PessoaJuridica inserir(String cnpj , String razaoSocial , int idCliente)
    {
        PessoaJuridica pessoaJuridica = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "insert PessoaJuridica(cnpj , razaoSocial , idCliente) values (? , ? , ?)";

            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , cnpj);
            comando.setString(2 , razaoSocial);
            comando.setInt(3 , idCliente);

            if (comando.executeUpdate() > 0)
            {
                pessoaJuridica = new PessoaJuridica(cnpj , razaoSocial , ClienteDAO.buscarPorIdCliente(idCliente));
            }
            comando.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return pessoaJuridica;
    }

    public static List<PessoaJuridica> buscarTodos()
    {
        List<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from PessoaJuridica";

            Statement comando = conn.createStatement();

            ResultSet rs = comando.executeQuery(sql);

            while (rs.next())
            {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();

                pessoaJuridica.setCnpj(rs.getString("cnpj"));
                pessoaJuridica.setRazaoSocial(rs.getString("razaoSocial"));
                pessoaJuridica.setCliente(ClienteDAO.buscarPorIdCliente(rs.getInt("idCliente")));

                pessoasJuridicas.add(pessoaJuridica);
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
        return pessoasJuridicas;
    }

    public static PessoaJuridica buscarPorCnpj(String cnpj)
    {
        PessoaJuridica pessoaJuridica = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from PessoaJuridica where cnpj = ?";

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1 , cnpj);

            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                pessoaJuridica = new PessoaJuridica(rs.getString("cnpj") , rs.getString("razaoSocial") ,
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

        return pessoaJuridica;
    }

    public static List<PessoaJuridica> buscarPorRazaoSocial(String razaoSocial)
    {
        List<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "select * from PessoaJuridica where razaoSocial like ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , "%" + razaoSocial + "%");

            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();

                pessoaJuridica.setCnpj(rs.getString("cnpj"));
                pessoaJuridica.setRazaoSocial(rs.getString("razaoSocial"));
                pessoaJuridica.setCliente(ClienteDAO.buscarPorIdCliente(rs.getInt("idCliente")));

                pessoasJuridicas.add(pessoaJuridica);
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
        return pessoasJuridicas;
    }

    public static List<PessoaJuridica> buscarPorRazaoSocialOuCnpj(String string)
    {
        List<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "select * from PessoaJuridica where razaoSocial like ? || cnpj = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , "%" + string + "%");
            comando.setString(2 , string);

            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                PessoaJuridica pessoaJuridica = new PessoaJuridica();

                pessoaJuridica.setCnpj(rs.getString("cnpj"));
                pessoaJuridica.setRazaoSocial(rs.getString("razaoSocial"));
                pessoaJuridica.setCliente(ClienteDAO.buscarPorIdCliente(rs.getInt("idCliente")));

                pessoasJuridicas.add(pessoaJuridica);
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
        return pessoasJuridicas;
    }
}