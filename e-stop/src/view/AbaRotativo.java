package view;

import javax.swing.JPanel;

public class AbaRotativo extends JPanel
{
    public AbaRotativo()
    {
        add(new HomeRotativo(this));
    }
}