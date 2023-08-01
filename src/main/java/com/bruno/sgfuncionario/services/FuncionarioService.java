package com.bruno.sgfuncionario.services;

import com.bruno.sgfuncionario.entities.Funcionario;
import com.bruno.sgfuncionario.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario insert(Funcionario obj) {
        return repository.save(obj);
    }
}
