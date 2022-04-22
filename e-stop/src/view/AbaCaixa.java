package view;

import javax.swing.JPanel;

import model.OperacaoCaixa;

public class AbaCaixa extends JPanel
{
    public AbaCaixa()
    {
        add(new PainelHistoricoCaixa());
    }
}