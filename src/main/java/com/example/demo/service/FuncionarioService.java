package com.example.demo.service;


import com.example.demo.model.Funcionario;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService implements PessoaService<Funcionario> {

    @Autowired
    private FuncionarioRepository funcionarioRepository;





    public Optional<Funcionario> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public boolean verificarPorId(Long id) {
        return funcionarioRepository.existsById(id);
    }
    public int qtdFuncionarios() {
        return 10;
    }

    @Override
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario, Long id) {
        if(verificarPorId(id)) {
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;

    }

    @Override
    public boolean deletar(Long id) {
        if (verificarPorId(id)){
            funcionarioRepository.deleteById(id);
            return true;

        }else {
            return false;
        }
    }






}