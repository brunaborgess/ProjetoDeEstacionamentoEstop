package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.Principal;
import model.DAO.PessoaFisicaDAO;
import model.DAO.PessoaJuridicaDAO;
import view.TableModel.TableModelPF;
import view.TableModel.TableModelPJ;

import java.awt.Component;

public class PainelPesquisaCliente extends JPanel
{
    int opcao;
    
    // TODO Incluir botao Voltar
    public PainelPesquisaCliente(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        JTable tabelaClientes = new JTable();
        tabelaClientes.getTableHeader().setReorderingAllowed(false);
        tabelaClientes.getTableHeader().setResizingAllowed(false);
        tabelaClientes.setBounds(340 , 205 , 650 , 350);
        tabelaClientes.setShowHorizontalLines(false);
        tabelaClientes.setShowVerticalLines(false);
        tabelaClientes.setRowHeight(50);
        
        tabelaClientes.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int linha = tabelaClientes.getSelectedRow();
                
                switch (opcao)
                {
                    case 0:
                        painelPai.add(new PainelClientePF(painelPai , PessoaFisicaDAO.buscarPorCpf((String)tabelaClientes.getValueAt(linha , 1))));
                        break;
                    case 1:
                        painelPai.add(new PainelClientePJ(painelPai , PessoaJuridicaDAO.buscarPorCnpj((String)tabelaClientes.getValueAt(linha , 1))));
                        break;
                }
                
                setVisible(false);
            }
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(75 , 77 , 650 , 353);
        scroll.setViewportView(tabelaClientes);
        scroll.setVisible(false);
        
        JTextField textField = new JTextField();
        textField.setBounds(323 , 41 , 292 , 25);
        
        JRadioButton radioPf = new JRadioButton("Pessoa Física");
        radioPf.setSelected(true);
        
        radioPf.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                opcao = 0;
            }
        });
        
        JRadioButton radioPj = new JRadioButton("Pessoa Jurídica");
        
        radioPj.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                opcao = 1;
            }
        });
        
        ButtonGroup bgRadio = new ButtonGroup();
        
        bgRadio.add(radioPf);
        bgRadio.add(radioPj);
        
        JPanel painelRadio = new JPanel();
        
        painelRadio.setLayout(new BoxLayout(painelRadio , BoxLayout.LINE_AXIS));
        painelRadio.setPreferredSize(new Dimension(200 , 25));
        painelRadio.setBounds(75 , 41 , 238 , 25);
        
        painelRadio.add(radioPf);
        painelRadio.add(radioPj);
        
        add(painelRadio);
        
        JButton botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.setBounds(625 , 41 , 100 , 25);
        
        botaoPesquisar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (! textField.getText().isEmpty())
                {
                    switch (opcao)
                    {
                        case 0:
                            tabelaClientes.setModel(new TableModelPF(textField.getText()));
                            break;
                        case 1:
                            tabelaClientes.setModel(new TableModelPJ(textField.getText()));
                            break;
                    }
                    scroll.setVisible(true);
                }
            }
        });
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200 , 25));
        botaoVoltar.setBounds(75 , 468 , 200 , 25);
        
        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new HomeClientes(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoVoltar);
        add(textField);
        add(botaoPesquisar);
        add(scroll);
    }
}