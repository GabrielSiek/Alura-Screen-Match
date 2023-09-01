package br.com.alura.screenmatch.modelos;

public class Titulo implements Comparable<Titulo>{

    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private double duracaoEmHoras;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        this.anoDeLancamento = tituloOmdb.year();
        if(tituloOmdb.runtime().charAt(2) == ' ')
            this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0,2));
        else
            this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0,3));
        if(tituloOmdb.runtime().charAt(2) == ' ')
            this.duracaoEmHoras = Double.valueOf(tituloOmdb.runtime().substring(0,2)) / 60;
        else
            this.duracaoEmHoras = Double.valueOf(tituloOmdb.runtime().substring(0,3)) / 60;
    }

    public void exibeFichaTecnica() {
        System.out.println("Nome do filme: " +nome);
        System.out.println("Ano de lançamento: " +anoDeLancamento);
        System.out.println("Duração em minutos: " +duracaoEmMinutos);
        System.out.println("Incluído no plano: " +incluidoNoPlano);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public String getNome() {
        return this.nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }


    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;

    }


    public boolean getIncluidoNoPlano() {
        return this.incluidoNoPlano;

    }


    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;

    }


    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;

    }


    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;

    }
    public double getDuracaoEmHoras() {
        return duracaoEmHoras;
    }


    public int getTotalDeAvaliacoes() {
        return this.totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return getNome().compareTo(outroTitulo.getNome());
    }



    public String toString() {

        if(getDuracaoEmMinutos() < 61)
            return "(Título: " + getNome() + " , " + getAnoDeLancamento() + ", " + getDuracaoEmMinutos() + " min)";

        return "(Título: " + getNome() + " , " + getAnoDeLancamento() + ", " + getDuracaoEmHoras() + " horas)";
    }
}
