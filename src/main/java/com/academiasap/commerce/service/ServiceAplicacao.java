package com.academiasap.commerce.service;

import com.academiasap.commerce.populator.InscricaoPopulator;
import com.academiasap.commerce.repository.AlunoRepository;
import com.academiasap.commerce.repository.CursoRepository;
import com.academiasap.commerce.repository.InscricaoRepository;

import jakarta.persistence.EntityNotFoundException;

import com.academiasap.commerce.model.dto.AlunoDTO;
import com.academiasap.commerce.model.dto.CursoDTO;
import com.academiasap.commerce.model.dto.InscricaoDTO;
import com.academiasap.commerce.model.entity.Aluno;
import com.academiasap.commerce.model.entity.Curso;
import com.academiasap.commerce.model.entity.Inscricao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAplicacao {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	@Autowired
	private InscricaoPopulator populator;

	
	public AlunoDTO cadastrarAluno(String nome, String email) {
		try {
			Aluno aluno = new Aluno(nome, email);
			Aluno alunoSalvo = alunoRepository.save(aluno);
			return populator.alunoToDTO(alunoSalvo);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao cadastrar o aluno.", e);
		}
	}

	public CursoDTO cadastrarCurso(String nome, String descricao) {
		try {
			Curso curso = new Curso(nome, descricao);
			Curso cursoSalvo = cursoRepository.save(curso);
			return populator.cursoToDTO(cursoSalvo);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao cadastrar o curso.", e);
		}
	}

	public InscricaoDTO inscricao(int alunoId, int cursoId) {
		try {
			Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
			Curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));

			Inscricao inscricao = new Inscricao(aluno, curso);
			inscricaoRepository.save(inscricao);
			return populator.dtoInscricao(curso, aluno);
		} catch (EntityNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao realizar a inscrição.", e);
		}
	}

	public List<AlunoDTO> listarAlunosPorCurso(int cursoId) {
		try {
			List<Inscricao> inscricoes = inscricaoRepository.findByCursoId(cursoId);
			return inscricoes.stream().map(inscricao -> populator.alunoToDTO(inscricao.getAluno())).collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Erro ao listar alunos por curso.", e);
		}
	}

	public List<CursoDTO> listarCursosPorAluno(int alunoId) {
		try {
			List<Inscricao> inscricoes = inscricaoRepository.findByAlunoId(alunoId);
			return inscricoes.stream().map(inscricao -> populator.cursoToDTO(inscricao.getCurso())).collect(Collectors.toList());
		} catch (Exception e) {
			throw new RuntimeException("Erro ao listar cursos por aluno.", e);
		}
	}
}
