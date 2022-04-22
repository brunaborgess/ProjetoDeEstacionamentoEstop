package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Assinatura;
import model.Cliente;
import model.DAO.AssinaturaDAO;
import model.DAO.PlanoDAO;
import view.TableModel.TableModelAssinatura;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.GerenciadorPlano;
import controller.GerenciadorRotativo;
import controller.Principal;

import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.Component;

public class PainelCadastroAssinatura extends JPanel
{
    double valorPlano;

    private JTextField textFieldValor;

    public PainelCadastroAssinatura(JPanel painelPai , JPanel painelAnterior , Cliente cliente)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(128 , 371 , 200 , 25);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelAnterior.setVisible(true);
                setVisible(false);
            }
        });

        add(botaoVoltar);

        JButton botaoConfirmar = new JButton("Confirmar");

        botaoConfirmar.setBounds(467 , 371 , 200 , 25);

        add(botaoConfirmar);

        JPanel painelValor = new JPanel();
        painelValor.setBounds(128 , 181 , 200 , 50);
        add(painelValor);
        painelValor.setLayout(new BoxLayout(painelValor , BoxLayout.PAGE_AXIS));

        JLabel labelValor = new JLabel("Valor da Assinatura (em R$)");
        labelValor.setPreferredSize(new Dimension(200 , 25));
        painelValor.add(labelValor);

        textFieldValor = new JTextField();
        textFieldValor.setEnabled(false);
        textFieldValor.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelValor.add(textFieldValor);
        textFieldValor.setColumns(10);

        JPanel painelVencimento = new JPanel();
        painelVencimento.setBounds(467 , 60 , 200 , 50);
        add(painelVencimento);
        painelVencimento.setLayout(new BoxLayout(painelVencimento , BoxLayout.PAGE_AXIS));

        JLabel labelVencimento = new JLabel("Vencimento");
        labelVencimento.setPreferredSize(new Dimension(200 , 25));
        painelVencimento.add(labelVencimento);

        JPanel subPainelVencimento = new JPanel();
        subPainelVencimento.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelVencimento.add(subPainelVencimento);
        subPainelVencimento.setLayout(new BoxLayout(subPainelVencimento , BoxLayout.LINE_AXIS));

        JComboBox cbDia = new JComboBox();
        cbDia.setPreferredSize(new Dimension(200 , 25));
        subPainelVencimento.add(cbDia);

        for (int i = 1 ; i <= 31 ; i ++ )
        {
            cbDia.addItem(i);
        }

        JComboBox cbMes = new JComboBox();
        cbMes.setPreferredSize(new Dimension(200 , 25));
        subPainelVencimento.add(cbMes);

        for (int i = 1 ; i <= 12 ; i ++ )
        {
            cbMes.addItem(i);
        }

        JComboBox cbAno = new JComboBox();
        cbAno.setPreferredSize(new Dimension(200 , 25));
        subPainelVencimento.add(cbAno);

        for (int i = 0 ; i < 5 ; i ++ )
        {
            java.util.Date date = new java.util.Date();
            date.setYear(date.getYear() + 1900 + i);
            cbAno.addItem(date.getYear());
        }

        // JPanel painelVaga = new JPanel();
        // painelVaga.setBounds(467, 181, 200, 50);
        // add(painelVaga);
        // painelVaga.setLayout(new BoxLayout(painelVaga, BoxLayout.PAGE_AXIS));
        //
        // JLabel lblVaga = new JLabel("N\u00FAmero da Vaga");
        // lblVaga.setPreferredSize(new Dimension(200 , 25));
        // painelVaga.add(lblVaga);
        //
        // JComboBox cbVaga = new JComboBox(GerenciadorRotativo.todasAsVagas());
        // cbVaga.setAlignmentX(Component.LEFT_ALIGNMENT);
        // painelVaga.add(cbVaga);

        JPanel painelPlano = new JPanel();
        painelPlano.setBounds(128 , 60 , 200 , 50);
        add(painelPlano);
        painelPlano.setLayout(new BoxLayout(painelPlano , BoxLayout.PAGE_AXIS));

        JLabel lblPlano = new JLabel("Plano");
        lblPlano.setPreferredSize(new Dimension(200 , 25));
        painelPlano.add(lblPlano);

        String[] listaDePlanos = GerenciadorPlano.recuperarListaDePlanos();

        JComboBox cbPlano;

        if (listaDePlanos != null)
            cbPlano = new JComboBox(listaDePlanos);
        else
            cbPlano = new JComboBox();
        cbPlano.setPreferredSize(new Dimension(200 , 25));
        cbPlano.setAlignmentX(Component.LEFT_ALIGNMENT);
        painelPlano.add(cbPlano);

        try
        {
            valorPlano = PlanoDAO.buscarPorDescricao((String) cbPlano.getSelectedItem()).getValor();
        }
        catch (Exception e)
        {
            new TelaAvisoGenerica("Não há planos cadastrados.");
            painelAnterior.setVisible(true);
            painelPai.add(painelAnterior);
            setVisible(false);
        }

        DecimalFormat decimalFormatter = new DecimalFormat("0.00");

        String valor = decimalFormatter.format(valorPlano).replace("." , ",");

        textFieldValor.setText(valor);

        cbPlano.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                double valorPlano = PlanoDAO.buscarPorDescricao((String) cbPlano.getSelectedItem()).getValor();

                DecimalFormat decimalFormatter = new DecimalFormat("0.00");

                String valor = decimalFormatter.format(valorPlano).replace("." , ",");
                ;

                textFieldValor.setText(valor);
            }
        });

        botaoConfirmar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int opcao = JOptionPane.showConfirmDialog(null ,
                                "Deseja realmente vincular esta assinatura ao cliente?" , "Selecione uma opção" ,
                                JOptionPane.YES_NO_OPTION);

                switch (opcao)
                {
                    case JOptionPane.YES_OPTION :
                        String valor = textFieldValor.getText().replace("," , ".");

                        Date vencimento = new Date(Integer.parseInt(cbAno.getSelectedItem().toString()) ,
                                        Integer.parseInt(cbMes.getSelectedItem().toString()) ,
                                        Integer.parseInt(cbDia.getSelectedItem().toString()));

                        Assinatura assinaturaRegistrada = AssinaturaDAO.inserir(Double.parseDouble(valor) , vencimento ,
                                        cliente , PlanoDAO.buscarPorDescricao((String) cbPlano.getSelectedItem()));

                        if (assinaturaRegistrada != null)
                        {
                            new TelaAvisoGenerica("Assinatura cadastrada com sucesso!");
                            PainelAssinaturas.tabelaAssinatura.setModel(new TableModelAssinatura(cliente));
                            painelAnterior.setVisible(true);
                            setVisible(false);
                        }
                        else
                            new TelaAvisoGenerica("Falha ao cadastrar assinatura.");

                        break;
                }

            }
        });

        JButton botaoRedefinir = new JButton("Redefinir");

        botaoRedefinir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textFieldValor.setEnabled(true);
            }
        });
        botaoRedefinir.setBounds(338 , 208 , 100 , 25);
        add(botaoRedefinir);
    }
}