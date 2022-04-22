package view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import controller.Acesso;
import controller.Principal;
import model.OperacaoCaixa;
import model.DAO.OperacaoCaixaDAO;
import util.Posicionamento;
import javax.swing.SwingConstants;

public class TelaAberturaCaixa extends JFrame
{
    JFormattedTextField valorFormatado = new JFormattedTextField();
    
    public TelaAberturaCaixa()
    {
        getContentPane().setLayout(null);
        setPreferredSize(new Dimension(800 , 600));
        
        ImageIcon icone = new ImageIcon("img/e-stop_e.png");
        setIconImage(icone.getImage());
        
        JPanel subPainel = new JPanel();
        subPainel.setLayout(new BoxLayout(subPainel , BoxLayout.PAGE_AXIS));
        subPainel.setPreferredSize(new Dimension(200 , 50));
        subPainel.setBounds(72 , 56 , 200 , 50);
        
        JLabel label = new JLabel("Valor ao abrir o caixa (em R$)");
        label.setPreferredSize(new Dimension(200 , 25));
        label.setBounds(0 , 0 , 200 , 25);
        
//        try
//        {
//            MaskFormatter mascara = new MaskFormatter("###.###,##");
//            mascara.setValidCharacters("01234567890");
//            
//            valorFormatado = new JFormattedTextField();
//            valorFormatado = new JFormattedTextField(mascara);
//            // valorFormatado.setHorizontalAlignment(SwingConstants.RIGHT);
//        }
//        catch (Exception e)
//        {
//            
//        }
        
        valorFormatado.setPreferredSize(new Dimension(200 , 25));
        valorFormatado.setBounds(0 , 0 , 200 , 25);
        // valorFormatado.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        // valorFormatado.setCaretColor(Color.WHITE);
        
        subPainel.add(label);
        subPainel.add(valorFormatado);
        
        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setPreferredSize(new Dimension(200 , 25));
        botaoContinuar.setBounds(72 , 117 , 200 , 25);
        
        botaoContinuar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (OperacaoCaixa.caixaEstaFechado())
                {
                    String valor = valorFormatado.getText().replace("." , "").replace("," , ".");
                    
                    OperacaoCaixaDAO.inserir("Abertura de Caixa" , Double.parseDouble(valor) , Double.parseDouble(valor) , null , Acesso.getFuncionario());
                    Principal.setTelaPrincipal(new TelaPrincipal());
                    dispose();
                }
                else
                {
                    new TelaAvisoGenerica("A sessão continuará com o caixa anterior, que não foi fechado.");
                    Principal.setTelaPrincipal(new TelaPrincipal());
                    dispose();
                }
            }
        });
        
        getContentPane().add(botaoContinuar);
        getContentPane().add(subPainel);
        
        setTitle("E-STOP: Abertura de Caixa");
        setSize(350 , 250);
        setResizable(false);
        setLocation(Posicionamento.tamanhoDaTela.width / 2 - this.getSize().width / 2 ,
                        Posicionamento.tamanhoDaTela.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}