package util;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;

public class Posicionamento
{
    public static Point centroDaTela = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    
    public static Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
}