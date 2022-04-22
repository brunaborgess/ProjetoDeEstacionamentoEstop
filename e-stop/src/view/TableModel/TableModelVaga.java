package view.TableModel;

import java.awt.Color;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Rotativo;
import model.Vaga;
import model.DAO.RotativoDAO;
import model.DAO.VagaDAO;

public class TableModelVaga extends AbstractTableModel
{
    private List<Vaga> vagas;
    
    public TableModelVaga()
    {
        this.vagas = VagaDAO.buscarTodos();
    }
    
    @Override
    public int getColumnCount()
    {
        return 4;
    }
    
    public String getColumnName(int index)
    {        
        switch (index)
        {
            case 0:
                return "#";
                
            case 1:
                return "Coberta";
                
            case 2:
                return "Tipo de Veículo";
                
            case 3:
                return "Ocupante Atual";
        }
        return null;
    }

    @Override
    public int getRowCount()
    {
        return this.vagas.size();
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
        Vaga vaga = vagas.get(linha);
        
        switch (coluna)
        {
            case 0:
                return vaga.getIdVaga();
                
            case 1:
                if (vaga.isCoberta())
                    return "Sim";
                
                return "Não";
                
            case 2:
                return vaga.getTipoDeVeiculo();
                
            case 3:
                Rotativo rotativoOcupante = RotativoDAO.checarSeOcupada(vaga.getIdVaga()); 
                
                if (rotativoOcupante != null)
                    return rotativoOcupante.getPlacaVeiculo();
                
                return "Nenhum";
                
            default:
                break;
        }
        return null;
    }
}