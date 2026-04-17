package br.com.jpm.faculdade.service;

import br.com.jpm.faculdade.factory.DisciplinaFactory;
import br.com.jpm.faculdade.model.dto.request.CursoRequestDTO;
import br.com.jpm.faculdade.model.dto.request.DisciplinaRequestDTO;
import br.com.jpm.faculdade.model.dto.response.DisciplinaResponseDTO;
import br.com.jpm.faculdade.model.entity.Curso;
import br.com.jpm.faculdade.model.entity.Disciplina;
import br.com.jpm.faculdade.repository.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    @Autowired
    CursoService cursoService;

    public List<Disciplina> findAll() {
        return repository.findAll();
    }
    public List<DisciplinaResponseDTO> findAllToDto(){
        return repository.findAll()
                .stream()
                .map(DisciplinaFactory::entityToResponse)
                .collect(Collectors.toList());
    }

    public Optional<Disciplina> findById(Long id) {
        return repository.findById(id);
    }
    public DisciplinaResponseDTO findByIdDto(Long disciplinaId){
        return repository.findById(disciplinaId)
                .map(DisciplinaFactory::entityToResponse)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }

    public Disciplina create(DisciplinaRequestDTO dto) {
        Curso curso = cursoService.findById(dto.getCursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado para criação de Disciplina"));

        Disciplina disciplina = DisciplinaFactory.dtoToEntityConstructorDisciplina(dto, curso);
        return repository.save(disciplina);
    }
}
