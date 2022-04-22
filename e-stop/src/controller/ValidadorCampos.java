package controller;

public class ValidadorCampos
{
    public static boolean checarSeHaVazio(String[] campos)
    {
        for (String campo : campos)
        {
            if (campo.isEmpty())
            {
                return true;
            }
        }
        return false;
    }
}