package view.TableModel;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.OperacaoCaixa;
import model.DAO.OperacaoCaixaDAO;

public class TableModelOperacaoCaixa extends AbstractTableModel
{
    private List<OperacaoCaixa> operacoesCaixa;
    
    public TableModelOperacaoCaixa()
    {
        this.operacoesCaixa = OperacaoCaixaDAO.buscarTodos();
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }
    
    public String getColumnName(int index)
    {
        switch (index)
        {
//            case 0:
//                return "ID da Operaçao";
            case 0:
                return "Data";
            case 1:
                return "Descrição";
            case 2:
                return "Valor Movimentado";
            case 3:
                return "Valor em Caixa";
//            case 5:
//                return "ID da Fatura";
            case 4:
                return "ID do Funcionário";
                
            default:
                break;
        }
        return null;
    }

    @Override
    public int getRowCount()
    {
        return operacoesCaixa.size();
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
        OperacaoCaixa operacaoCaixa = operacoesCaixa.get(linha);
        
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        
        switch (coluna)
        {
//            case 0:
//                return operacaoCaixa.getIdOperacaoCaixa();
            case 0:
                return operacaoCaixa.getDataOperacao();
            case 1:
                return operacaoCaixa.getTipoOperacao();
            case 2:
                return decimalFormat.format(operacaoCaixa.getValorOperacao()).toString().replace("." , ",");
            case 3:
                return decimalFormat.format(operacaoCaixa.getValorCaixa()).toString().replace("." , ",");
//            case 5:
//                try
//                {
//                    return operacaoCaixa.getFatura().getIdFatura();
//                }
//                catch (NullPointerException e)
//                {
//                    return "Nulo";
//                }
            case 4:
                return operacaoCaixa.getFuncionario().getIdFuncionario();
                
            default:
                break;    
        }
        return null;
    }
}