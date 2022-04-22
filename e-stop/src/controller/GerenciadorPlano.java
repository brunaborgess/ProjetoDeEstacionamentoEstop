package controller;

import java.util.List;

import model.Plano;
import model.DAO.PlanoDAO;

public class GerenciadorPlano
{
    public static String[] recuperarListaDePlanos()
    {
        List<Plano> lista = PlanoDAO.buscarTodos();
        
        String[] listaDescricao = new String[lista.size()];
        
        for (int i = 0 ; i < listaDescricao.length ; i ++)
        {
            listaDescricao[i] = lista.get(i).getDescricao();
        }
        
        return listaDescricao;
    }
}