package view.TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Funcionario;
import model.DAO.FuncionarioDAO;

public class TableModelFuncionario extends AbstractTableModel
{
    List<Funcionario> funcionarios;
    
    public TableModelFuncionario()
    {
        funcionarios = FuncionarioDAO.buscarTodos();
    }
    
    @Override
    public int getColumnCount()
    {
        return 3;
    }
    
    @Override
    public String getColumnName(int index)
    {
        switch (index)
        {
            case 0:
                return "ID do Funcionário";
            case 1:
                return "Nome";
            case 2:
                return "Nome de Usuário";
            case 3:
                return "Nível de Permissão";
                
            default:
                break;
        }
        return null;
    }

    @Override
    public int getRowCount()
    {
        return funcionarios.size();
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
        Funcionario funcionario = funcionarios.get(linha);
        
        switch (coluna)
        {
            case 0:
                return funcionario.getIdFuncionario();
            case 1:
                return funcionario.getNomeFuncionario();
            case 2:
                return funcionario.getNomeUsuario();
            case 3:
                if (funcionario.getNivelPermissao() == 0)
                    return "Gerente";
                else
                    return "Atendente";
        }
        return null;
    }
}