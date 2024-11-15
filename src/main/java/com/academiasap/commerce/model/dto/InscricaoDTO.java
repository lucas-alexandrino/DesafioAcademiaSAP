package com.academiasap.commerce.model.dto;

public class InscricaoDTO {
    private AlunoDTO aluno;
    private CursoDTO curso;


    public InscricaoDTO(AlunoDTO aluno, CursoDTO curso) {
        this.aluno = aluno;
        this.curso = curso;
    }


    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public CursoDTO getCurso() {
        return curso;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }
}
