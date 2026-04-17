package br.com.jpm.faculdade.model.dto.response;

import br.com.jpm.faculdade.model.entity.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaResponseDTO {

    private Long id;
    private String nome;
    private int cargaHoraria;
    private List<CursoResponseDTO> cursosDTO;
}
