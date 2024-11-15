package com.academiasap.commerce.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Aluno {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String nome;
    private String email;
    
	@Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro = new Date();
    
    @OneToMany(mappedBy = "aluno")
    private Set<Inscricao> inscricoes = new HashSet<>();


	public Aluno() {}
		
		public Aluno(String nome, String email) {
			this.nome = nome;
			this.email = email;

		}
		

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		

	
	}


