package com.example.demo.controller;


import com.example.demo.model.Livro;
import com.example.demo.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listar();
    }

    @PostMapping
    public Livro CriarLivro(@Valid @RequestBody Livro livro) {
        return livroService.criar(livro);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarLivro(@Valid @RequestBody Livro livro, @PathVariable long id) {
        if (livroService.atualizar(livro, id) == null) {
            String mensagem = "o id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);

        } else {
            return ResponseEntity.ok(livro);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable long id) {

        if (livroService.deletar(id)) {
            String msg = "o id " + id + " foi deletado com sucesso ";
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        } else {
            String msg = "o id não foi encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

}