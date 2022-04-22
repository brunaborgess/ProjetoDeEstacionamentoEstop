package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;

import controller.Acesso;
import model.OperacaoCaixa;
import view.TableModel.TableModelOperacaoCaixa;

public class PainelHistoricoCaixa extends JPanel
{
    TableModelOperacaoCaixa tableModelOperacaoCaixa;
    
    // TODO Acrescentar botao "Abrir Caixa"
    public PainelHistoricoCaixa()
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        JTable tabelaCaixa = new JTable(new TableModelOperacaoCaixa());
        tabelaCaixa.setLocation(0, 101);
        
        tabelaCaixa.getTableHeader().setReorderingAllowed(false);
        tabelaCaixa.getTableHeader().setResizingAllowed(false);
        tabelaCaixa.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(60 , 63 , 680 , 333);
        scroll.setViewportView(tabelaCaixa);
        
        JButton botaoLogout = new JButton("Logout");
        botaoLogout.setBounds(60 , 448 , 200 , 25);
        
        botaoLogout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int opcao = JOptionPane.showConfirmDialog(null , "O caixa será fechado. Deseja realmente se desconectar?" ,
                                                          "Selecione uma opção" , JOptionPane.YES_NO_OPTION);
                
                switch (opcao)
                {
                    case JOptionPane.YES_OPTION:
                        OperacaoCaixa.fecharCaixa();
                        
                        if (OperacaoCaixa.caixaEstaFechado())
                            Acesso.logout();
                        break;
                        
                    default:
                        break;
                }
            }
        });
        JButton botaoAtualizar = new JButton("Atualizar");
        botaoAtualizar.setPreferredSize(new Dimension(200 , 25));
        botaoAtualizar.setBounds(60 , 27 , 200 , 25);
        
        botaoAtualizar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tableModelOperacaoCaixa = new TableModelOperacaoCaixa();
                
                tabelaCaixa.setModel(tableModelOperacaoCaixa);
            }
        });
        
        add(botaoAtualizar);
        add(scroll);
        add(botaoLogout);
    }
}