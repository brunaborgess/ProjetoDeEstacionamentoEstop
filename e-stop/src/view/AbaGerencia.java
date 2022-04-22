package view;

import javax.swing.JPanel;

public class AbaGerencia extends JPanel
{
    public AbaGerencia()
    {
        add(new HomeGerencia(this));
    }
}