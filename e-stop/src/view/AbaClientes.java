package view;

import javax.swing.JPanel;

public class AbaClientes extends JPanel
{    
    public AbaClientes()
    {
        add(new HomeClientes(this));
    }
}