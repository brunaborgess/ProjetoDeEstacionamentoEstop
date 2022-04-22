package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.GerenciadorFuncionario;
import controller.Principal;
import model.DAO.FuncionarioDAO;

public class PainelCadastroFuncionario extends JPanel
{
    public PainelCadastroFuncionario(JPanel painelPai)
    {
        setLayout(null);
        setPreferredSize(new Dimension(800 , 600));

        JPanel subPainel = new JPanel();
        subPainel.setLayout(new BoxLayout(subPainel , BoxLayout.PAGE_AXIS));
        subPainel.setBounds(300 , 82 , 200 , 212);

        JLabel labelNome = new JLabel("Nome Completo");
        labelNome.setPreferredSize(new Dimension(200 , 25));
        labelNome.setMinimumSize(new Dimension(200 , 25));
        labelNome.setMaximumSize(new Dimension(200 , 25));
        labelNome.setBounds(0 , 0 , 200 , 25);
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textFieldNome = new JTextField();
        textFieldNome.setPreferredSize(new Dimension(200 , 25));
        textFieldNome.setMinimumSize(new Dimension(200 , 25));
        textFieldNome.setMaximumSize(new Dimension(200 , 25));
        textFieldNome.setBounds(0 , 0 , 200 , 25);
        textFieldNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel subPainelNome = new JPanel();
        subPainelNome.setLayout(new BoxLayout(subPainelNome , BoxLayout.PAGE_AXIS));
        subPainelNome.setBounds(0 , 0 , 200 , 50);

        subPainelNome.add(labelNome);
        subPainelNome.add(textFieldNome);

        subPainel.add(subPainelNome);

        ////////////////////////////////////////////////////////////////////////

        JLabel labelNomeUsuario = new JLabel("Nome de Usuário");
        labelNomeUsuario.setPreferredSize(new Dimension(200 , 25));
        labelNomeUsuario.setMinimumSize(new Dimension(200 , 25));
        labelNomeUsuario.setMaximumSize(new Dimension(200 , 25));
        labelNomeUsuario.setBounds(0 , 0 , 200 , 25);
        labelNomeUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textFieldNomeUsuario = new JTextField();
        textFieldNomeUsuario.setPreferredSize(new Dimension(200 , 25));
        textFieldNomeUsuario.setMinimumSize(new Dimension(200 , 25));
        textFieldNomeUsuario.setMaximumSize(new Dimension(200 , 25));
        textFieldNomeUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel subPainelNomeUsuario = new JPanel();
        subPainelNomeUsuario.setLayout(new BoxLayout(subPainelNome , BoxLayout.PAGE_AXIS));
        subPainelNomeUsuario.setBounds(0 , 0 , 200 , 50);

        subPainelNomeUsuario.setLayout(new BoxLayout(subPainelNomeUsuario , BoxLayout.PAGE_AXIS));
        subPainelNomeUsuario.setBounds(0 , 0 , 200 , 50);

        subPainelNomeUsuario.add(labelNomeUsuario);
        subPainelNomeUsuario.add(textFieldNomeUsuario);

        subPainel.add(subPainelNomeUsuario);

        JLabel labelSenha = new JLabel("Senha");
        labelSenha.setPreferredSize(new Dimension(200 , 25));
        labelSenha.setMinimumSize(new Dimension(200 , 25));
        labelSenha.setMaximumSize(new Dimension(200 , 25));
        labelSenha.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setPreferredSize(new Dimension(200 , 25));
        passwordFieldSenha.setMinimumSize(new Dimension(200 , 25));
        passwordFieldSenha.setMaximumSize(new Dimension(200 , 25));
        passwordFieldSenha.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel subPainelSenha = new JPanel();
        subPainelSenha.setLayout(new BoxLayout(subPainelSenha , BoxLayout.PAGE_AXIS));
        subPainelSenha.setPreferredSize(new Dimension(250 , 50));
        subPainelSenha.setBounds(583 , 259 , 250 , 166);

        subPainelSenha.add(labelSenha);
        subPainelSenha.add(passwordFieldSenha);

        subPainel.add(subPainelSenha);

        JLabel labelNivelPermissao = new JLabel("Nível de Permissão");
        labelNivelPermissao.setPreferredSize(new Dimension(200 , 25));
        labelNivelPermissao.setMinimumSize(new Dimension(200 , 25));
        labelNivelPermissao.setMaximumSize(new Dimension(200 , 25));
        labelNivelPermissao.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] nivelPermissao = {"Funcionário" , "Gerente"};

        JComboBox cbNivelPermissao = new JComboBox(nivelPermissao);
        cbNivelPermissao.setPreferredSize(new Dimension(200 , 25));
        cbNivelPermissao.setMinimumSize(new Dimension(200 , 25));
        cbNivelPermissao.setMaximumSize(new Dimension(200 , 25));
        cbNivelPermissao.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel subPainelNivelPermissao = new JPanel();
        subPainelNivelPermissao.setLayout(new BoxLayout(subPainelNivelPermissao , BoxLayout.PAGE_AXIS));
        subPainelNivelPermissao.setPreferredSize(new Dimension(200 , 50));
        subPainelNivelPermissao.setBounds(583 , 259 , 200 , 50);

        subPainelNivelPermissao.add(labelNivelPermissao);
        subPainelNivelPermissao.add(cbNivelPermissao);

        subPainel.add(subPainelNivelPermissao);

        add(subPainel);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(507 , 342 , 200 , 25);
        botaoCadastrar.setPreferredSize(new Dimension(200 , 25));
        botaoCadastrar.setMinimumSize(new Dimension(200 , 25));
        botaoCadastrar.setMaximumSize(new Dimension(200 , 25));
        botaoCadastrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        botaoCadastrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if ( ! textFieldNome.getText().trim().isEmpty() && ! textFieldNomeUsuario.getText().trim().isEmpty()
                                && ! new String(passwordFieldSenha.getPassword()).trim().isEmpty())
                {

                    int opcao = JOptionPane.showConfirmDialog(null , "Deseja realmente cadastrar?" ,
                                    "Selecione uma opção" , JOptionPane.YES_NO_OPTION);

                    switch (opcao)
                    {
                        case JOptionPane.YES_OPTION :
                            if (FuncionarioDAO.buscarPorNomeUsuario(textFieldNomeUsuario.getText()) == null)
                            {
                                GerenciadorFuncionario.cadastrarFuncionario(textFieldNome.getText() ,
                                                textFieldNomeUsuario.getText() ,
                                                new String(passwordFieldSenha.getPassword()) ,
                                                (String) cbNivelPermissao.getSelectedItem());

                                painelPai.add(new PainelUsuarios(painelPai));
                                setVisible(false);
                            }
                            else
                                new TelaAvisoGenerica("Já existe um funcionário com este nome de usuário.");
                            break;

                        default :
                            break;
                    }

                }
                else
                    new TelaAvisoGenerica("Há campos necessários que não foram preenchidos!");
            }
        });

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200 , 25));
        botaoVoltar.setMinimumSize(new Dimension(200 , 25));
        botaoVoltar.setMaximumSize(new Dimension(200 , 25));
        botaoVoltar.setAlignmentX(0.5f);
        botaoVoltar.setBounds(103 , 342 , 200 , 25);

        botaoVoltar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                painelPai.add(new PainelUsuarios(painelPai));
                setVisible(false);
            }
        });

        add(botaoCadastrar);
        add(botaoVoltar);
    }
}