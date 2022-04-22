package view.TableModel;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Plano;
import model.DAO.PlanoDAO;

public class TableModelPlano extends AbstractTableModel
{
    List<Plano> planos;

    public TableModelPlano()
    {
        planos = PlanoDAO.buscarTodos();
    }

    @Override
    public int getRowCount()
    {
        return planos.size();
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public String getColumnName(int index)
    {
        switch (index)
        {
            case 0 :
                return "Tipo de Plano";
            case 1 :
                return "Valor (em R$)";

            default :
                break;
        }
        return null;
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        Plano plano = planos.get(linha);

        switch (coluna)
        {
            case 0 :
                return plano.getDescricao();
            case 1 :
                return decimalFormat.format(plano.getValor()).toString().replace("." , ",");

            default :
                break;
        }
        return null;
    }
}