package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

import controller.GerenciadorRotativo;
import controller.Principal;
import model.DAO.RotativoDAO;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class PainelEntradaVeiculo extends JPanel
{
    JFormattedTextField textFieldPlaca = new JFormattedTextField();
    JComboBox comboBoxTipo = new JComboBox();
    JComboBox comboBoxNumero = new JComboBox();
    
    public PainelEntradaVeiculo(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        JLabel labelPlaca = new JLabel("Placa do Veículo");
        labelPlaca.setPreferredSize(new Dimension(200 , 25));
        labelPlaca.setBounds(0 , 0 , 200 , 25);
        
        textFieldPlaca.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldPlaca.setPreferredSize(new Dimension(200 , 25));
        textFieldPlaca.setBounds(0 , 0 , 200 , 25);
        
        try
        {
            MaskFormatter mascaraPlaca = new MaskFormatter("UUU####");
            
            textFieldPlaca = new JFormattedTextField(mascaraPlaca);
            textFieldPlaca.setAlignmentX(Component.LEFT_ALIGNMENT);
        }
        catch (Exception e)
        {
            
        }
        
        JPanel painelPlaca = new JPanel();
        painelPlaca.setLayout(new BoxLayout(painelPlaca , BoxLayout.PAGE_AXIS));
        painelPlaca.setPreferredSize(new Dimension(200 , 50));
        painelPlaca.setBounds(133 , 110 , 200 , 50);
        
        painelPlaca.add(labelPlaca);
        painelPlaca.add(textFieldPlaca);
        
        //////////////////////////////////////////////////////////////////////////////
        
        JLabel labelDescricao = new JLabel("Descrição do Veículo");
        labelDescricao.setPreferredSize(new Dimension(200 , 25));
        labelDescricao.setBounds(0 , 0 , 200 , 25);
        
        JTextField textFieldDescricao = new JTextField();
        textFieldDescricao.setPreferredSize(new Dimension(200 , 25));
        textFieldDescricao.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldDescricao.setBounds(0 , 0 , 200 , 25);
        
        JPanel painelDescricao = new JPanel();
        painelDescricao.setLayout(new BoxLayout(painelDescricao , BoxLayout.PAGE_AXIS));
        painelDescricao.setBounds(133 , 240 , 200 , 50);
        
        painelDescricao.add(labelDescricao);
        painelDescricao.add(textFieldDescricao);
        
        ////////////////////////////////////////////////////////////////////////////////
        
        JLabel labelTipo = new JLabel("Tipo de Veículo");
        labelTipo.setPreferredSize(new Dimension(200 , 25));
        labelTipo.setBounds(0 , 0 , 200 , 25);
        
        comboBoxTipo = new JComboBox(GerenciadorRotativo.buscarTiposDeVeiculo());
        comboBoxTipo.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBoxTipo.setPreferredSize(new Dimension(100 , 25));
        comboBoxTipo.setBounds(0 , 0 , 100 , 25);
        
        JPanel painelTipo = new JPanel();
        painelTipo.setLayout(new BoxLayout(painelTipo , BoxLayout.PAGE_AXIS));
        painelTipo.setPreferredSize(new Dimension(200 , 50));
        painelTipo.setBounds(466 , 110 , 200 , 50);
        
        painelTipo.add(labelTipo);
        painelTipo.add(comboBoxTipo);
        
        //////////////////////////////////////////////////////////////////////////////////
        
        JLabel labelNumero = new JLabel("Número da Vaga");
        labelNumero.setPreferredSize(new Dimension(200 , 25));
        labelNumero.setBounds(0 , 0 , 200 , 25);
        
        String[] vagas = GerenciadorRotativo.buscarVagasLivres((String) comboBoxTipo.getSelectedItem());
        
        comboBoxNumero = new JComboBox(vagas);
        comboBoxNumero.setPreferredSize(new Dimension(50 , 25));
        comboBoxNumero.setBounds(0 , 0 , 50 , 25);
        comboBoxNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JPanel painelNumero = new JPanel();
        painelNumero.setLayout(new BoxLayout(painelNumero , BoxLayout.PAGE_AXIS));
        painelNumero.setPreferredSize(new Dimension(200 , 50));
        painelNumero.setBounds(466 , 240 , 200 , 50);
        
        painelNumero.add(labelNumero);
        painelNumero.add(comboBoxNumero);
        
        ///////////////////////////////////////////////////////////////////////////
        
        JButton botaoRegistrar = new JButton("Registrar");
        botaoRegistrar.setPreferredSize(new Dimension(200 , 25));
        botaoRegistrar.setBounds(466 , 364 , 200 , 25);
        
        botaoRegistrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (! textFieldPlaca.getText().trim().equals("") || ! textFieldDescricao.getText().trim().equals(""))
                {
                    if (RotativoDAO.buscarPorPlaca(textFieldPlaca.getText()) == null)
                    {
                    GerenciadorRotativo.registrarEntrada((String) comboBoxNumero.getSelectedItem() ,
                                                         textFieldDescricao.getText() , textFieldPlaca.getText());
                    new TelaAvisoGenerica("Registro efetuado com sucesso!");
                    painelPai.add(new HomeRotativo(painelPai));
                    setVisible(false);
                    }
                    else
                        new TelaAvisoGenerica("Já há um veículo com esta mesma placa estacionado.");
                }
                else
                    new TelaAvisoGenerica("Há campos obrigatórios que não foram preenchidos!");
            }
        });
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200 , 25));
        botaoVoltar.setBounds(133 , 364 , 200 , 25);
        
        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new HomeRotativo(painelPai));
                setVisible(false);
            }
        });
        
        ////////////////////////////////////////////////////////////////////////////////
        
        comboBoxTipo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                alterarComboBox();
            }
        });
        
        ////////////////////////////////////////////////////////////////////////////////
        
        add(painelPlaca);
        add(painelDescricao);
        add(painelTipo);
        add(painelNumero);
        add(botaoVoltar);
        add(botaoRegistrar);
        
    }
    
    public void alterarComboBox()
    {
        String[] vagas = GerenciadorRotativo.buscarVagasLivres((String) comboBoxTipo.getSelectedItem());
        
        comboBoxNumero.removeAllItems();
        
        for (int i = 0 ; i < vagas.length ; i ++ )
        {
            comboBoxNumero.addItem(vagas[i]); 
        }
    }
}