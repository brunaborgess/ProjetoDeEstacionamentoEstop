package controller;

import model.Preco;
import model.DAO.PrecoDAO;

public class GerenciadorPrecos
{
    // Retorna valor a ser pago em funcao do tempo de permanencia
    public static double buscarPreco(double horas)
    {
        Preco tabelaDePreco = PrecoDAO.buscarUltimoRegistro();
        
        if (horas < 1.0)
            return tabelaDePreco.getAteUmaHora();
        else if (horas > 1.0 && horas < 2.0)
            return tabelaDePreco.getAteDuasHoras();
        else if (horas > 2.0 && horas < 3.0)
            return tabelaDePreco.getAteTresHoras();
        else if (horas > 3.0)
            return tabelaDePreco.getAposTresHoras();
        
        return 0;
    }
    
    public static double buscarPrecoPernoite()
    {
        return PrecoDAO.buscarUltimoRegistro().getPernoite();
    }
    
    // Insere nova tabela de precos no banco de dados
    public static boolean cadastrarTabela(double ateUma , double ateDuas , double ateTres , double aposTres , double pernoite)
    {
        return PrecoDAO.inserir(ateUma , ateDuas, ateTres , aposTres , pernoite) != null;            
    }
}