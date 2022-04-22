package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.GerenciadorFatura;
import controller.GerenciadorPrecos;
import controller.GerenciadorRotativo;
import model.Rotativo;
import model.DAO.RotativoDAO;
import javax.swing.SwingConstants;

public class PainelSaidaVeiculo extends JPanel
{
    String placa;

    JFormattedTextField textFieldPlaca;

    JTextField textFieldDataEntrada;

    JTextField textFieldHoraEntrada;

    JTextField textFieldDescricao;

    JTextField textFieldNumero;

    JFormattedTextField valor;

    double horaFracionada;

    public PainelSaidaVeiculo(JPanel painelPai)
    {
        DecimalFormat decimal = new DecimalFormat("0.00");

        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        JLabel labelPlaca = new JLabel("Placa do Veículo");
        labelPlaca.setBounds(0 , 0 , 200 , 25);
        labelPlaca.setPreferredSize(new Dimension(200 , 25));

        textFieldPlaca = new JFormattedTextField();
        textFieldPlaca.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldPlaca.setBounds(0 , 0 , 200 , 25);
        textFieldPlaca.setPreferredSize(new Dimension(200 , 25));

        try
        {
            MaskFormatter mascaraPlaca = new MaskFormatter("UUU####");

            textFieldPlaca = new JFormattedTextField(mascaraPlaca);
        }
        catch (Exception e)
        {

        }

        JPanel painelPlaca = new JPanel();
        painelPlaca.setLayout(new BoxLayout(painelPlaca , BoxLayout.PAGE_AXIS));
        painelPlaca.setBounds(132 , 142 , 200 , 50);

        painelPlaca.add(labelPlaca);
        painelPlaca.add(textFieldPlaca);

        /////////////////////////////////////

        JLabel labelDescricao = new JLabel("Descrição do Veículo");
        labelDescricao.setBounds(0 , 0 , 200 , 25);
        labelDescricao.setPreferredSize(new Dimension(200 , 25));

        JTextField textFieldDescricao = new JTextField();
        textFieldDescricao.setEditable(false);
        textFieldDescricao.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldDescricao.setBounds(0 , 0 , 200 , 25);

        JPanel painelDescricao = new JPanel();
        painelDescricao.setLayout(new BoxLayout(painelDescricao , BoxLayout.PAGE_AXIS));
        painelDescricao.setBounds(132 , 218 , 200 , 50);

        painelDescricao.add(labelDescricao);
        painelDescricao.add(textFieldDescricao);

        ///////////////////////////////////////////

        JLabel labelNumero = new JLabel("Número da Vaga");
        labelNumero.setPreferredSize(new Dimension(200 , 25));
        labelNumero.setBounds(0 , 0 , 200 , 25);

        JTextField textFieldNumero = new JTextField();
        textFieldNumero.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldNumero.setEditable(false);
        textFieldNumero.setPreferredSize(new Dimension(35 , 25));
        textFieldNumero.setBounds(0 , 0 , 35 , 25);

        JPanel painelNumero = new JPanel();
        painelNumero.setLayout(new BoxLayout(painelNumero , BoxLayout.PAGE_AXIS));
        painelNumero.setPreferredSize(new Dimension(125 , 50));
        painelNumero.setBounds(132 , 292 , 115 , 50);

        painelNumero.add(labelNumero);
        painelNumero.add(textFieldNumero);

        /////////////////////////////////////////////////////////////

        JLabel labelDataEntrada = new JLabel("Data da Entrada");
        labelDataEntrada.setPreferredSize(new Dimension(200 , 25));
        labelDataEntrada.setBounds(0 , 0 , 200 , 25);

        textFieldDataEntrada = new JTextField();
        textFieldDataEntrada.setEditable(false);
        textFieldDataEntrada.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldDataEntrada.setPreferredSize(new Dimension(200 , 25));
        textFieldDataEntrada.setBounds(0 , 0 , 200 , 25);

        JPanel painelDataEntrada = new JPanel();
        painelDataEntrada.setLayout(new BoxLayout(painelDataEntrada , BoxLayout.PAGE_AXIS));
        painelDataEntrada.setPreferredSize(new Dimension(200 , 50));
        painelDataEntrada.setBounds(762 , 375 , 200 , 50);

        painelDataEntrada.add(labelDataEntrada);
        painelDataEntrada.add(textFieldDataEntrada);

        ///////////////////////////////////////////

        JLabel labelHoraEntrada = new JLabel("Hora da Entrada");
        labelHoraEntrada.setPreferredSize(new Dimension(200 , 25));
        labelHoraEntrada.setBounds(0 , 0 , 100 , 25);

        textFieldHoraEntrada = new JTextField();
        textFieldHoraEntrada.setEditable(false);
        textFieldHoraEntrada.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldHoraEntrada.setPreferredSize(new Dimension(100 , 25));
        textFieldHoraEntrada.setBounds(0 , 0 , 100 , 25);

        JPanel painelHoraEntrada = new JPanel();
        painelHoraEntrada.setLayout(new BoxLayout(painelHoraEntrada , BoxLayout.PAGE_AXIS));
        painelHoraEntrada.setPreferredSize(new Dimension(100 , 50));
        painelHoraEntrada.setBounds(762 , 375 , 100 , 50);

        painelHoraEntrada.add(labelHoraEntrada);
        painelHoraEntrada.add(textFieldHoraEntrada);

        /////////////////////////////////////////////////////////

        JPanel painelDataHora = new JPanel();
        painelDataHora.setLayout(new BoxLayout(painelDataHora , BoxLayout.LINE_AXIS));
        painelDataHora.setPreferredSize(new Dimension(200 , 50));
        painelDataHora.setBounds(500 , 142 , 217 , 50);

        painelDataHora.add(painelDataEntrada);
        painelDataHora.add(painelHoraEntrada);

        ///////////////////////////////////////////////////

        JLabel labelValor = new JLabel("Valor a Ser Pago (em R$)");
        labelValor.setPreferredSize(new Dimension(200 , 25));
        labelValor.setBounds(0 , 0 , 100 , 25);

        JTextField textFieldValor = new JTextField();
        textFieldValor.setEditable(false);
        textFieldValor.setAlignmentX(Component.LEFT_ALIGNMENT);
        textFieldValor.setPreferredSize(new Dimension(100 , 25));
        textFieldValor.setBounds(0 , 0 , 100 , 25);

        JPanel painelValor = new JPanel();
        painelValor.setLayout(new BoxLayout(painelValor , BoxLayout.PAGE_AXIS));
        painelValor.setPreferredSize(new Dimension(100 , 50));
        painelValor.setBounds(500 , 218 , 217 , 50);

        painelValor.add(labelValor);
        painelValor.add(textFieldValor);

        /////////////////////////////////////////////////////////////////////////////////////

        JButton botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.setBounds(342 , 167 , 99 , 25);
        botaoPesquisar.setPreferredSize(new Dimension(200 , 25));

        JButton botaoRegistrar = new JButton("Registrar");
        botaoRegistrar.setPreferredSize(new Dimension(200 , 25));
        botaoRegistrar.setBounds(500 , 412 , 200 , 25);

        botaoRegistrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ( ! textFieldPlaca.getText().trim().equals(""))
                {
                    // Checar por duplicidade
                    Rotativo rotativoRef = RotativoDAO.buscarPorPlaca(textFieldPlaca.getText());

                    GerenciadorRotativo.registrarSaida(RotativoDAO.buscarPorPlaca(placa));
                    GerenciadorFatura.registrarFaturaRotativo("Dinheiro" ,
                                    Double.parseDouble(textFieldValor.getText().replace("," , ".")) , rotativoRef);

                    new TelaAvisoGenerica("Registro efetuado com sucesso!");
                    painelPai.add(new HomeRotativo(painelPai));
                    setVisible(false);
                }
                else
                    new TelaAvisoGenerica("Há campos obrigatórios que não foram preenchidos!");
            }
        });

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200 , 25));
        botaoVoltar.setBounds(132 , 412 , 200 , 25);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new HomeRotativo(painelPai));
                setVisible(false);
            }
        });

        ////////////////////////////////////////////////////////////////////////////

        botaoPesquisar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // se placa nao encontrada, exibir aviso
                Rotativo rotativo = RotativoDAO.buscarPorPlaca(textFieldPlaca.getText());
                placa = rotativo.getPlacaVeiculo();

                SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatHoraEMinuto = new SimpleDateFormat("HH:mm");

                SimpleDateFormat formatApenasAno = new SimpleDateFormat("yyyy");
                SimpleDateFormat formatApenasMes = new SimpleDateFormat("MM");
                SimpleDateFormat formatApenasDia = new SimpleDateFormat("dd");
                SimpleDateFormat formatApenasHora = new SimpleDateFormat("HH");
                SimpleDateFormat formatApenasMinuto = new SimpleDateFormat("mm");

                Date dataEntrada = rotativo.getDataEntrada();
                Time horaEntrada = rotativo.getHoraEntrada();

                ///////////////////////////////////////////////////////////////////////

                int apenasHoraEntrada = Integer.parseInt(formatApenasHora.format(horaEntrada));
                int apenasMinutoEntrada = Integer.parseInt(formatApenasMinuto.format(horaEntrada));

                int apenasAnoEntrada = Integer.parseInt(formatApenasAno.format(dataEntrada));
                int apenasMesEntrada = Integer.parseInt(formatApenasMes.format(dataEntrada));
                int apenasDiaEntrada = Integer.parseInt(formatApenasDia.format(dataEntrada));

                Calendar calendarAtual = new GregorianCalendar();

                Date dataAtual = calendarAtual.getTime();

                int apenasHoraAtual = Integer.parseInt(formatApenasHora.format(dataAtual));
                int apenasMinutoAtual = Integer.parseInt(formatApenasMinuto.format(dataAtual));

                int apenasAnoAtual = Integer.parseInt(formatApenasAno.format(dataAtual));
                int apenasMesAtual = Integer.parseInt(formatApenasMes.format(dataAtual));
                int apenasDiaAtual = Integer.parseInt(formatApenasDia.format(dataAtual));

                int diferencaAno = apenasAnoAtual - apenasAnoEntrada;
                int diferencaMes = (diferencaAno * 12) + apenasMesAtual - apenasMesEntrada;
                int diferencaDia = (diferencaMes * 30) + apenasDiaAtual - apenasDiaEntrada;
                int diferencaHora = (diferencaDia * 24) + apenasHoraAtual - apenasHoraEntrada;

                int diferencaMinuto = (diferencaHora * 60) + apenasMinutoAtual - apenasMinutoEntrada;

                double minutosTotais = diferencaMinuto;

                horaFracionada = minutosTotais / 60;

                String valorFormatado = decimal.format(GerenciadorPrecos.buscarPreco(horaFracionada));

                textFieldValor.setText(valorFormatado.replace("." , ","));

                ////////////////////////////////////////////////////////////////////////////

                textFieldDataEntrada.setText(formatData.format(dataEntrada));
                textFieldHoraEntrada.setText(formatHoraEMinuto.format(horaEntrada));
                textFieldDescricao.setText(rotativo.getVeiculo().getDescricao());
                textFieldNumero.setText(Integer.toString(rotativo.getVaga().getIdVaga()));
            }
        });

        JCheckBox chkBoxPernoite = new JCheckBox("Pernoite");
        chkBoxPernoite.setHorizontalAlignment(SwingConstants.RIGHT);
        chkBoxPernoite.setPreferredSize(new Dimension(25 , 25));
        chkBoxPernoite.setBounds(626 , 278 , 91 , 25);

        chkBoxPernoite.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    String valorFormatado = decimal.format(GerenciadorPrecos.buscarPrecoPernoite());
                    textFieldValor.setText(valorFormatado.replace("." , ","));
                }

                if (e.getStateChange() == ItemEvent.DESELECTED)
                {
                    String valorFormatado = decimal.format(GerenciadorPrecos.buscarPreco(horaFracionada));

                    textFieldValor.setText(valorFormatado.replace("." , ","));
                }
            }
        });

        add(chkBoxPernoite);

        /////////////////////////////////////////////////////////////////////////////

        JButton botaoRedefinirPreco = new JButton("Redefinir");
        botaoRedefinirPreco.setPreferredSize(new Dimension(200 , 25));
        botaoRedefinirPreco.setBounds(500 , 278 , 115 , 25);

        botaoRedefinirPreco.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                textFieldValor.setEditable(true);
            }
        });

        add(painelPlaca);
        add(botaoPesquisar);
        add(painelDescricao);
        add(painelNumero);
        add(painelDataHora);
        add(painelValor);
        add(botaoRedefinirPreco);
        add(botaoVoltar);
        add(botaoRegistrar);
    }
}