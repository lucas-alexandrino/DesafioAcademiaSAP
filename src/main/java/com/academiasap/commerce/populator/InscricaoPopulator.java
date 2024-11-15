package com.academiasap.commerce.populator;

import org.springframework.stereotype.Component;
import com.academiasap.commerce.model.entity.Aluno;
import com.academiasap.commerce.model.entity.Curso;
import com.academiasap.commerce.model.dto.AlunoDTO;
import com.academiasap.commerce.model.dto.CursoDTO;
import com.academiasap.commerce.model.dto.InscricaoDTO;

@Component
public class InscricaoPopulator {

    public AlunoDTO alunoToDTO(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }

        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        return dto;
    }

    public CursoDTO cursoToDTO(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("Curso não pode ser nulo.");
        }

        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        return dto;
    }

    public InscricaoDTO dtoInscricao(Curso curso, Aluno aluno) {
        if (curso == null || aluno == null) {
            throw new IllegalArgumentException("Curso ou aluno não podem ser nulos.");
        }

        AlunoDTO dtoAluno = alunoToDTO(aluno);
        CursoDTO dtoCurso = cursoToDTO(curso);

        return new InscricaoDTO(dtoAluno, dtoCurso);
    }
}
