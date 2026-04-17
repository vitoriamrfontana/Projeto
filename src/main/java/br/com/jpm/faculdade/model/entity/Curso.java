package br.com.jpm.faculdade.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int duracao;

    @Column(nullable = false)
    private String codigo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_disciplina",
            joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id", referencedColumnName = "id"))
    private List<Disciplina> disciplinas;

    public Curso(String nome, int duracao, String codigo) {
        this.nome = nome;
        this.duracao = duracao;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
