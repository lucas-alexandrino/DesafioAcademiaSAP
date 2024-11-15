package com.academiasap.commerce.repository;

import com.academiasap.commerce.model.entity.Aluno;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>  {
	
	public Optional<Aluno> findById(int alunoId);
	
}
