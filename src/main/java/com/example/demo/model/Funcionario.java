package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float salario;

    public Funcionario(String nome, String cpf, long id, float salario) {
        super(nome, cpf);
        this.id = id;
        this.salario = salario;
    }

    public Funcionario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}