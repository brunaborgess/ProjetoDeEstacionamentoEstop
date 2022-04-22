package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeClientes extends JPanel
{
    public HomeClientes(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        JButton botaoConsultar = new JButton("Consultar Cliente");
        botaoConsultar.setPreferredSize(new Dimension(200 , 25));
        botaoConsultar.setBounds(300 , 272 , 200 , 25);
        
        botaoConsultar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelPesquisaCliente(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoConsultar);
        
        JButton botaoCadastrar = new JButton("Cadastrar Cliente");
        botaoCadastrar.setPreferredSize(new Dimension(200 , 25));
        botaoCadastrar.setBounds(300 , 177 , 200 , 25);
        
        botaoCadastrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelCadastroCliente(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoCadastrar);
        
    }
}