package main;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Filme matrix = new Filme("The Matrix", 1999);
        matrix.setDuracaoEmMinutos(135);
        matrix.setIncluidoNoPlano(true);

        matrix.exibeFichaTecnica();
        matrix.avalia(9);
        matrix.avalia(8);
        matrix.avalia(9);

        System.out.println("Média de avaliações do filme: " + matrix.pegaMedia());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);

        System.out.println("Duração do filme: " + lost.getDuracaoEmMinutos());

        Filme avatar = new Filme("Avatar", 2022);
        avatar.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(matrix);
        calculadora.inclui(avatar);
        calculadora.inclui(lost);

        System.out.println(calculadora.getTempoTotal());

        Episodio primeiro = new Episodio("Piloto", 2000);
        primeiro.setNumero(1);
        primeiro.setSerie(lost);
        primeiro.setTotalVisualizacoes(300);

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(matrix);
        filtro.filtrar(lost);
        filtro.filtrar(primeiro);

        ArrayList<Filme> arrayListFilmes = new ArrayList<>();
        arrayListFilmes.add(matrix);
        arrayListFilmes.add(avatar);

        System.out.println("Tamanho da lista: " + arrayListFilmes.size());
        System.out.println("Primeiro filme: " + arrayListFilmes.get(0).getNome());
        System.out.println("Lista de filmes: " + arrayListFilmes);



    }

}