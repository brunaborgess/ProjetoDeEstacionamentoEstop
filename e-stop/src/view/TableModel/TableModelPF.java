package view.TableModel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.DAO.ClienteDAO;
import model.DAO.PessoaFisicaDAO;
import model.DAO.PessoaJuridicaDAO;

public class TableModelPF extends AbstractTableModel
{
    // TODO Pesquisar tanto em uma tabela quanto em outra
    List<PessoaFisica> pessoasFisicas;
    
    public TableModelPF(String string)
    {
        pessoasFisicas = PessoaFisicaDAO.buscarPorNomeOuCpf(string);
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
                return "Nome Completo";
            case 1:
                return "CPF";
        }
        return null;
    }

    @Override
    public int getRowCount()
    {
        return pessoasFisicas.size();
    }

    @Override
    public Object getValueAt(int linha , int coluna)
    {
            PessoaFisica pessoaFisica = pessoasFisicas.get(linha);
            
            switch (coluna)
            {
                case 0:
                    return pessoaFisica.getNome();
                case 1:
                    return pessoaFisica.getCpf();
            }
        return null;
    }
}