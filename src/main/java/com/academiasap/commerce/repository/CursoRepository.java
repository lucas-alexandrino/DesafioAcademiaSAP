package com.academiasap.commerce.repository;

import com.academiasap.commerce.model.entity.Curso;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>  {
	
	public Optional<Curso> findById(int cursoId);
	
}
