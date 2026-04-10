package br.com.jpm.faculdade.repository;

import br.com.jpm.faculdade.model.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
