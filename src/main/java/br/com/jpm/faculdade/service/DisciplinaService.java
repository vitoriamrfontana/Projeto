package br.com.jpm.faculdade.service;

import br.com.jpm.faculdade.model.entity.Disciplina;
import br.com.jpm.faculdade.repository.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public List<Disciplina> findAll(){
        return repository.findAll();
    }

    public Disciplina findById(Long id){
        Disciplina disciplina = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return disciplina;
    }
    public Optional<Disciplina> create(Disciplina disciplina){
        return Optional.ofNullable(disciplina);
    }
}
