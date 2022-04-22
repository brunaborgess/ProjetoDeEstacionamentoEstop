package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModel.TableModelPlanos;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Preco;
import model.DAO.PrecoDAO;

import java.awt.Color;
import java.awt.Component;

public class PainelTabelaPrecos extends JPanel
{
    JTable tabelaPlanos;
    private Preco preco;
    private JTextField textFieldAteUmaHora;
    private JTextField textFieldAteDuasHoras;
    private JTextField textFieldAteTresHoras;
    private JTextField textFieldAposTresHoras;
    private JTextField textFieldPernoite;
    
    public PainelTabelaPrecos()
    {
        DecimalFormat decimal = new DecimalFormat("0.00");
        
        preco = PrecoDAO.buscarUltimoRegistro();
        
        JPanel painelUmaHora = new JPanel();
        painelUmaHora.setLayout(new BoxLayout(painelUmaHora , BoxLayout.PAGE_AXIS));
        painelUmaHora.setPreferredSize(new Dimension(200 , 50));
        painelUmaHora.setBounds(60 , 358 , 200 , 50);
        
        JPanel painelDuasHoras = new JPanel();
        painelDuasHoras.setLayout(new BoxLayout(painelDuasHoras , BoxLayout.PAGE_AXIS));
        painelDuasHoras.setPreferredSize(new Dimension(200 , 50));
        painelDuasHoras.setBounds(300 , 358 , 200 , 50);
        
        JPanel painelTresHoras = new JPanel();
        painelTresHoras.setLayout(new BoxLayout(painelTresHoras, BoxLayout.PAGE_AXIS));
        painelTresHoras.setPreferredSize(new Dimension(200 , 50));
        painelTresHoras.setBounds(539 , 358 , 200 , 50);
        
        JPanel painelAposTresHoras = new JPanel();
        painelAposTresHoras.setLayout(new BoxLayout(painelAposTresHoras , BoxLayout.PAGE_AXIS));
        painelAposTresHoras.setPreferredSize(new Dimension(200 , 50));
        painelAposTresHoras.setBounds(60 , 431 , 200 , 50);
        
        JPanel painelPernoite = new JPanel();
        painelPernoite.setLayout(new BoxLayout(painelPernoite , BoxLayout.PAGE_AXIS));
        painelPernoite.setPreferredSize(new Dimension(200 , 50));
        painelPernoite.setBounds(300 , 431 , 200 , 50);
        
        add(painelUmaHora);
        
        JLabel lblAtUmaHora = new JLabel("At\u00E9 uma hora (em R$)");
        lblAtUmaHora.setPreferredSize(new Dimension(200 , 25));
        painelUmaHora.add(lblAtUmaHora);
                
        textFieldAteUmaHora = new JTextField(decimal.format(preco.getAteUmaHora()).replace("." , ","));
        textFieldAteUmaHora.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelUmaHora.add(textFieldAteUmaHora);
        textFieldAteUmaHora.setEnabled(false);
        textFieldAteUmaHora.setColumns(10);
        textFieldAteUmaHora.setDisabledTextColor(Color.BLACK);
        add(painelDuasHoras);
        
        JLabel label = new JLabel("At\u00E9 duas horas (em R$)");
        label.setPreferredSize(new Dimension(200 , 25));
        painelDuasHoras.add(label);
        
        textFieldAteDuasHoras = new JTextField(decimal.format(preco.getAteDuasHoras()).replace("." , ","));
        textFieldAteDuasHoras.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelDuasHoras.add(textFieldAteDuasHoras);
        textFieldAteDuasHoras.setEnabled(false);
        textFieldAteDuasHoras.setColumns(10);
        textFieldAteDuasHoras.setDisabledTextColor(Color.BLACK);
        add(painelTresHoras);
        
        JLabel label_1 = new JLabel("At\u00E9 tr\u00EAs horas (em R$)");
        label_1.setPreferredSize(new Dimension(200 , 25));
        painelTresHoras.add(label_1);
        
        textFieldAteTresHoras = new JTextField(decimal.format(preco.getAteTresHoras()).replace("." , ","));
        textFieldAteTresHoras.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelTresHoras.add(textFieldAteTresHoras);
        textFieldAteTresHoras.setEnabled(false);
        textFieldAteTresHoras.setColumns(10);
        textFieldAteTresHoras.setDisabledTextColor(Color.BLACK);
        add(painelAposTresHoras);
        
        JLabel label_2 = new JLabel("Ap\u00F3s tr\u00EAs horas (em R$)");
        label_2.setPreferredSize(new Dimension(200 , 25));
        painelAposTresHoras.add(label_2);
        
        textFieldAposTresHoras = new JTextField(decimal.format(preco.getAposTresHoras()).replace("." , ","));
        textFieldAposTresHoras.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelAposTresHoras.add(textFieldAposTresHoras);
        textFieldAposTresHoras.setEnabled(false);
        textFieldAposTresHoras.setColumns(10);
        textFieldAposTresHoras.setDisabledTextColor(Color.BLACK);
        add(painelPernoite);
        
        JLabel labelPernoite = new JLabel("Pernoite (em R$)");
        labelPernoite.setPreferredSize(new Dimension(200 , 25));
        painelPernoite.add(labelPernoite);
        
        textFieldPernoite = new JTextField(decimal.format(preco.getPernoite()).replace("." , ","));
        textFieldPernoite.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelPernoite.add(textFieldPernoite);
        textFieldPernoite.setEnabled(false);
        textFieldPernoite.setColumns(10);
        textFieldPernoite.setDisabledTextColor(Color.BLACK);
        
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        tabelaPlanos = new JTable(new TableModelPlanos());
        
        tabelaPlanos.setLocation(0, 101);
        
        tabelaPlanos.getTableHeader().setReorderingAllowed(false);
        tabelaPlanos.getTableHeader().setResizingAllowed(false);
        tabelaPlanos.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(60 , 63 , 680 , 225);
        scroll.setViewportView(tabelaPlanos);
        
        add(scroll);
        
        JButton botaoAtualizar = new JButton("Atualizar");
        botaoAtualizar.setPreferredSize(new Dimension(200 , 25));
        botaoAtualizar.setBounds(60 , 27 , 200 , 25);
        
        botaoAtualizar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tabelaPlanos.setModel(new TableModelPlanos());
                
                preco = PrecoDAO.buscarUltimoRegistro();
                
                textFieldAteUmaHora.setText(decimal.format(preco.getAteUmaHora()).replace("." , ","));
                textFieldAteDuasHoras.setText(decimal.format(preco.getAteDuasHoras()).replace("." , ","));
                textFieldAteTresHoras.setText(decimal.format(preco.getAteTresHoras()).replace("." , ","));
                textFieldAposTresHoras.setText(decimal.format(preco.getAposTresHoras()).replace("." , ","));
                textFieldPernoite.setText(decimal.format(preco.getPernoite()).replace("." , ","));
            }
        });
        
        add(botaoAtualizar);
    }
}