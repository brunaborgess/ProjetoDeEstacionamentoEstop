package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;

import view.TableModel.TableModelVaga;

public class HomeRotativo extends JPanel
{
    TableModelVaga tableModelVaga;
    
    // TODO Exibir valores por hora
    public HomeRotativo(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        // TODO Exibir tooltip com lista de clientes-donos
        JTable tabelaVagas = new JTable(new TableModelVaga());
        tabelaVagas.getTableHeader().setReorderingAllowed(false);
        tabelaVagas.getTableHeader().setResizingAllowed(false);
        tabelaVagas.setFillsViewportHeight(true);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setPreferredSize(new Dimension(350 , 500));
        scroll.setBounds(100 , 39 , 350 , 401);
        scroll.setViewportView(tabelaVagas);
        
        add(scroll);
        
//        Timer timer = new Timer(1000 , new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                tableModelVaga = new TableModelVaga();
//                
//                tabelaVagas.setModel(tableModelVaga);
//            }
//        });
//        timer.setRepeats(true);
//        timer.start();
        
        JButton botaoRegistrarEntrada = new JButton ("Registrar Entrada de Veículo");
        botaoRegistrarEntrada.setPreferredSize(new Dimension(200 , 25));
        botaoRegistrarEntrada.setBounds(547 , 200 , 200 , 25);
        
        botaoRegistrarEntrada.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelEntradaVeiculo(painelPai));
                setVisible(false);
            }
        });
        
        JButton botaoRegistrarSaida = new JButton("Registrar Saída de Veículo");
        botaoRegistrarSaida.setPreferredSize(new Dimension(200 , 25));
        botaoRegistrarSaida.setBounds(547 , 315 , 200 , 25);
        
        botaoRegistrarSaida.addActionListener(new ActionListener()
        {
        @Override
        public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelSaidaVeiculo(painelPai));
                setVisible(false);
            }
        });
        
        add(botaoRegistrarEntrada);
        add(botaoRegistrarSaida);
    }
}