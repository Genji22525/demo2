package com.example.demo.controller;


import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionario(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@Valid @RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.criar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizar(funcionario, id);
        if (funcionarioAtualizado != null) {
            return ResponseEntity.ok(funcionarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFuncionario(@PathVariable Long id) {
        boolean deletado = funcionarioService.deletar(id);
        if (deletado) {
            return ResponseEntity.ok("Funcionário deletado com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}