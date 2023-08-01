package com.bruno.sgfuncionario.services;

import com.bruno.sgfuncionario.entities.Funcionario;
import com.bruno.sgfuncionario.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario insert(Funcionario obj) {
        return repository.save(obj);
    }

    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    public Funcionario findById(Long id) {
        Optional<Funcionario> obj = repository.findById(id);
        return obj.get();
    }
}
