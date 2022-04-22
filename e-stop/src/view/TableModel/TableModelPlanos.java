package view.TableModel;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Plano;
import model.DAO.PlanoDAO;

public class TableModelPlanos extends AbstractTableModel
{
    List<Plano> planos = PlanoDAO.buscarTodos();

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
            case 0:
                return "Tipo de Plano";
            case 1:
                return "Valor Base (em R$)";
        }
        return null;
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
        Plano plano = planos.get(linha);
        
        DecimalFormat decimal = new DecimalFormat("0.00");
        
        switch (coluna)
        {
            case 0:
                return plano.getDescricao();
            case 1:
                return decimal.format(plano.getValor()).replace("." , ",");
        }
        return null;
    }

}