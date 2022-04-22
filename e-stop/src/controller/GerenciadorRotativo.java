package controller;

import java.util.List;

import model.Rotativo;
import model.Vaga;
import model.Veiculo;
import model.DAO.RotativoDAO;
import model.DAO.VagaDAO;
import model.DAO.VeiculoDAO;

public class GerenciadorRotativo
{
    // Recolhe apenas as vagas livres
    public static String[] buscarVagasLivres(String tipoDeVeiculo)
    {
        List<Vaga> vagasLivres = VagaDAO.buscarLivresPorTipoDeVeiculo(tipoDeVeiculo);
        String[] numerosLivres = new String[vagasLivres.size()];
        
        for (int i = 0 ; i < numerosLivres.length ; i ++)
        {
            numerosLivres[i] = Integer.toString(vagasLivres.get(i).getIdVaga());
        }
        return numerosLivres;
    }
    
    // Recolhe os tipos de veículo possiveis de serem estacionados
    public static String[] buscarTiposDeVeiculo()
    {
        List<String> tiposDeVeiculo = VagaDAO.buscarTiposDeVeiculo();
        String[] tipos = new String[tiposDeVeiculo.size()];
        
        for (int i = 0 ; i < tipos.length ; i ++)
        {
            tipos[i] = tiposDeVeiculo.get(i);
        }
        
        return tipos;
    }

    public static void registrarEntrada(String idVaga , String descricao , String placa)
    {
        Veiculo veiculo = VeiculoDAO.inserir(descricao);

        VagaDAO.alterarDisponibilidade(Integer.parseInt(idVaga));

        RotativoDAO.inserir(placa , veiculo , VagaDAO.buscarPorIdVaga(Integer.parseInt(idVaga)));
    }

    public static void registrarSaida(Rotativo rotativo)
    {
        RotativoDAO.atualizar(rotativo.getIdRotativo());
        
        Vaga vaga = RotativoDAO.buscarPorIdRotativo(rotativo.getIdRotativo()).getVaga();
        
        VagaDAO.alterarDisponibilidade(vaga.getIdVaga());
    }
    
    public static String[] todasAsVagas()
    {
        List<Vaga> lista = VagaDAO.buscarTodos();
        
        String[] listaVagas = new String[lista.size()];
        
        for (int i = 0 ; i < listaVagas.length ; i ++)
        {
            listaVagas[i] = Integer.toString(lista.get(i).getIdVaga());
        }
        
        return listaVagas;
    }
}