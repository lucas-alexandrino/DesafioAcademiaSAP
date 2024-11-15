package com.academiasap.commerce.model.dto;

public class AlunoDTO {


	private Long id;
	private String nome;

	
	public AlunoDTO() {}

		public AlunoDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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

		
	}


