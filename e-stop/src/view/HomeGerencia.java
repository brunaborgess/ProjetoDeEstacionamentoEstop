package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModel.TableModelFuncionario;

public class HomeGerencia extends JPanel
{
    public HomeGerencia(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        JButton botaoUsuarios = new JButton("Lista de Usuarios");
        botaoUsuarios.setBounds(300 , 174 , 200 , 25);

        botaoUsuarios.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelUsuarios(painelPai));
                setVisible(false);
            }
        });

        add(botaoUsuarios);

        JButton botaoPlanos = new JButton("Planos");
        botaoPlanos.setBounds(300 , 297 , 200 , 25);

        botaoPlanos.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelPlanos(painelPai));
                setVisible(false);
            }
        });

        add(botaoPlanos);
        
        JButton botaoTabelaDePrecos = new JButton("Tabela de Preços");
        botaoTabelaDePrecos.setBounds(300, 235, 200, 25);
        
        botaoTabelaDePrecos.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelPrecos(painelPai));
                setVisible(false);
            }
        });
        add(botaoTabelaDePrecos);
    }
}