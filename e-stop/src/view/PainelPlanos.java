package view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Principal;
import view.TableModel.TableModelPlano;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelPlanos extends JPanel
{
    public PainelPlanos(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        JTable tabelaPlanos = new JTable(new TableModelPlano());
        tabelaPlanos.setLocation(251 , 0);
        tabelaPlanos.setFillsViewportHeight(true);

        tabelaPlanos.getTableHeader().setReorderingAllowed(false);
        tabelaPlanos.getTableHeader().setResizingAllowed(false);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(99 , 64 , 601 , 275);
        scroll.setViewportView(tabelaPlanos);

        add(scroll);

        JButton botaoCadastrar = new JButton("Criar Novo Plano");
        botaoCadastrar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelCadastroPlano(painelPai));
                setVisible(false);
            }
        });
        botaoCadastrar.setBounds(500 , 419 , 200 , 25);

        add(botaoCadastrar);

//        JButton botaoAlterar = new JButton("Alterar Valor do Plano");
//        botaoAlterar.setBounds(500 , 345 , 200 , 25);
//
//        add(botaoAlterar);
//
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(99 , 419 , 200 , 25);
        add(botaoVoltar);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new HomeGerencia(painelPai));
                setVisible(false);
            }
        });
    }
}