package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.GerenciadorClientes;
import controller.Principal;
import controller.ValidadorCampos;

public class PainelCadastroClientePF extends JPanel
{
    private JTextField textFieldCpf;
    private JTextField textFieldComplemento;
    private JTextField numero;
    private JComboBox uf;
    private JFormattedTextField textFieldCep , textFieldTelefonePri , textFieldTelefoneSec;

    public PainelCadastroClientePF(String cpf , JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        JPanel subPainel1 = new JPanel();
        subPainel1.setLayout(new BoxLayout(subPainel1 , BoxLayout.PAGE_AXIS));
        subPainel1.setBounds(132 , 96 , 200 , 250);

        JPanel subPainel2 = new JPanel();
        subPainel2.setLayout(new BoxLayout(subPainel2 , BoxLayout.PAGE_AXIS));
        subPainel2.setBounds(465 , 96 , 200 , 250);

        JLabel labelNome = new JLabel("Nome Completo" , SwingConstants.LEFT);
        labelNome.setPreferredSize(new Dimension(200 , 25));
        labelNome.setMinimumSize(new Dimension(200 , 25));
        labelNome.setMaximumSize(new Dimension(200 , 25));
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textFieldNome = new JTextField();
        textFieldNome.setPreferredSize(new Dimension(200 , 25));
        textFieldNome.setMinimumSize(new Dimension(200 , 25));
        textFieldNome.setMaximumSize(new Dimension(200 , 25));
        textFieldNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelCpf = new JLabel("CPF" , SwingConstants.LEFT);
        labelCpf.setPreferredSize(new Dimension(200 , 25));
        labelCpf.setMinimumSize(new Dimension(200 , 25));
        labelCpf.setMaximumSize(new Dimension(200 , 25));
        labelCpf.setAlignmentX(Component.CENTER_ALIGNMENT);

        subPainel1.add(labelCpf);

        textFieldCpf = new JTextField(cpf);
        textFieldCpf.setPreferredSize(new Dimension(200 , 25));
        textFieldCpf.setMinimumSize(new Dimension(200 , 25));
        textFieldCpf.setMaximumSize(new Dimension(200 , 25));
        textFieldCpf.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldCpf.setEnabled(false);

        subPainel1.add(textFieldCpf);
        subPainel1.add(labelNome);
        subPainel1.add(textFieldNome);

        JLabel labelTelefonePri = new JLabel("Telefone Principal" , SwingConstants.LEFT);
        labelTelefonePri.setPreferredSize(new Dimension(200 , 25));
        labelTelefonePri.setMinimumSize(new Dimension(200 , 25));
        labelTelefonePri.setMaximumSize(new Dimension(200 , 25));
        labelTelefonePri.setAlignmentX(Component.CENTER_ALIGNMENT);

        try
        {
            MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
            textFieldTelefonePri = new JFormattedTextField(mascaraTelefone);
            textFieldTelefonePri.setPreferredSize(new Dimension(200 , 25));
            textFieldTelefonePri.setMinimumSize(new Dimension(200 , 25));
            textFieldTelefonePri.setMaximumSize(new Dimension(200 , 25));
            textFieldTelefonePri.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch (ParseException e1)
        {
            
        }
        
        subPainel1.add(labelTelefonePri);
        subPainel1.add(textFieldTelefonePri);

        JLabel labelTelefoneSec = new JLabel("Telefone Secundário (opcional)" , SwingConstants.LEFT);
        labelTelefoneSec.setPreferredSize(new Dimension(200 , 25));
        labelTelefoneSec.setMinimumSize(new Dimension(200 , 25));
        labelTelefoneSec.setMaximumSize(new Dimension(200 , 25));
        labelTelefoneSec.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        try
        {
            MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
            textFieldTelefoneSec = new JFormattedTextField(mascaraTelefone);
            textFieldTelefoneSec.setPreferredSize(new Dimension(200 , 25));
            textFieldTelefoneSec.setMinimumSize(new Dimension(200 , 25));
            textFieldTelefoneSec.setMaximumSize(new Dimension(200 , 25));
            textFieldTelefoneSec.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch (ParseException e)
        {
            
        }

        subPainel1.add(labelTelefoneSec);
        subPainel1.add(textFieldTelefoneSec);

        JLabel labelEmail = new JLabel("Endereço de e-mail (opcional)" , SwingConstants.LEFT);
        labelEmail.setPreferredSize(new Dimension(200 , 25));
        labelEmail.setMinimumSize(new Dimension(200 , 25));
        labelEmail.setMaximumSize(new Dimension(200 , 25));
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textFieldEmail = new JTextField();
        textFieldEmail.setPreferredSize(new Dimension(200 , 25));
        textFieldEmail.setMinimumSize(new Dimension(200 , 25));
        textFieldEmail.setMaximumSize(new Dimension(200 , 25));
        textFieldEmail.setAlignmentX(Component.CENTER_ALIGNMENT);

        subPainel1.add(labelEmail);
        subPainel1.add(textFieldEmail);

        JLabel labelLogradouro = new JLabel("Logradouro" , SwingConstants.LEFT);
        labelLogradouro.setPreferredSize(new Dimension(200 , 25));
        labelLogradouro.setMinimumSize(new Dimension(200 , 25));
        labelLogradouro.setMaximumSize(new Dimension(200 , 25));
        labelLogradouro.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textFieldLogradouro = new JTextField();
        textFieldLogradouro.setPreferredSize(new Dimension(200 , 25));
        textFieldLogradouro.setMinimumSize(new Dimension(200 , 25));
        textFieldLogradouro.setMaximumSize(new Dimension(200 , 25));
        textFieldLogradouro.setAlignmentX(Component.CENTER_ALIGNMENT);

        subPainel2.add(labelLogradouro);
        subPainel2.add(textFieldLogradouro);

        JLabel labelBairro = new JLabel("Bairro" , SwingConstants.LEFT);
        labelBairro.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelBairro.setPreferredSize(new Dimension(200 , 25));
        labelBairro.setMinimumSize(new Dimension(200 , 25));
        labelBairro.setMaximumSize(new Dimension(200 , 25));
        textFieldEmail.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textFieldBairro = new JTextField();
        textFieldBairro.setPreferredSize(new Dimension(200 , 25));
        textFieldBairro.setMinimumSize(new Dimension(200 , 25));
        textFieldBairro.setMaximumSize(new Dimension(200 , 25));
        textFieldEmail.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelComplemento = new JLabel("Complemento");
        labelComplemento.setPreferredSize(new Dimension(200 , 25));
        labelComplemento.setMinimumSize(new Dimension(200 , 25));
        labelComplemento.setMaximumSize(new Dimension(200 , 25));
        labelComplemento.setAlignmentX(Component.CENTER_ALIGNMENT);

        subPainel2.add(labelComplemento);

        textFieldComplemento = new JTextField();
        textFieldComplemento.setPreferredSize(new Dimension(200 , 25));
        textFieldComplemento.setMinimumSize(new Dimension(200 , 25));
        textFieldComplemento.setMaximumSize(new Dimension(200 , 25));
        textFieldComplemento.setAlignmentX(Component.CENTER_ALIGNMENT);
        subPainel2.add(textFieldComplemento);

        subPainel2.add(labelBairro);
        subPainel2.add(textFieldBairro);

        JLabel labelCidade = new JLabel("Cidade" , SwingConstants.LEFT);
        labelCidade.setPreferredSize(new Dimension(200 , 25));
        labelCidade.setMinimumSize(new Dimension(200 , 25));
        labelCidade.setMaximumSize(new Dimension(200 , 25));
        labelCidade.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textFieldCidade = new JTextField();
        textFieldCidade.setPreferredSize(new Dimension(200 , 25));
        textFieldCidade.setMinimumSize(new Dimension(200 , 25));
        textFieldCidade.setMaximumSize(new Dimension(200 , 25));
        textFieldCidade.setAlignmentX(Component.CENTER_ALIGNMENT);

        subPainel2.add(labelCidade);
        subPainel2.add(textFieldCidade);

        String[] estados = {"AC" , "AL" , "AM" , "AP" , "BA" , "CE" , "DF" , "ES" , "GO" , "MA" , "MG" , "MS" , "MT" ,
                        "PA" , "PB" , "PE" , "PI" , "PR" , "RJ" , "RN" , "RO" , "RR" , "RS" , "SC" , "SE" , "SP" ,
                        "TO"};

        JLabel labelCep = new JLabel("CEP" , SwingConstants.LEFT);
        labelCep.setPreferredSize(new Dimension(200 , 25));
        labelCep.setMinimumSize(new Dimension(200 , 25));
        labelCep.setMaximumSize(new Dimension(200 , 25));
        labelCep.setAlignmentX(Component.CENTER_ALIGNMENT);

        try
        {
            MaskFormatter mascaraCep = new MaskFormatter("#####-###");
            textFieldCep = new JFormattedTextField(mascaraCep);
            textFieldCep.setPreferredSize(new Dimension(200 , 25));
            textFieldCep.setMinimumSize(new Dimension(200 , 25));
            textFieldCep.setMaximumSize(new Dimension(200 , 25));
            textFieldCep.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        catch (ParseException e1)
        {
            
        }
        
        textFieldCep.setPreferredSize(new Dimension(200 , 25));
        textFieldCep.setMinimumSize(new Dimension(200 , 25));
        textFieldCep.setMaximumSize(new Dimension(200 , 25));
        textFieldCep.setAlignmentX(Component.CENTER_ALIGNMENT);

        subPainel2.add(labelCep);
        subPainel2.add(textFieldCep);

        add(subPainel1);
        add(subPainel2);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(132 , 382 , 200 , 25);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelCadastroCliente(painelPai));
                setVisible(false);
            }
        });

