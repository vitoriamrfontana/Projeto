package br.com.jpm.faculdade.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int cargaHoraria;

    @ManyToMany(mappedBy = "disciplinas")
    @Column(nullable = false)
    private List<Curso> cursos;

}
