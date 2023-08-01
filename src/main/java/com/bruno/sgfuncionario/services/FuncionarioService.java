package com.bruno.sgfuncionario.services;

import com.bruno.sgfuncionario.entities.Funcionario;
import com.bruno.sgfuncionario.repositories.FuncionarioRepository;
import com.bruno.sgfuncionario.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Funcionario update(Long id, Funcionario obj) {
        try {
            Funcionario entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Funcionario entity, Funcionario obj) {
        entity.setNome(obj.getNome());
        entity.setDesignacao(obj.getDesignacao());
        entity.setEndereco(obj.getEndereco());
        entity.setSalario(obj.getSalario());
        entity.setTelefone(obj.getTelefone());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
