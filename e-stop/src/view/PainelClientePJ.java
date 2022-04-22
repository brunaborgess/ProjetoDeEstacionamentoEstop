package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GerenciadorClientes;
import controller.Principal;
import controller.ValidadorCampos;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.DAO.PessoaFisicaDAO;
import model.DAO.PessoaJuridicaDAO;

import java.awt.Color;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class PainelClientePJ extends JPanel
{    
    JFormattedTextField textFieldCep;
    PessoaJuridica pessoa;
    
    public PainelClientePJ(JPanel painelPai , PessoaJuridica pessoaPesquisada)
    {
        pessoa = pessoaPesquisada;
        
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        JLabel labelRazaoSocial = new JLabel("Razão Social");
        labelRazaoSocial.setPreferredSize(new Dimension(200 , 25));
        labelRazaoSocial.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldRazaoSocial = new JTextField(pessoa.getRazaoSocial());
        textFieldRazaoSocial.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldRazaoSocial.setPreferredSize(new Dimension(200 , 25));
        textFieldRazaoSocial.setBounds(0 , 0 , 200 , 25);
        textFieldRazaoSocial.setEnabled(false);
        textFieldRazaoSocial.setDisabledTextColor(Color.BLACK);

        JPanel painelRazaoSocial = new JPanel();
        painelRazaoSocial.setLayout(new BoxLayout(painelRazaoSocial , BoxLayout.PAGE_AXIS));
        painelRazaoSocial.setPreferredSize(new Dimension(200 , 50));
        painelRazaoSocial.setBounds(118 , 93 , 200 , 50);

        painelRazaoSocial.add(labelRazaoSocial);
        painelRazaoSocial.add(textFieldRazaoSocial);

        //////////////////////////////

        JLabel labelCnpj = new JLabel("CNPJ");
        labelCnpj.setPreferredSize(new Dimension(200 , 25));
        labelCnpj.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldCnpj = new JTextField(pessoa.getCnpj());
        textFieldCnpj.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldCnpj.setPreferredSize(new Dimension(200 , 25));
        textFieldCnpj.setBounds(0 , 0 , 200 , 25);
        textFieldCnpj.setEnabled(false);

        JPanel painelCnpj = new JPanel();
        painelCnpj.setLayout(new BoxLayout(painelCnpj , BoxLayout.PAGE_AXIS));
        painelCnpj.setPreferredSize(new Dimension(200 , 50));
        painelCnpj.setBounds(118 , 154 , 200 , 50);

        painelCnpj.add(labelCnpj);
        painelCnpj.add(textFieldCnpj);

        ////////////////////////////////////////////////////////////////

        JLabel labelTelefonePri = new JLabel("Telefone Principal");
        labelTelefonePri.setPreferredSize(new Dimension(200 , 25));
        labelTelefonePri.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldTelefonePri = new JTextField(pessoa.getCliente().getTelefone1());
        textFieldTelefonePri.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldTelefonePri.setPreferredSize(new Dimension(200 , 25));
        textFieldTelefonePri.setBounds(0 , 0 , 200 , 25);
        textFieldTelefonePri.setEnabled(false);

        JPanel painelTelefonePri = new JPanel();
        painelTelefonePri.setLayout(new BoxLayout(painelTelefonePri , BoxLayout.PAGE_AXIS));
        painelTelefonePri.setPreferredSize(new Dimension(200 , 50));
        painelTelefonePri.setBounds(118 , 215 , 200 , 50);

        painelTelefonePri.add(labelTelefonePri);
        painelTelefonePri.add(textFieldTelefonePri);

        //////////////////////////////////////////////////////////////////

        JLabel labelTelefoneSec = new JLabel("Telefone Secundário");
        labelTelefoneSec.setPreferredSize(new Dimension(200 , 25));
        labelTelefoneSec.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldTelefoneSec = new JTextField(pessoa.getCliente().getTelefone2());
        textFieldTelefoneSec.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldTelefoneSec.setPreferredSize(new Dimension(200 , 25));
        textFieldTelefoneSec.setBounds(0 , 0 , 200 , 25);
        textFieldTelefoneSec.setEnabled(false);

        JPanel painelTelefoneSec = new JPanel();
        painelTelefoneSec.setLayout(new BoxLayout(painelTelefoneSec , BoxLayout.PAGE_AXIS));
        painelTelefoneSec.setPreferredSize(new Dimension(200 , 50));
        painelTelefoneSec.setBounds(118 , 276 , 200 , 50);

        painelTelefoneSec.add(labelTelefoneSec);
        painelTelefoneSec.add(textFieldTelefoneSec);

        ///////////////////////////////////////////////////////////////////

        JLabel labelLogradouro = new JLabel("Logradouro");
        labelLogradouro.setPreferredSize(new Dimension(200 , 25));
        labelLogradouro.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldLogradouro = new JTextField(pessoa.getCliente().getLogradouro());
        textFieldLogradouro.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldLogradouro.setPreferredSize(new Dimension(200 , 25));
        textFieldLogradouro.setBounds(0 , 0 , 200 , 25);
        textFieldLogradouro.setEnabled(false);

        JPanel painelLogradouro = new JPanel();
        painelLogradouro.setLayout(new BoxLayout(painelLogradouro , BoxLayout.PAGE_AXIS));
        painelLogradouro.setPreferredSize(new Dimension(200 , 50));
        painelLogradouro.setBounds(418 , 93 , 200 , 50);

        painelLogradouro.add(labelLogradouro);
        painelLogradouro.add(textFieldLogradouro);
        
        JLabel labelComplemento = new JLabel("Complemento");
        labelComplemento.setPreferredSize(new Dimension(200, 25));
        labelComplemento.setBounds(445, 11, 110, 25);
        
        JTextField textFieldComplemento = new JTextField(pessoa.getCliente().getComplemento());
        textFieldComplemento.setPreferredSize(new Dimension(200, 25));
        textFieldComplemento.setEnabled(false);
        textFieldComplemento.setDisabledTextColor(Color.BLACK);
        textFieldComplemento.setAlignmentX(0.0f);
        textFieldComplemento.setBounds(391, 31, 200, 25);
        
        JPanel painelComplemento = new JPanel();
        painelComplemento.setLayout(new BoxLayout(painelComplemento , BoxLayout.PAGE_AXIS));
        painelComplemento.setPreferredSize(new Dimension(200 , 50));
        painelComplemento.setBounds(418 , 154 , 200 , 50);

        painelComplemento.add(labelComplemento);
        painelComplemento.add(textFieldComplemento);

        ///////////////////////////////////////////////////////////////////////////////

        JLabel labelBairro = new JLabel("Bairro");
        labelBairro.setPreferredSize(new Dimension(200 , 25));
        labelBairro.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldBairro = new JTextField(pessoa.getCliente().getBairro());
        textFieldBairro.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldBairro.setEnabled(false);
        textFieldBairro.setPreferredSize(new Dimension(200 , 25));
        textFieldBairro.setBounds(0 , 0 , 200 , 25);

        JPanel painelBairro = new JPanel();
        painelBairro.setLayout(new BoxLayout(painelBairro , BoxLayout.PAGE_AXIS));
        painelBairro.setPreferredSize(new Dimension(200 , 50));
        painelBairro.setBounds(418 , 215 , 200 , 50);

        painelBairro.add(labelBairro);
        painelBairro.add(textFieldBairro);

        //////////////////////////////////////////////////////////////////////////////////

        JLabel labelCidade = new JLabel("Cidade");
        labelCidade.setPreferredSize(new Dimension(200 , 25));
        labelCidade.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldCidade = new JTextField(pessoa.getCliente().getCidade());
        textFieldCidade.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldCidade.setPreferredSize(new Dimension(200 , 25));
        textFieldCidade.setBounds(0 , 0 , 200 , 25);
        textFieldCidade.setEnabled(false);

        JPanel painelCidade = new JPanel();
        painelCidade.setLayout(new BoxLayout(painelCidade , BoxLayout.PAGE_AXIS));
        painelCidade.setPreferredSize(new Dimension(200 , 50));
        painelCidade.setBounds(418 , 276 , 200 , 50);

        painelCidade.add(labelCidade);
        painelCidade.add(textFieldCidade);

        ///////////////////////////////////////////////////////////////////////////////////////

        JLabel labelCep = new JLabel("CEP");
        labelCep.setPreferredSize(new Dimension(200 , 25));
        labelCep.setBounds(0 , 0 , 200 , 25);

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
        
        textFieldCep.setText(pessoa.getCliente().getCep());
        textFieldCep.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldCep.setPreferredSize(new Dimension(200 , 25));
        textFieldCep.setBounds(0 , 0 , 200 , 25);
        textFieldCep.setEnabled(false);

        JPanel painelCep = new JPanel();
        painelCep.setLayout(new BoxLayout(painelCep , BoxLayout.PAGE_AXIS));
        painelCep.setPreferredSize(new Dimension(200 , 50));
        painelCep.setBounds(418 , 337 , 200 , 50);

        painelCep.add(labelCep);
        painelCep.add(textFieldCep);

        /////////////////////////////////////////////////////////////////////////////////////////

        JLabel labelNumero = new JLabel("Número");
        labelNumero.setPreferredSize(new Dimension(200 , 25));
        labelNumero.setBounds(0 , 0 , 80 , 25);

        JTextField textFieldNumero = new JTextField(Integer.toString(pessoa.getCliente().getNumero()));
        textFieldNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldNumero.setPreferredSize(new Dimension(200 , 25));
        textFieldNumero.setBounds(0 , 0 , 80 , 25);
        textFieldNumero.setEnabled(false);

        JPanel painelNumero = new JPanel();
        painelNumero.setLayout(new BoxLayout(painelNumero , BoxLayout.PAGE_AXIS));
        painelNumero.setPreferredSize(new Dimension(80 , 50));
        painelNumero.setBounds(628 , 93 , 80 , 50);

        painelNumero.add(labelNumero);
        painelNumero.add(textFieldNumero);

        ///////////////////////////////////////////////////////////////////////////

        JLabel labelUf = new JLabel("UF");
        labelUf.setPreferredSize(new Dimension(50 , 25));
        labelUf.setBounds(0 , 0 , 50 , 25);

        String[] estados = {"AC" , "AL" , "AM" , "AP" , "BA" , "CE" , "DF" , "ES" , "GO" , "MA" , "MG" , "MS" , "MT" ,
                            "PA" , "PB" , "PE" , "PI" , "PR" , "RJ" , "RN" , "RO" , "RR" , "RS" , "SC" , "SE"  , "SP" ,
                            "TO"};

        JComboBox comboBoxUf = new JComboBox(estados);
        comboBoxUf.setSelectedItem(pessoa.getCliente().getUf());
        comboBoxUf.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBoxUf.setPreferredSize(new Dimension(50 , 25));
        comboBoxUf.setBounds(0 , 0 , 50 , 25);
        comboBoxUf.setEnabled(false);

        JPanel painelUf = new JPanel();
        painelUf.setLayout(new BoxLayout(painelUf , BoxLayout.PAGE_AXIS));
        painelUf.setPreferredSize(new Dimension(200 , 50));
        painelUf.setBounds(628 , 276 , 85 , 50);

        painelUf.add(labelUf);
        painelUf.add(comboBoxUf);

        //////////////////////////////////////////////////////////////////////

        JLabel labelEmail = new JLabel("Endereço de e-mail");
        labelEmail.setPreferredSize(new Dimension(200 , 25));
        labelEmail.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldEmail = new JTextField(pessoa.getCliente().getEmail());
        textFieldEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldEmail.setPreferredSize(new Dimension(200 , 25));
        textFieldEmail.setBounds(0 , 0 , 200 , 25);
        textFieldEmail.setEnabled(false);

        JPanel painelEmail = new JPanel();
        painelEmail.setLayout(new BoxLayout(painelEmail , BoxLayout.PAGE_AXIS));
        painelEmail.setPreferredSize(new Dimension(200 , 50));
        painelEmail.setBounds(118 , 337 , 200 , 50);

        painelEmail.add(labelEmail);
        painelEmail.add(textFieldEmail);

        ///////////////////////////////////////////////////////////////////
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200 , 25));
        botaoVoltar.setBounds(118 , 445 , 200 , 25);
        
        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelPesquisaCliente(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoVoltar);
        
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setVisible(false);
        botaoCancelar.setPreferredSize(new Dimension(200 , 25));
        botaoCancelar.setBounds(118 , 445 , 200 , 25);
        
        add(botaoCancelar);
        
        JButton botaoAtualizar = new JButton("Atualizar Informações");
        botaoAtualizar.setPreferredSize(new Dimension(200 , 25));
        botaoAtualizar.setBounds(418 , 445 , 200 , 25);
        
        JButton botaoConfirmar = new JButton("Confirmar Alterações");
        botaoConfirmar.setVisible(false);
        botaoConfirmar.setPreferredSize(new Dimension(200 , 25));
        botaoConfirmar.setBounds(418 , 445 , 200 , 25);
        
        botaoAtualizar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textFieldTelefonePri.setEnabled(true);
                textFieldTelefoneSec.setEnabled(true);
                textFieldEmail.setEnabled(true);
                textFieldLogradouro.setEnabled(true);
                textFieldBairro.setEnabled(true);
                textFieldCidade.setEnabled(true);
                textFieldCep.setEnabled(true);
                textFieldComplemento.setEnabled(true);
                textFieldNumero.setEnabled(true);
                comboBoxUf.setEnabled(true);
                
                botaoCancelar.setVisible(true);
                botaoConfirmar.setVisible(true);
                botaoVoltar.setVisible(false);
                botaoAtualizar.setVisible(false);
            }
        });
        
        add(botaoAtualizar);
        
        String[] camposAChecar = {textFieldRazaoSocial.getText() , textFieldTelefonePri.getText() , textFieldLogradouro.getText() ,
                        textFieldBairro.getText() , textFieldCidade.getText() , textFieldCep.getText() ,
                        textFieldNumero.getText()};
        
        
        
        botaoConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] camposAChecar = {textFieldRazaoSocial.getText() , textFieldTelefonePri.getText() , textFieldLogradouro.getText() ,
                            textFieldBairro.getText() , textFieldCidade.getText() , textFieldCep.getText() ,
                            textFieldNumero.getText()};
                
                if (! ValidadorCampos.checarSeHaVazio(camposAChecar))
                {
                    int opcao = JOptionPane.showConfirmDialog(null , "Deseja realmente confirmar as alterações?");
                    
                    switch (opcao)
                    {
                        case JOptionPane.YES_OPTION:
                            GerenciadorClientes.alterarPessoaJuridica(pessoa.getCliente().getIdCliente() , textFieldTelefonePri.getText() , textFieldTelefoneSec.getText() , textFieldEmail.getText() ,
                                            textFieldLogradouro.getText() , Integer.parseInt(textFieldNumero.getText()) , textFieldComplemento.getText() , textFieldBairro.getText() ,
                                            textFieldCidade.getText() , (String)comboBoxUf.getSelectedItem() , textFieldCep.getText() , 
                                            textFieldRazaoSocial.getText() , textFieldCnpj.getText());
                            
                            textFieldRazaoSocial.setEnabled(false);
                            textFieldTelefonePri.setEnabled(false);
                            textFieldTelefoneSec.setEnabled(false);
                            textFieldEmail.setEnabled(false);
                            textFieldLogradouro.setEnabled(false);
                            textFieldBairro.setEnabled(false);
                            textFieldCidade.setEnabled(false);
                            textFieldComplemento.setEnabled(false);
                            textFieldCep.setEnabled(false);
                            textFieldNumero.setEnabled(false);
                            comboBoxUf.setEnabled(false);
                            
                            botaoVoltar.setVisible(true);
                            botaoAtualizar.setVisible(true);
                            botaoConfirmar.setVisible(false);
                            botaoCancelar.setVisible(false);
                            
                            break;
                    }
                }
                else
                    new TelaAvisoGenerica("Há campos necessários que não foram preenchidos!");
            }
        });
        
        add(botaoConfirmar);
        
        //////////////////////////////////////////////////////////////////////
        
        botaoCancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pessoa = PessoaJuridicaDAO.buscarPorCnpj(pessoaPesquisada.getCnpj());
                
                textFieldRazaoSocial.setEnabled(false);
                textFieldTelefonePri.setEnabled(false);
                textFieldTelefoneSec.setEnabled(false);
                textFieldEmail.setEnabled(false);
                textFieldLogradouro.setEnabled(false);
                textFieldBairro.setEnabled(false);
                textFieldCidade.setEnabled(false);
                textFieldCep.setEnabled(false);
                textFieldNumero.setEnabled(false);
                textFieldComplemento.setEnabled(false);
                comboBoxUf.setEnabled(false);
                
                textFieldRazaoSocial.setText(pessoa.getRazaoSocial());
                textFieldTelefonePri.setText(pessoa.getCliente().getTelefone1());
                textFieldTelefoneSec.setText(pessoa.getCliente().getTelefone2());
                textFieldEmail.setText(pessoa.getCliente().getEmail());
                textFieldLogradouro.setText(pessoa.getCliente().getLogradouro());
                textFieldBairro.setText(pessoa.getCliente().getBairro());
                textFieldCidade.setText(pessoa.getCliente().getCidade());
                textFieldCep.setText(pessoa.getCliente().getCep());
                textFieldComplemento.setText(pessoa.getCliente().getComplemento());
                textFieldNumero.setText(Integer.toString(pessoa.getCliente().getNumero()));
                comboBoxUf.setSelectedItem(pessoa.getCliente().getUf());
                
                botaoCancelar.setVisible(false);
                botaoConfirmar.setVisible(false);
                botaoAtualizar.setVisible(true);
                botaoVoltar.setVisible(true);
            }
        });
        
        JPanel painelAtual = this;
        
        JButton botaoAssinatura = new JButton("Assinatura");
        botaoAssinatura.setBounds(118, 42, 200, 25);
        
        botaoAssinatura.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelAssinaturas(painelPai , painelAtual , pessoa.getCliente()));
                setVisible(false);
                
            }
        });
        
        textFieldRazaoSocial.setDisabledTextColor(Color.BLACK);
        textFieldCnpj.setDisabledTextColor(Color.BLACK);
        textFieldTelefonePri.setDisabledTextColor(Color.BLACK);
        textFieldTelefoneSec.setDisabledTextColor(Color.BLACK);
        textFieldEmail.setDisabledTextColor(Color.BLACK);
        textFieldLogradouro.setDisabledTextColor(Color.BLACK);
        textFieldBairro.setDisabledTextColor(Color.BLACK);
        textFieldCidade.setDisabledTextColor(Color.BLACK);
        textFieldCep.setDisabledTextColor(Color.BLACK);
        textFieldNumero.setDisabledTextColor(Color.BLACK);
        textFieldComplemento.setDisabledTextColor(Color.BLACK);
        
        comboBoxUf.setRenderer(new DefaultListCellRenderer()
                        {
            @Override
            public void paint(Graphics g)
            {
            setForeground(Color.BLACK);
            super.paint(g);
                        }
    });
        
        add(painelComplemento);
        add(painelRazaoSocial);
        add(painelCnpj);
        add(painelTelefonePri);
        add(painelTelefoneSec);
        add(painelEmail);
        add(painelLogradouro);
        add(painelBairro);
        add(painelCidade);
        add(painelCep);
        add(painelNumero);
        add(painelUf);
        add(botaoAssinatura);
    }
}