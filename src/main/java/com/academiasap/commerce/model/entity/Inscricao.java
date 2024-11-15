package com.academiasap.commerce.model.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Inscricao {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    
    
	@ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataInscricao = new Date();

		public Inscricao() {
    }
	
		public Inscricao( Aluno aluno, Curso curso) {
		this.aluno = aluno;
		this.curso = curso;
	}


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


		public Aluno getAluno() {
			return aluno;
		}


		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}


		public Curso getCurso() {
			return curso;
		}


		public void setCurso(Curso curso) {
			this.curso = curso;
		}

		

	
	}


