package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.Principal;
import controller.ValidadorCpfECnpj;
import java.awt.Color;

public class PainelCadastroCliente extends JPanel
{
    JFormattedTextField textField = new JFormattedTextField();
    
    int opcao;
    
    // Adicionar botao HOME
    public PainelCadastroCliente(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        JPanel subPainel = new JPanel();
        subPainel.setLayout(new BoxLayout(subPainel , BoxLayout.PAGE_AXIS));
        subPainel.setPreferredSize(new Dimension(250 , 125));
        subPainel.setBounds(275 , 158, 250 , 125);
       
        JLabel label = new JLabel("CPF (ou CNPJ) a ser cadastrado:" , SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(200 , 25));
        label.setMinimumSize(new Dimension(200 , 25));
        label.setMaximumSize(new Dimension(200 , 25));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        textField.setPreferredSize(new Dimension(200 , 25));
        textField.setMinimumSize(new Dimension(200 , 25));
        textField.setMaximumSize(new Dimension(200 , 25));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JRadioButton radioPf = new JRadioButton("Pessoa Física");
        radioPf.setAlignmentX(Component.CENTER_ALIGNMENT);
        radioPf.setSelected(true);
        
        radioPf.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                opcao = 0;
                
//                try
//                {
//                    MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
//                    
//                    textField = new JFormattedTextField(mascaraCpf);
//                }
//                catch (ParseException parseException)
//                {
//                    
//                }
            }
        });
        
        JRadioButton radioPj = new JRadioButton("Pessoa Jurídica");
        radioPj.setAlignmentX(Component.CENTER_ALIGNMENT);
        radioPj.setSelected(false);
        
        radioPj.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                opcao = 1;

//                try
//                {
//                    MaskFormatter mascaraCnpj = new MaskFormatter("##.###.###/####-##");
//                    
//                    textField = new JFormattedTextField(mascaraCnpj);
//                }
//                catch (ParseException parseException)
//                {
//                    
//                }
            }
        });
        
        JPanel painelRadio = new JPanel();
        painelRadio.setBounds(0 , 0 , 200 , 25);
        painelRadio.setLayout(new BoxLayout(painelRadio, BoxLayout.LINE_AXIS));
        
        painelRadio.add(radioPf);
        painelRadio.add(radioPj);
        
        ButtonGroup group = new ButtonGroup();
        
        group.add(radioPf);
        group.add(radioPj);
        
        subPainel.add(painelRadio);
        
        Component rigidArea = Box.createRigidArea(new Dimension(0, 25));
        subPainel.add(rigidArea);
        
        subPainel.add(label);
        subPainel.add(textField);
        
        JLabel labelCampoVazio = new JLabel("Preencha o campo corretamente");
        labelCampoVazio.setForeground(Color.RED);
        labelCampoVazio.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelCampoVazio.setVisible(false);
        
        subPainel.add(labelCampoVazio);
        add(subPainel);
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(88, 342, 200, 25);
        add(botaoVoltar);
        botaoVoltar.setPreferredSize(new Dimension(200 , 25));
        botaoVoltar.setMinimumSize(new Dimension(200 , 25));
        botaoVoltar.setMaximumSize(new Dimension(200 , 25));
        botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setBounds(507, 342, 200, 25);
        add(botaoContinuar);
        botaoContinuar.setPreferredSize(new Dimension(200 , 25));
        botaoContinuar.setMinimumSize(new Dimension(200 , 25));
        botaoContinuar.setMaximumSize(new Dimension(200 , 25));
        botaoContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        botaoContinuar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (textField.getText().isEmpty())
                {
                    labelCampoVazio.setVisible(true);
                }
                else if (ValidadorCpfECnpj.validar(textField.getText() , opcao))
                {
                    switch (opcao)
                    {
                        case 0:
                            getParent().add(new PainelCadastroClientePF(textField.getText() , painelPai));
                            setVisible(false);
                            break;
                                
                        case 1:
                            getParent().add(new PainelCadastroClientePJ(textField.getText() , painelPai));
                            setVisible(false);
                            break;
                    }
                }
            }
        });
        
        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new HomeClientes(painelPai));
                setVisible(false);
            }
        });
    }
}