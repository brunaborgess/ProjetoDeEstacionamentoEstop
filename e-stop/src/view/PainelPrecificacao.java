package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

import controller.GerenciadorPrecos;

import javax.swing.BoxLayout;
import java.awt.Component;

public class PainelPrecificacao extends JPanel
{
    private JFormattedTextField textFieldUmaHora = new JFormattedTextField();
    private JFormattedTextField textFieldDuasHoras = new JFormattedTextField();
    private JFormattedTextField textFieldTresHoras = new JFormattedTextField();
    private JFormattedTextField textFieldPernoite = new JFormattedTextField();
    private JFormattedTextField textFieldAposTres = new JFormattedTextField();

    // Somente acessivel atraves da AbaGerencia
    public PainelPrecificacao(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

//        MaskFormatter mascara;

//        try
//        {
//            mascara = new MaskFormatter("###.###,##");
//
//            textFieldUmaHora = new JFormattedTextField(mascara);
//            textFieldUmaHora.setHorizontalAlignment(SwingConstants.LEFT);
//            textFieldDuasHoras = new JFormattedTextField(mascara);
//            textFieldTresHoras = new JFormattedTextField(mascara);
//            textFieldAposTres = new JFormattedTextField(mascara);
//            textFieldPernoite = new JFormattedTextField(mascara);
//        }
//        catch (ParseException e1)
//        {
//            e1.printStackTrace();
//        }

        JPanel painelUmaHora = new JPanel();
        painelUmaHora.setLayout(new BoxLayout(painelUmaHora , BoxLayout.PAGE_AXIS));
        painelUmaHora.setBounds(142 , 86 , 200 , 50);
        painelUmaHora.setPreferredSize(new Dimension(200 , 50));

        JLabel labelUmaHora = new JLabel("Até uma hora (em R$)");
        painelUmaHora.add(labelUmaHora);
        labelUmaHora.setBounds(0 , 0 , 200 , 25);
        labelUmaHora.setPreferredSize(new Dimension(200 , 25));

        textFieldUmaHora.setAlignmentX(Component.LEFT_ALIGNMENT);
        // textFieldUmaHora.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        painelUmaHora.add(textFieldUmaHora);
        textFieldUmaHora.setBounds(0 , 0 , 200 , 25);
        textFieldUmaHora.setPreferredSize(new Dimension(200 , 25));

        add(painelUmaHora);

        JPanel painelDuasHoras = new JPanel();
        painelDuasHoras.setBounds(142 , 178 , 200 , 50);
        add(painelDuasHoras);
        painelDuasHoras.setLayout(new BoxLayout(painelDuasHoras , BoxLayout.PAGE_AXIS));

        JLabel labelDuasHoras = new JLabel("Até duas horas (em R$)");
        labelDuasHoras.setPreferredSize(new Dimension(200 , 25));
        painelDuasHoras.add(labelDuasHoras);

        textFieldDuasHoras.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldDuasHoras.setPreferredSize(new Dimension(200 , 25));
        painelDuasHoras.add(textFieldDuasHoras);

        JPanel painelTresHoras = new JPanel();
        painelTresHoras.setBounds(142 , 257 , 200 , 50);
        add(painelTresHoras);
        painelTresHoras.setLayout(new BoxLayout(painelTresHoras , BoxLayout.PAGE_AXIS));

        JLabel labelTresHoras = new JLabel("Até três horas (em R$)");
        labelTresHoras.setPreferredSize(new Dimension(200 , 25));
        painelTresHoras.add(labelTresHoras);

        textFieldTresHoras.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldTresHoras.setPreferredSize(new Dimension(200 , 25));
        painelTresHoras.add(textFieldTresHoras);

        JPanel painelPernoite = new JPanel();
        painelPernoite.setBounds(441 , 178 , 200 , 50);
        add(painelPernoite);
        painelPernoite.setLayout(new BoxLayout(painelPernoite , BoxLayout.PAGE_AXIS));

        JLabel labelPernoite = new JLabel("Pernoite (em R$)");
        labelPernoite.setPreferredSize(new Dimension(200 , 25));
        painelPernoite.add(labelPernoite);

        textFieldPernoite.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelPernoite.add(textFieldPernoite);
        textFieldPernoite.setColumns(10);

        JPanel painelAposTres = new JPanel();
        painelAposTres.setBounds(441 , 86 , 200 , 50);
        add(painelAposTres);
        painelAposTres.setLayout(new BoxLayout(painelAposTres , BoxLayout.PAGE_AXIS));

        JLabel labelAposTres = new JLabel("Após três horas/diária (em R$)");
        labelAposTres.setPreferredSize(new Dimension(200 , 25));
        painelAposTres.add(labelAposTres);

        textFieldAposTres.setColumns(10);
        textFieldAposTres.setAlignmentX(0.0f);
        painelAposTres.add(textFieldAposTres);

        JButton botaoVoltar = new JButton("Cancelar");
        botaoVoltar.setBounds(142 , 400 , 200 , 25);
        add(botaoVoltar);

        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setBounds(441 , 400 , 200 , 25);
        add(botaoConfirmar);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelPrecos(painelPai));
                setVisible(false);
            }
        });

        botaoConfirmar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String umaHora = textFieldUmaHora.getText().replace("." , "").replace("," , ".");
                String duasHoras = textFieldDuasHoras.getText().replace("." , "").replace("," , ".");
                String tresHoras = textFieldTresHoras.getText().replace("." , "").replace("," , ".");
                String aposTres = textFieldAposTres.getText().replace("." , "").replace("," , ".");
                String pernoite = textFieldPernoite.getText().replace("." , "").replace("," , ".");

                if (GerenciadorPrecos.cadastrarTabela(Double.parseDouble(umaHora) , Double.parseDouble(duasHoras) ,
                                Double.parseDouble(tresHoras) , Double.parseDouble(aposTres) ,
                                Double.parseDouble(pernoite)))
                {
                    new TelaAvisoGenerica("Tabela de preços atualizada com sucesso!");
                    painelPai.add(new PainelPrecos(painelPai));
                    setVisible(false);
                }
                else
                    new TelaAvisoGenerica("Falha ao registrar nova tabela de preços.");
            }
        });
    }
}