package com.academiasap.commerce.repository;

import com.academiasap.commerce.model.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long>  {
	
	List<Inscricao> findByCursoId(int cursoId);
	List<Inscricao> findByAlunoId(int alunoId);
}
