package br.com.jpm.faculdade.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int duracao;

    private String codigo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_disciplina",
            joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName = "id"))
    private List<Disciplina> disciplinas;
}
