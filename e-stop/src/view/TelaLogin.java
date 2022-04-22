package view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Acesso;
import controller.Principal;
import util.Posicionamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;

public class TelaLogin extends JFrame
{   
    public TelaLogin()
    {        
        // TODO Corrigir tamanho
        setLayout(null);
        
        ImageIcon icone = new ImageIcon("img/e-stop_e.png");
        setIconImage(icone.getImage());
        
        JPanel subPainel = new JPanel();
        subPainel.setLayout(new BoxLayout(subPainel , BoxLayout.PAGE_AXIS));
        subPainel.setBounds(72 , 56 , 200 , 155);
        
        ImageIcon imageIconLogo = new ImageIcon("img/e-stop_logo.png");
        
        // Redimensiona logomarca
        Image imageLogo = imageIconLogo.getImage();
        Image imageLogoResized = imageLogo.getScaledInstance(200 , 50 , Image.SCALE_SMOOTH);
        
        imageIconLogo = new ImageIcon(imageLogoResized);
        
        JLabel labelLogo = new JLabel(imageIconLogo);
        labelLogo.setBounds(72, 0, 200, 50);
        
        add(labelLogo);
        
        // Estudar motivo de nao centralizar apenas com o SwingConstants.LEFT
        JLabel labelNomeUsuario = new JLabel("Nome de Usuário" , SwingConstants.LEFT);
        labelNomeUsuario.setPreferredSize(new Dimension(200 , 25));
        labelNomeUsuario.setMinimumSize(new Dimension(200 , 25));
        labelNomeUsuario.setMaximumSize(new Dimension(200 , 25));
        labelNomeUsuario.setAlignmentX(CENTER_ALIGNMENT);

        JTextField textFieldUsuario = new JTextField();
        textFieldUsuario.setPreferredSize(new Dimension(200 , 25));
        textFieldUsuario.setMinimumSize(new Dimension(200 , 25));
        textFieldUsuario.setMaximumSize(new Dimension(200 , 25));
        textFieldUsuario.setAlignmentX(CENTER_ALIGNMENT);
        
        JPanel subsubPainel1 = new JPanel();
        subsubPainel1.setLayout(new BoxLayout(subsubPainel1 , BoxLayout.PAGE_AXIS));
        subsubPainel1.setPreferredSize(new Dimension(200 , 50));
        
        subsubPainel1.add(labelNomeUsuario);
        subsubPainel1.add(textFieldUsuario);
        
        JPanel subsubPainel2 = new JPanel();
        subsubPainel2.setLayout(new BoxLayout(subsubPainel2 , BoxLayout.PAGE_AXIS));
        subsubPainel2.setPreferredSize(new Dimension(200 , 50));
        
        // Estudar motivo de nao centralizar apenas com o SwingConstants.LEFT
        JLabel labelSenha = new JLabel("Senha" , SwingConstants.LEFT);
        labelSenha.setPreferredSize(new Dimension(200 , 25));
        labelSenha.setMinimumSize(new Dimension(200 , 25));
        labelSenha.setMaximumSize(new Dimension(200 , 25));
        labelSenha.setAlignmentX(CENTER_ALIGNMENT);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200 , 25));
        passwordField.setMinimumSize(new Dimension(200 , 25));
        passwordField.setMaximumSize(new Dimension(200 , 25));
        passwordField.setAlignmentX(CENTER_ALIGNMENT);        
        
        subsubPainel2.add(labelSenha);
        subsubPainel2.add(passwordField);
        
        JButton botaoEntrar = new JButton("ENTRAR");
        botaoEntrar.setPreferredSize(new Dimension(200 , 25));
        botaoEntrar.setMinimumSize(new Dimension(200 , 25));
        botaoEntrar.setMaximumSize(new Dimension(200 , 25));
        botaoEntrar.setAlignmentX(CENTER_ALIGNMENT);
        botaoEntrar.setMnemonic(KeyEvent.VK_ENTER);
        
        subPainel.add(subsubPainel1);
        subPainel.add(subsubPainel2);
        subPainel.add(Box.createRigidArea(new Dimension(0 , 20)));
        subPainel.add(botaoEntrar);        
        
        // Comportamento do botao ENTRAR
        botaoEntrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Chama instrução de login da classe Acesso
                if (Acesso.login(textFieldUsuario.getText() , new String(passwordField.getPassword())))
                {
                    new TelaAberturaCaixa();
                    dispose();
                }
                else
                    new TelaAvisoGenerica("Login mal sucedido!\nVerifique as informações digitadas.");
            }
        });
        
        add(subPainel);
        
        setTitle("E-STOP: Login");
        setSize(350 , 250);
        setLocation(Posicionamento.tamanhoDaTela.width / 2 - this.getSize().width / 2 ,
                    Posicionamento.tamanhoDaTela.height / 2 - this.getSize().height / 2); 
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}