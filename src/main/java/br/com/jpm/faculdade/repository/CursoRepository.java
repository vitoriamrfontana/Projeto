package br.com.jpm.faculdade.repository;

import br.com.jpm.faculdade.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
