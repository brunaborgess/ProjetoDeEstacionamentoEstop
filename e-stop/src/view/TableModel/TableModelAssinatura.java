package view.TableModel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Assinatura;
import model.Cliente;
import model.DAO.AssinaturaDAO;

public class TableModelAssinatura extends AbstractTableModel
{
    List<Assinatura> assinaturas;
    
    public TableModelAssinatura(Cliente cliente)
    {
        assinaturas = AssinaturaDAO.buscarPorCliente(cliente);
    }
     
    @Override
    public int getColumnCount()
    {
        return 6;
    }
    
    @Override
    public String getColumnName(int index)
    {
        switch (index)
        {
            case 0:
                return "ID";
            case 1:
                return "Plano Base";
            case 2:
                return "Valor";
            case 3:
                return "Data da Assinatura";
            case 4:
                return "Vencimento";
            case 5:
                return "Paga";
                
            default:
                break;
        }
        return null;
    }

    @Override
    public int getRowCount()
    {
        return assinaturas.size();
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
        Assinatura assinatura = assinaturas.get(linha);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimal = new DecimalFormat("0.00");
        
        switch (coluna)
        {
            case 0:
                return assinatura.getIdAssinatura();
            case 1:
                return assinatura.getPlano().getDescricao();
            case 2:
                return decimal.format(assinatura.getValorAssinatura()).replace("." , ",");
            case 3:
                String dataAssinatura = dateFormat.format(assinatura.getDataDaAssinatura());
                
                return dataAssinatura;
            case 4:                
                String vencimento = dateFormat.format(assinatura.getVencimento());

                return vencimento;
            case 5:
                return assinatura.isPaga() ? "Sim" : "Não";
                
            default:
                break;
        }
        return null;
    }
}