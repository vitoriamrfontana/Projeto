package br.com.jpm.faculdade.model.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DisciplinaRequestDTO {

    @Nullable
    private Long disciplinaId;

    @NotNull(message = "Para criar uma Disciplina é necessário passar um Curso")
    private Long cursoId;

    @NotBlank(message = "O nome da Disciplina deve ser informado!")
    private String nome;

    @NotNull(message = "A carga Horaria deve ser informada!")
    @Min(value = 300, message = " O minimo")
    @Max(value = 2000, message = " O maximo")
    private int cargaHoraria;
}
