package br.com.jpm.faculdade.service;

import br.com.jpm.faculdade.factory.CursoFactory;
import br.com.jpm.faculdade.factory.DisciplinaFactory;
import br.com.jpm.faculdade.model.dto.request.CursoRequestDTO;
import br.com.jpm.faculdade.model.dto.response.CursoResponseDTO;
import br.com.jpm.faculdade.model.entity.Curso;
import br.com.jpm.faculdade.model.entity.Disciplina;
import br.com.jpm.faculdade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();

    }
    public List<CursoResponseDTO> findAllToDto() {
        return cursoRepository.findAll()
                .stream()
                .map(CursoFactory::entityToResponse)
                .collect(Collectors.toList());
    }

    public Optional<Curso> findById(Long id){
        return cursoRepository.findById(id);
    }
    public CursoResponseDTO findByIdDto(Long cursoId){
        return cursoRepository.findById(cursoId)
                .map(CursoFactory::entityToResponse)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

    }

    public Curso create(CursoRequestDTO dto){
        Curso curso = CursoFactory.dtoToEntityConstructor(dto);
        return cursoRepository.save(curso);
    }
    @Transactional
    public void delete(Long id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não é possivel deletar o curso: Curso não encontrado!"));
        cursoRepository.delete(curso);

    }
    @Transactional
    public CursoResponseDTO update(CursoRequestDTO dto){
        if (dto.getCursoId() == null){
            throw new RuntimeException("É necessario um Id para atualizar um curso!");
        }
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada!"));
        CursoFactory.updateEntity(curso, dto);
        Curso cursoUpdate = cursoRepository.save(curso);
        return CursoFactory.entityToResponse(cursoUpdate);

    }
}
