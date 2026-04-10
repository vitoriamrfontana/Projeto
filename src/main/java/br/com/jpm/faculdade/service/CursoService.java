package br.com.jpm.faculdade.service;

import br.com.jpm.faculdade.model.entity.Curso;
import br.com.jpm.faculdade.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository repository;

    public List<Curso> findAll() {
        return repository.findAll();

    }
    public Curso findById(Long id){
        Curso curso = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return curso;

    }
    public Optional <Curso> create(Curso curso){
        return Optional.ofNullable(curso);

    }
}
