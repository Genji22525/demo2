package com.example.demo.controller;

import com.example.demo.model.Bibliotecario;
import com.example.demo.model.Funcionario;
import com.example.demo.service.BibliotecarioService;
import com.example.demo.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotecario")
public class BibliotecarioController {
    @Autowired
    private BibliotecarioService bibliotecarioService;


    @GetMapping
    public List<Bibliotecario> listar() {
        return bibliotecarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionario(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar (@Valid @RequestBody Bibliotecario bibliotecario) {
        Bibliotecario novoBibliotecario = bibliotecarioService.criar(bibliotecario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoBibliotecario);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> atualizarBibliotecario(@PathVariable Long id, @Valid @RequestBody Bibliotecario bibliotecario) {
        Bibliotecario bibliotecarioAtualizado = bibliotecarioService.atualizar(bibliotecario, id);
        if (bibliotecarioAtualizado != null) {
            return ResponseEntity.ok(bibliotecarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();


        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarBibliotecario(@PathVariable Long id) {
        boolean deletado = bibliotecarioService.deletar(id);
        if (deletado) {
            return ResponseEntity.ok("Bibliotecario excluido com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
