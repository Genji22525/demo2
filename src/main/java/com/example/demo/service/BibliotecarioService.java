package com.example.demo.service;

import com.example.demo.model.Bibliotecario;
import com.example.demo.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;



    public List<Bibliotecario> listar() {return bibliotecarioRepository.findAll();}

    public Bibliotecario criar(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }


    public Bibliotecario atualizar(Bibliotecario bibliotecario, Long id) {
        if(verificarPorId(id)) {
            bibliotecario.setId(id);
            return bibliotecarioRepository.save(bibliotecario);
        }
        return null;
    }


    public boolean deletar(Long id) {
        if (verificarPorId(id)){
            bibliotecarioRepository.deleteById(id);
            return true;

        }else {
            return false;
        }
    }
    public boolean verificarPorId(Long id) {
        return bibliotecarioRepository.existsById(id);
    }
}
