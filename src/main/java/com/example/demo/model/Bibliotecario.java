package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Bibliotecario extends Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int totalLivrosBiblioteca = 200; // Total de livros na biblioteca
    private int livrosAlugados = 25; // Livros já alugados inicialmente

    public Bibliotecario(String nome, String cpf, long id, float salario, long id1, int totalLivrosBiblioteca, int livrosAlugados) {
        super(nome, cpf, id, salario);
        this.id = id1;
        this.totalLivrosBiblioteca = totalLivrosBiblioteca;
        this.livrosAlugados = livrosAlugados;
    }

    public Bibliotecario() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public int getTotalLivrosBiblioteca() {
        return totalLivrosBiblioteca;
    }

    public void setTotalLivrosBiblioteca(int totalLivrosBiblioteca) {
        this.totalLivrosBiblioteca = totalLivrosBiblioteca;
    }

    public int getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(int livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }
}