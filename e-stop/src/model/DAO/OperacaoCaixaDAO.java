package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Fatura;
import model.Funcionario;
import model.OperacaoCaixa;
import util.Conexao;

public class OperacaoCaixaDAO
{
    // TODO Possibilitar armazenamento de valor negativo em valorOperacao
    public static OperacaoCaixa inserir(String tipoOperacao , double valorOperacao , double valorCaixa , Fatura fatura , Funcionario funcionario)
    {
        OperacaoCaixa operacaoCaixa = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "insert into OperacaoCaixa(dataOperacao , tipoOperacao , valorOperacao , valorCaixa , idFatura , idFuncionario)"
                       + " values (now() , ? , ? , ? , ? , ?)";
            
            PreparedStatement comando = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);

            comando.setString(1 , tipoOperacao);
            comando.setDouble(2 , valorOperacao);
            comando.setDouble(3 , valorCaixa);
            if (fatura != null)
                comando.setInt(4 , fatura.getIdFatura());
            else
                comando.setString(4 , null);
            comando.setInt(5 , funcionario.getIdFuncionario());

            if (comando.executeUpdate() > 0)
            {
                ResultSet rs = comando.getGeneratedKeys();
                
                if (rs.next())
                {
                    int idOperacaoCaixa = rs.getInt(1);
                    
                    operacaoCaixa = new OperacaoCaixa();
                    
                    operacaoCaixa = OperacaoCaixaDAO.buscarPorIdOperacaoCaixa(idOperacaoCaixa);
                }
                rs.close();
            }
            comando.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return operacaoCaixa;
    }
    
    public static List<OperacaoCaixa> buscarTodos()
    {
        List<OperacaoCaixa> operacoesCaixa = new ArrayList<OperacaoCaixa>();
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select * from operacaoCaixa";
            Statement comando = conn.createStatement();
            ResultSet rs = comando.executeQuery(sql);
            
            while (rs.next())
            {
                OperacaoCaixa operacaoCaixa = new OperacaoCaixa();
                
                operacaoCaixa.setIdOperacaoCaixa(rs.getInt("idOperacaoCaixa"));
                operacaoCaixa.setDataOperacao(rs.getDate("dataOperacao"));
                operacaoCaixa.setTipoOperacao(rs.getString("tipoOperacao"));
                operacaoCaixa.setValorOperacao(rs.getDouble("valorOperacao"));
                operacaoCaixa.setValorCaixa(rs.getDouble("valorCaixa"));
                operacaoCaixa.setFatura(FaturaDAO.buscarPorIdFatura(rs.getInt("idFatura")));
                operacaoCaixa.setFuncionario(FuncionarioDAO.buscarPorIdFuncionario(rs.getInt("idFuncionario")));
                
                operacoesCaixa.add(operacaoCaixa);
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
        
        return operacoesCaixa;
    }

    public static OperacaoCaixa buscarPorIdOperacaoCaixa(int idOperacaoCaixa)
    {
        OperacaoCaixa operacao = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();

        try
        {
            String sql = "select * from OperacaoCaixa where idOperacaoCaixa = ?";
            
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setInt(1 , idOperacaoCaixa);
            
            ResultSet rs = comando.executeQuery();

            while (rs.next())
            {
                operacao = new OperacaoCaixa(rs.getInt("idOperacaoCaixa") , rs.getDate("dataOperacao") ,
                                             rs.getString("tipoOperacao") , rs.getDouble("valorOperacao") ,
                                             rs.getDouble("valorCaixa") , FaturaDAO.buscarPorIdFatura(rs.getInt("idFatura")) ,
                                             FuncionarioDAO.buscarPorIdFuncionario(rs.getInt("idFuncionario")));
            }
            rs.close();
            comando.close();
            conn.close();
        }
        catch (SQLException e)
        {
            
        }

        return operacao;
    }
    
    public static OperacaoCaixa buscarUltimoRegistro()
    {
        // TODO Definir tratamento de erro
        OperacaoCaixa operacaoCaixa = null;
        
        Conexao conexao = new Conexao();
        Connection conn = conexao.obterConexao();
        
        try
        {
            String sql = "select max(idOperacaoCaixa) from operacaoCaixa";
            Statement comando = conn.createStatement();
            ResultSet rs = comando.executeQuery(sql);
            
            if (rs.next())
            {
                int idOperacaoCaixa = rs.getInt(1);
                
                operacaoCaixa = OperacaoCaixaDAO.buscarPorIdOperacaoCaixa(idOperacaoCaixa);
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
        return operacaoCaixa;
    }
}