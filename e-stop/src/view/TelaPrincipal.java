package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controller.Acesso;
import util.Posicionamento;

public class TelaPrincipal extends JFrame
{
    public TelaPrincipal()
    {
        // Define o titulo a partir do metodo construtor da superclasse
        super("E-STOP: Sistema de Gerenciamento de Estacionamento");
        
        // Define o icone da janela
        ImageIcon icone = new ImageIcon("img/e-stop_e.png");
        setIconImage(icone.getImage());
        
        // Instancia lista de abas
        JTabbedPane abas = new JTabbedPane();
        
        // Define lista de abas
        abas.addTab("Rotativo" , new AbaRotativo());
        abas.addTab("Clientes" , new AbaClientes());
        abas.addTab("Caixa" , new AbaCaixa());
        abas.addTab("Preços" , new AbaPrecos());
        abas.addTab("Gerência" , new AbaGerencia());
        
        // Condicao para a aba Gerência estar acessivel
        if (Acesso.getFuncionario().getNivelPermissao() != 0)
            abas.setEnabledAt(4 , false);
        
        // Adiciona lista de abas ao painel da tela
        add(abas);
        
        // Define configuracoes da janela
        setSize(800 , 600);
        setLocation(Posicionamento.tamanhoDaTela.width / 2 - this.getSize().width / 2 ,
                        Posicionamento.tamanhoDaTela.height / 2 - this.getSize().height / 2); 
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}