        JPanel painelAtual = this;

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(465 , 382 , 200 , 25);

        add(botaoVoltar);
        add(botaoCadastrar);

        JLabel labelNumero = new JLabel("Número" , SwingConstants.LEFT);
        labelNumero.setBounds(675 , 96 , 80 , 25);
        add(labelNumero);
        labelNumero.setPreferredSize(new Dimension(80 , 25));
        labelNumero.setMinimumSize(new Dimension(80 , 25));
        labelNumero.setMaximumSize(new Dimension(80 , 25));

        JTextField textFieldNumero = new JTextField();
        textFieldNumero.setBounds(675 , 121 , 80 , 25);
        add(textFieldNumero);
        textFieldNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldNumero.setPreferredSize(new Dimension(80 , 25));
        textFieldNumero.setMinimumSize(new Dimension(80 , 25));
        textFieldNumero.setMaximumSize(new Dimension(80 , 25));

        JLabel textFieldUf = new JLabel("UF" , SwingConstants.LEFT);
        textFieldUf.setBounds(675 , 246 , 80 , 25);
        add(textFieldUf);
        textFieldUf.setPreferredSize(new Dimension(80 , 25));
        textFieldUf.setMinimumSize(new Dimension(80 , 25));
        textFieldUf.setMaximumSize(new Dimension(80 , 25));

