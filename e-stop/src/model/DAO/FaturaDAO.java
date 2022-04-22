package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;

import model.Assinatura;
import model.Fatura;
import model.Rotativo;
import util.Conexao;

public class FaturaDAO
{
    public static Fatura inserirFaturaAssinatura(String formaPagamento , double valorFatura , Assinatura assinatura)
    {
        Fatura fatura = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "insert into fatura(dataEmissao , horaEmissao , formaPagamento , valorFatura , idAssinatura)"
                       + " values (now() , now() , ? , ? , ?)";

            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , formaPagamento);
            comando.setDouble(2 , valorFatura);
            comando.setInt(3 , assinatura.getIdAssinatura());

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();

                if (rs.next())
                {
                    int idFatura = rs.getInt(1);

                    fatura = new Fatura();

                    fatura.setIdFatura(idFatura);
                    fatura.setDataEmissao(FaturaDAO.buscarPorIdFatura(idFatura).getDataEmissao());
                    fatura.setHoraEmissao(FaturaDAO.buscarPorIdFatura(idFatura).getHoraEmissao());
                    fatura.setFormaPagamento(formaPagamento);
                    fatura.setValorFatura(valorFatura);
                    fatura.setAssinatura(AssinaturaDAO.buscarPorIdAssinatura(assinatura.getIdAssinatura()));
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
        return fatura;
    }

    public static Fatura inserirFaturaRotativo(String formaPagamento , Double valorFatura , Rotativo rotativo)
    {
        Fatura fatura = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "insert into fatura(dataEmissao , horaEmissao , formaPagamento , valorFatura , "
                       + "idRotativo) values (now() , now() , ? , ? , ?)";

            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , formaPagamento);
            comando.setDouble(2 , valorFatura);
            comando.setInt(3 , rotativo.getIdRotativo());

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();

                if (rs.next())
                {
                    int idFatura = rs.getInt(1);

                    fatura = new Fatura();
                    
                    fatura.setIdFatura(rs.getInt(1));
                    fatura.setDataEmissao(FaturaDAO.buscarPorIdFatura(idFatura).getDataEmissao());
                    fatura.setHoraEmissao(FaturaDAO.buscarPorIdFatura(idFatura).getHoraEmissao());
                    fatura.setFormaPagamento(formaPagamento);
                    fatura.setValorFatura(valorFatura);
                    fatura.setRotativo(RotativoDAO.buscarPorIdRotativo(rotativo.getIdRotativo()));
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
        return fatura;
    }

    public static Fatura buscarPorIdFatura(int idFatura)
    {
        Fatura fatura = null;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from fatura where idFatura = ?";

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1 , idFatura);

            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                fatura = new Fatura(rs.getInt("idFatura") , rs.getDate("dataEmissao") , rs.getTime("horaEmissao") ,
                                rs.getString("formaPagamento") , rs.getDouble("valorFatura") ,
                                AssinaturaDAO.buscarPorIdAssinatura(rs.getInt("idAssinatura")) ,
                                RotativoDAO.buscarPorIdRotativo(rs.getInt("idRotativo")));

            }
            rs.close();
            comando.close();
            conn.close();

        }
        catch (SQLException e)
        {
            System.out.println("Mensagem de Erro: " + e.getMessage());
        }

        return fatura;
    }

    public static boolean atualizar(Date dataEmissao , Time horaEmissao , String formaPagamento , Double valorFatura ,
                    int idFatura)
    {
        boolean ok = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        String sql = "update fatura set dataEmissao = ?, horaEmissao = ?, formaPagamento = ?, valorFatura = ? where idFatura = ?";

        try
        {
            PreparedStatement comando = conn.prepareStatement(sql);

            comando.setDate(1 , dataEmissao);
            comando.setTime(2 , horaEmissao);
            comando.setString(3 , formaPagamento);
            comando.setDouble(4 , valorFatura);
            comando.setInt(5 , idFatura);

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