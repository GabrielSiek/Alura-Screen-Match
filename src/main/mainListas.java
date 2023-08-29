package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class mainListas {
    public static void main(String[] args) {
        Filme matrix = new Filme("Matrix", 1999);
        Filme avatar = new Filme("Avatar", 2022);
        Filme galinhoChickenLittle = new Filme("O galinho chicken litte", 2005);
        Serie modernFamily = new Serie("Modern Family", 2009);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(matrix);
        lista.add(avatar);
        lista.add(galinhoChickenLittle);
        lista.add(modernFamily);
        for(Titulo item: lista) {
            System.out.println(item.getNome());
            if(item instanceof Filme filme)
                System.out.println("Classificação: " + filme.getClassificacao());
        }

        System.out.println("Lista antes da ordenação: ");
        System.out.println(lista);
        System.out.println("Lista depois da ordenação: ");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Lista ordenada por ano: ");
        System.out.println(lista);

    }
}
