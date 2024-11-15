package com.academiasap.commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academiasap.commerce.model.dto.AlunoDTO;
import com.academiasap.commerce.model.dto.CursoDTO;
import com.academiasap.commerce.model.dto.InscricaoDTO;
import com.academiasap.commerce.service.ServiceAplicacao;


import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping("/gerenciamento")
public class Controller {
	
	@Autowired
	private ServiceAplicacao serviceAplicacao;

	@PostMapping("/cadastraraluno/{nome}/{email}")
	public ResponseEntity<String> cadastrarAluno(@PathVariable String nome, @PathVariable String email) {
		try {
			AlunoDTO alunoDTO = serviceAplicacao.cadastrarAluno(nome, email);
			return ResponseEntity.ok("O Aluno: " + alunoDTO.getNome() + " foi criado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar aluno: " + e.getMessage());
		}
	}

	@PostMapping("/cadastrarcurso/{nome}/{descricao}")
	public ResponseEntity<String> cadastrarCurso(@PathVariable String nome, @PathVariable String descricao) {
		try {
			CursoDTO cursoDTO = serviceAplicacao.cadastrarCurso(nome, descricao);
			return ResponseEntity.ok("O Curso: " + cursoDTO.getNome() + " foi criado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar curso: " + e.getMessage());
		}
	}

	@PostMapping("/inscricao/{alunoId}/{cursoId}")
	public ResponseEntity<String> inscricao(@PathVariable int alunoId, @PathVariable int cursoId) {
		try {
			InscricaoDTO inscricaoDTO = serviceAplicacao.inscricao(alunoId, cursoId);
			return ResponseEntity.ok("Aluno: " + inscricaoDTO.getAluno().getNome() + " foi inscrito com sucesso no curso: " + inscricaoDTO.getCurso().getNome());
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar inscrição.");
		}
	}

	@GetMapping("/cursosaluno/{alunoId}")
	public ResponseEntity<List<CursoDTO>> listarCursosPorAluno(@PathVariable int alunoId) {
		List<CursoDTO> cursos = serviceAplicacao.listarCursosPorAluno(alunoId);
		if (cursos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cursos);
	}

	@GetMapping("/alunoslista/{cursoId}")
	public ResponseEntity<List<AlunoDTO>> listarAlunosPorCurso(@PathVariable int cursoId) {
		List<AlunoDTO> alunos = serviceAplicacao.listarAlunosPorCurso(cursoId);
		if (alunos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(alunos);
	}
}
