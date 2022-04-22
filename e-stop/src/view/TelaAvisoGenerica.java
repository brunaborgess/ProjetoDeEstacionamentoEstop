package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaAvisoGenerica extends JFrame
{
    public TelaAvisoGenerica(String texto)
    {
        JOptionPane.showMessageDialog(null , texto , "Aviso" , JOptionPane.PLAIN_MESSAGE);
    }
}