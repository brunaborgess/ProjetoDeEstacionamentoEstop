package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Preco;
import model.DAO.PrecoDAO;
import view.TableModel.TableModelPreco;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Principal;

import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Component;

public class PainelPrecos extends JPanel
{
    
    // Somente acessivel atraves da classe AbaGerencia
    public PainelPrecos(JPanel painelPai)
    {
        DecimalFormat decimal = new DecimalFormat("0.00");
        
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        Preco tabelaAtual = PrecoDAO.buscarUltimoRegistro();
        
        JButton botaoAlterar = new JButton("Alterar Preços");
        botaoAlterar.setBounds(441 , 400 , 200 , 25);
        
        botaoAlterar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelPrecificacao(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoAlterar);
        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(142 , 400 , 200 , 25);
        add(botaoVoltar);
        
        JPanel painelUmaHora = new JPanel();
        painelUmaHora.setBounds(142, 86, 200, 50);
        add(painelUmaHora);
        painelUmaHora.setLayout(new BoxLayout(painelUmaHora, BoxLayout.PAGE_AXIS));
        
        JLabel labelUmaHora = new JLabel("At\u00E9 uma hora (em R$)");
        labelUmaHora.setPreferredSize(new Dimension(200 , 25));
        painelUmaHora.add(labelUmaHora);
        
        JTextField textFieldUmaHora = new JTextField(decimal.format(tabelaAtual.getAteUmaHora()).replace("." , ","));
        textFieldUmaHora.setEnabled(false);
        textFieldUmaHora.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelUmaHora.add(textFieldUmaHora);
        textFieldUmaHora.setColumns(10);
        textFieldUmaHora.setDisabledTextColor(Color.BLACK);
        
        JPanel painelAteDuas = new JPanel();
        painelAteDuas.setBounds(142, 178, 200, 50);
        add(painelAteDuas);
        painelAteDuas.setLayout(new BoxLayout(painelAteDuas, BoxLayout.PAGE_AXIS));
        
        JLabel labelDuasHoras = new JLabel("At\u00E9 duas horas (em R$)");
        labelDuasHoras.setPreferredSize(new Dimension(200 , 25));
        painelAteDuas.add(labelDuasHoras);
        
        JTextField textFieldAteDuasHoras = new JTextField(decimal.format(tabelaAtual.getAteDuasHoras()).replace("." , ","));
        textFieldAteDuasHoras.setEnabled(false);
        textFieldAteDuasHoras.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelAteDuas.add(textFieldAteDuasHoras);
        textFieldAteDuasHoras.setDisabledTextColor(Color.BLACK);
        textFieldAteDuasHoras.setColumns(10);
        
        JPanel painelAposTres = new JPanel();
        painelAposTres.setBounds(441, 86, 200, 50);
        add(painelAposTres);
        painelAposTres.setLayout(new BoxLayout(painelAposTres, BoxLayout.PAGE_AXIS));
        
        JLabel labelAposTres = new JLabel("Ap\u00F3s tr\u00EAs horas/di\u00E1ria (em R$)");
        labelAposTres.setPreferredSize(new Dimension(200 , 25));
        painelAposTres.add(labelAposTres);
        
        JTextField textFieldAposTresHoras = new JTextField(decimal.format(tabelaAtual.getAposTresHoras()).replace("." , ","));
        textFieldAposTresHoras.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldAposTresHoras.setEnabled(false);
        painelAposTres.add(textFieldAposTresHoras);
        textFieldAposTresHoras.setColumns(10);
        textFieldAposTresHoras.setDisabledTextColor(Color.BLACK);
        
        JPanel painelTresHoras = new JPanel();
        painelTresHoras.setBounds(142, 257, 200, 50);
        add(painelTresHoras);
        painelTresHoras.setLayout(new BoxLayout(painelTresHoras, BoxLayout.PAGE_AXIS));
        
        JLabel labelAteTres = new JLabel("At\u00E9 tr\u00EAs horas (em R$)");
        labelAteTres.setPreferredSize(new Dimension(200 , 25));
        painelTresHoras.add(labelAteTres);
        
        JTextField textFieldAteTresHoras = new JTextField(decimal.format(tabelaAtual.getAteTresHoras()).replace("." , ","));
        textFieldAteTresHoras.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldAteTresHoras.setEnabled(false);
        painelTresHoras.add(textFieldAteTresHoras);
        textFieldAteTresHoras.setColumns(10);
        textFieldAteTresHoras.setDisabledTextColor(Color.BLACK);
        
        JPanel painelPernoite = new JPanel();
        painelPernoite.setBounds(441, 178, 200, 50);
        add(painelPernoite);
        painelPernoite.setLayout(new BoxLayout(painelPernoite, BoxLayout.PAGE_AXIS));
        
        JLabel labelPernoite = new JLabel("Pernoite (em R$)");
        labelPernoite.setPreferredSize(new Dimension(200 , 25));
        painelPernoite.add(labelPernoite);
        
        JTextField textFieldPernoite = new JTextField(decimal.format(tabelaAtual.getPernoite()).replace("." , ","));
        textFieldPernoite.setPreferredSize(new Dimension(200, 25));
        textFieldPernoite.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldPernoite.setEnabled(false);
        textFieldPernoite.setDisabledTextColor(Color.BLACK);
        painelPernoite.add(textFieldPernoite);
        
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