package br.com.jpm.faculdade.model.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoRequestDTO {

    @NotBlank(message = "O nome do curso deve ser informado!")
    private String nome;

    @NotNull(message = "A duracao do curso deve ser informada!")
    @Min(value = 100, message = "O mínimo")
    @Max(value = 6000, message = "O máximo")
    private int duracao;

    @NotBlank(message = "O codigo deve ser informado!")
    private String codigo;




}
