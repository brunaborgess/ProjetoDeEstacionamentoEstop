package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.GerenciadorFatura;
import controller.Principal;
import model.Cliente;
import model.DAO.AssinaturaDAO;
import view.TableModel.TableModelAssinatura;
import view.TableModel.TableModelOperacaoCaixa;

public class PainelAssinaturas extends JPanel
{
    public JPanel painelAssinaturaInstanciado = this;
    public static JTable tabelaAssinatura;

    public PainelAssinaturas(JPanel painelPai , JPanel painelAnterior , Cliente cliente)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        tabelaAssinatura = new JTable(new TableModelAssinatura(cliente));
        tabelaAssinatura.setBounds(340 , 205 , 618 , 278);

        tabelaAssinatura.getTableHeader().setReorderingAllowed(false);
        tabelaAssinatura.getTableHeader().setResizingAllowed(false);
        
        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(91 , 63 , 618 , 278);
        scroll.setViewportView(tabelaAssinatura);

        tabelaAssinatura.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int linha = tabelaAssinatura.getSelectedRow();

                if (tabelaAssinatura.getValueAt(linha , 5).equals("Não"))
                {

                    int opcao = JOptionPane.showConfirmDialog(null , "Deseja definir esta assinatura como paga?" ,
                                                              "Selecione uma opção" , JOptionPane.YES_NO_OPTION);

                    switch (opcao)
                    {
                        case JOptionPane.YES_OPTION :

                            if (AssinaturaDAO.atualizar(true , (int) tabelaAssinatura.getValueAt(linha , 0)))
                            {
                                GerenciadorFatura.registrarFaturaAssinatura("Dinheiro" ,
                                                AssinaturaDAO.buscarPorIdAssinatura((int) tabelaAssinatura.getValueAt(linha , 0)).getValorAssinatura() ,
                                                AssinaturaDAO.buscarPorIdAssinatura(
                                                                (int) tabelaAssinatura.getValueAt(linha , 0)));
                                tabelaAssinatura.setModel(new TableModelAssinatura(cliente));
                                new TelaAvisoGenerica("Registro de pagamento efetuado com sucesso!");
                            }
                            else
                                new TelaAvisoGenerica("Falha ao registrar pagamento");

                            break;

                        default :
                            break;
                    }
                }
            }
        });

        add(scroll);

        JButton botaoAdicionarAssinatura = new JButton("Criar Assinatura");
        botaoAdicionarAssinatura.setBounds(509 , 380 , 200 , 25);

        JPanel painelAtual = this;

        botaoAdicionarAssinatura.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelCadastroAssinatura(painelPai , painelAtual , cliente));
                setVisible(false);
            }
        });

        add(botaoAdicionarAssinatura);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(91 , 380 , 200 , 25);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (painelAnterior != null)
                {
                    painelAnterior.setVisible(true);
                    setVisible(false);
                }
                else
                    painelPai.add(new HomeClientes(painelPai));
                setVisible(false);
            }
        });

        add(botaoVoltar);
    }
}