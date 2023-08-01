package com.bruno.sgfuncionario.repositories;

import com.bruno.sgfuncionario.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
