package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModel.TableModelFuncionario;

public class PainelUsuarios extends JPanel
{
    public PainelUsuarios(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        JTable tabelaFuncionarios = new JTable(new TableModelFuncionario());
        tabelaFuncionarios.setFillsViewportHeight(true);

        tabelaFuncionarios.getTableHeader().setReorderingAllowed(false);
        tabelaFuncionarios.getTableHeader().setResizingAllowed(false);

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabelaFuncionarios);
        scroll.setBounds(102 , 49 , 374 , 346);

        add(scroll);
        
        JButton botaoCadastrar = new JButton("Cadastrar Novo Usuário");
        botaoCadastrar.setBounds(551 , 127 , 200 , 25);

        botaoCadastrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelCadastroFuncionario(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoCadastrar);
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(102 , 454 , 200 , 25);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new HomeGerencia(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoVoltar);
        
//        JButton botaoRemover = new JButton("Remover Usuário");
//        botaoRemover.setBounds(551, 215, 200, 25);
//        
//        botaoRemover.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                new TelaAvisoGenerica("Selecione o funcionário a ser excluído clicando sobre seu nome na tabela");
//                
//                // TODO Tornar janela clicável e chamar janela de confirmação. Definir nivel de permissao do usuário como nulo
//                
//            }
//        });
//        
//        add(botaoRemover);
    }
}