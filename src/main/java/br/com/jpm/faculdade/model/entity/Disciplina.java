package br.com.jpm.faculdade.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int cargaHoraria;

    @ManyToMany(mappedBy = "disciplinas")
    @Column(nullable = false)
    private List<Curso> cursos;

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "cargaHoraria=" + cargaHoraria +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
