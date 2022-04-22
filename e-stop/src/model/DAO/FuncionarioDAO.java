package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import util.Conexao;

public class FuncionarioDAO
{
    public static Funcionario inserir(String nomeFuncionario , String nomeUsuario , String senha , int nivelPermissao)
    {
        Funcionario funcionario = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "insert into funcionario(nomeFuncionario , nomeUsuario , senha , nivelPermissao)"
                            + " values (? , ? , ? , ?)";

            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , nomeFuncionario);
            comando.setString(2 , nomeUsuario);
            comando.setString(3 , senha);
            comando.setInt(4 , nivelPermissao);

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();

                if (rs.next())
                {
                    int idFuncionario = rs.getInt(1);

                    funcionario = new Funcionario(idFuncionario , nomeFuncionario , nomeUsuario , senha ,
                                    nivelPermissao);
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
        return funcionario;
    }

    public static List<Funcionario> buscarTodos()
    {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from funcionario where nivelPermissao is not null";

            Statement comando = conn.createStatement();

            ResultSet rs = comando.executeQuery(sql);

            while (rs.next())
            {
                Funcionario funcionario = new Funcionario();

                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomeFuncionario(rs.getString("nomeFuncionario"));
                funcionario.setNomeUsuario(rs.getString("nomeUsuario"));
                funcionario.setNivelPermissao(rs.getInt("nivelPermissao"));

                funcionarios.add(funcionario);
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
        return funcionarios;
    }

    public static Funcionario buscarPorIdFuncionario(int idFuncionario)
    {
        Funcionario funcionario = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from funcionario where idFuncionario = ? && nivelPermissao is not null";

            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setInt(1 , idFuncionario);

            ResultSet rs = comando.executeQuery();

            if (rs.next())
            {
                funcionario = new Funcionario(rs.getInt("idFuncionario") , rs.getString("nomeFuncionario") ,
                                rs.getString("nomeUsuario") , rs.getString("senha") , rs.getInt("nivelPermissao"));
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return funcionario;
    }

    public static Funcionario buscarPorLoginESenha(String nomeUsuario , String senha)
    {
        Funcionario funcionario = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from funcionario where nomeUsuario = ? && senha = ? && nivelPermissao is not null";

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1 , nomeUsuario);
            comando.setString(2 , senha);

            ResultSet rs = comando.executeQuery();

            if (rs.next())
            {
                funcionario = new Funcionario(rs.getInt("idFuncionario") , rs.getString("nomeFuncionario") ,
                                rs.getString("nomeUsuario") , rs.getString("senha") , rs.getInt("nivelPermissao"));
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return funcionario;
    }

    public static boolean atualizarNivelDePermissao(int nivelPermissao , int idFuncionario)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update funcionario set nivelPermissao = ? where idFuncionario = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setInt(1 , nivelPermissao);
            comando.setInt(2 , idFuncionario);

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

    public static boolean atualizarUsuarioESenha(String nomeUsuario , String senha , int idFuncionario)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update funcionario set nomeUsuario = ? , senha = ? where idFuncionario = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , nomeUsuario);
            comando.setString(2 , senha);
            comando.setInt(3 , idFuncionario);

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

    public static Funcionario excluir(int idFuncionario)
    {
        Funcionario funcionario = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "delete from Funcionario where idFuncionario = ?";

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1 , idFuncionario);
            comando.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return funcionario;
    }

    public static Funcionario buscarPorNomeUsuario(String nomeUsuario)
    {
        Funcionario funcionario = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from funcionario where nomeUsuario = ?";

            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setString(1 , nomeUsuario);

            ResultSet rs = comando.executeQuery();

            if (rs.next())
            {
                funcionario = new Funcionario(rs.getInt("idFuncionario") , rs.getString("nomeFuncionario") ,
                                rs.getString("nomeUsuario") , rs.getString("senha") , rs.getInt("nivelPermissao"));
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return funcionario;
    }
}