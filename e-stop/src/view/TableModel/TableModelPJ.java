package view.TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.PessoaJuridica;
import model.DAO.PessoaJuridicaDAO;

public class TableModelPJ extends AbstractTableModel
{
    // TODO Pesquisar tanto em uma tabela quanto em outra
    List<PessoaJuridica> pessoasJuridicas;
    
    public TableModelPJ(String string)
    {
        pessoasJuridicas = PessoaJuridicaDAO.buscarPorRazaoSocialOuCnpj(string);
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
                return "Razão Social";
            case 1:
                return "CNPJ";
        }
        return null;
    }

    @Override
    public int getRowCount()
    {
        return pessoasJuridicas.size();
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
            PessoaJuridica pessoaJuridica = pessoasJuridicas.get(linha);
            
            switch (coluna)
            {
                case 0:
                    return pessoaJuridica.getRazaoSocial();
                case 1:
                    return pessoaJuridica.getCnpj();
            }
        return null;
    }
}