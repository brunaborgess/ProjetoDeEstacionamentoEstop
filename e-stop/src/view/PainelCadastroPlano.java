package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.Principal;
import model.DAO.PlanoDAO;

import javax.swing.BoxLayout;
import java.awt.Component;

public class PainelCadastroPlano extends JPanel
{
    private JTextField textFieldNome;

    private JFormattedTextField textFieldValor = new JFormattedTextField();

    public PainelCadastroPlano(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
//
//        try
//        {
//            MaskFormatter mascara = new MaskFormatter("###.###,##");
//
//            textFieldValor = new JFormattedTextField(mascara);
//        }
//        catch (Exception e)
//        {
//
//        }

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(122 , 419 , 200 , 25);
        add(botaoVoltar);

        JPanel painelNome = new JPanel();
        painelNome.setBounds(122 , 186 , 200 , 50);
        add(painelNome);
        painelNome.setLayout(new BoxLayout(painelNome , BoxLayout.PAGE_AXIS));

        JLabel labelNome = new JLabel("Nome do Plano");
        labelNome.setPreferredSize(new Dimension(200 , 25));
        painelNome.add(labelNome);

        textFieldNome = new JTextField();
        textFieldNome.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelNome.add(textFieldNome);
        textFieldNome.setColumns(10);

        JPanel painelValor = new JPanel();
        painelValor.setBounds(469 , 186 , 200 , 50);
        add(painelValor);
        painelValor.setLayout(new BoxLayout(painelValor , BoxLayout.PAGE_AXIS));

        JLabel labelValor = new JLabel("Valor Base (em R$)");
        labelValor.setPreferredSize(new Dimension(200 , 25));
        painelValor.add(labelValor);
        labelValor.setPreferredSize(new Dimension(200 , 25));

        painelValor.add(textFieldValor);
        textFieldValor.setColumns(10);
        textFieldValor.setAlignmentX(0.0f);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelPlanos(painelPai));
                setVisible(false);
            }
        });

        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int opcao = JOptionPane.showConfirmDialog(null , "Deseja realmente cadastrar este plano?" ,
                                "Selecione uma opção" , JOptionPane.YES_NO_OPTION);

                switch (opcao)
                {
                    case JOptionPane.YES_OPTION :
                        String valor = textFieldValor.getText().replace("." , "").replace("," , ".");

                        if (PlanoDAO.inserir(textFieldNome.getText() , Double.parseDouble(valor)) != null)
                        {
                            new TelaAvisoGenerica("Novo plano cadastrado com sucesso!");
                            painelPai.add(new PainelPlanos(painelPai));
                            setVisible(false);
                        }
                        else
                            new TelaAvisoGenerica("Falha ao cadastrar.");
                        
                        break;
                }
            }
        });
        botaoConfirmar.setBounds(469 , 419 , 200 , 25);

        add(botaoConfirmar);
    }
}