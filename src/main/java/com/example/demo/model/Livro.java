package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int TOTAL_LIVROS_BIBLIOTECA = 200; // Total de livros na biblioteca
    private int LIVROS_ALUGADOS_INICIAL = 25; // Livros já alugados inicialmente
    private int livrosPorSessao = 40;
    private double preco = 23.50;
    private int tempoAluguel = 14;

    public Livro(long id, int TOTAL_LIVROS_BIBLIOTECA, int LIVROS_ALUGADOS_INICIAL, int livrosPorSessao, double preco, int tempoAluguel) {
        this.id = id;
        this.TOTAL_LIVROS_BIBLIOTECA = TOTAL_LIVROS_BIBLIOTECA;
        this.LIVROS_ALUGADOS_INICIAL = LIVROS_ALUGADOS_INICIAL;
        this.livrosPorSessao = livrosPorSessao;
        this.preco = preco;
        this.tempoAluguel = tempoAluguel;
    }

    public Livro() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTOTAL_LIVROS_BIBLIOTECA() {
        return TOTAL_LIVROS_BIBLIOTECA;
    }

    public void setTOTAL_LIVROS_BIBLIOTECA(int TOTAL_LIVROS_BIBLIOTECA) {
        this.TOTAL_LIVROS_BIBLIOTECA = TOTAL_LIVROS_BIBLIOTECA;
    }

    public int getLIVROS_ALUGADOS_INICIAL() {
        return LIVROS_ALUGADOS_INICIAL;
    }

    public void setLIVROS_ALUGADOS_INICIAL(int LIVROS_ALUGADOS_INICIAL) {
        this.LIVROS_ALUGADOS_INICIAL = LIVROS_ALUGADOS_INICIAL;
    }

    public int getLivrosPorSessao() {
        return livrosPorSessao;
    }

    public void setLivrosPorSessao(int livrosPorSessao) {
        this.livrosPorSessao = livrosPorSessao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTempoAluguel() {
        return tempoAluguel;
    }

    public void setTempoAluguel(int tempoAluguel) {
        this.tempoAluguel = tempoAluguel;
    }
}