        JComboBox comboBoxUf = new JComboBox(estados);
        comboBoxUf.setBounds(675 , 271 , 50 , 25);
        add(comboBoxUf);
        comboBoxUf.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBoxUf.setPreferredSize(new Dimension(50 , 25));
        comboBoxUf.setMinimumSize(new Dimension(50 , 25));
        comboBoxUf.setMaximumSize(new Dimension(50 , 25));

        botaoCadastrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] camposAChecar = {textFieldNome.getText() , textFieldTelefonePri.getText() ,
                                textFieldLogradouro.getText() , textFieldBairro.getText() , textFieldCidade.getText() ,
                                textFieldCep.getText() , textFieldNumero.getText()};

                if (ValidadorCampos.checarSeHaVazio(camposAChecar))
                    new TelaAvisoGenerica("Há campos obrigatórios que não foram preenchidos.");
                else
                {
                    int opcao = JOptionPane.showConfirmDialog(null , "As informações inseridas estão corretas?" ,
                                    "Selecione uma opção" , JOptionPane.YES_NO_OPTION);

                    switch (opcao)
                    {
                        case JOptionPane.YES_OPTION :
                            String[] campos = {cpf , textFieldNome.getText() , textFieldTelefonePri.getText() ,
                                            textFieldTelefoneSec.getText() , textFieldEmail.getText() ,
                                            textFieldLogradouro.getText() , textFieldBairro.getText() ,
                                            textFieldCidade.getText() , (String) comboBoxUf.getSelectedItem() ,
                                            textFieldCep.getText() , textFieldNumero.getText() ,
                                            textFieldComplemento.getText()};

                            GerenciadorClientes.cadastrarPf(campos , painelPai , painelAtual);
                            break;

                        case JOptionPane.NO_OPTION :
                            new TelaAvisoGenerica("Revise as informações antes de continuar.");
                            break;
                    }
                }
            }
        });
    }
}