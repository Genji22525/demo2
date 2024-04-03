package com.example.demo.service;



import com.example.demo.model.Livro;
import com.example.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService  {

    @Autowired
    private LivroRepository livroRepository;
    private boolean verificarPorid;
    private Livro livroAtualizado;


    public List listar() {
        return livroRepository.findAll();
    }


    public Livro criar(Livro livro) {
        return livroRepository.save(livro);

    }


    public Livro atualizar(Livro livro, Long id) {
        if (verificarPorid(id)) {
            livro.setId(id);
            return livroRepository.save(livroAtualizado);
        }
        return null;
    }




    public boolean deletar(long id){
        if (verificarPorid(id)) {
            livroRepository.deleteById(id);
            return true;

        }else {
            return false;
        }

    }

    private boolean verificarPorid(long id) {
        return livroRepository.existsById(id);
    }
}
