package br.com.jpm.faculdade.model.dto.response;

import br.com.jpm.faculdade.model.entity.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDTO {
    private String nome;
    private String codigo;
    private int duracao;
    private List<DisciplinaResponseDTO> disciplinasDTO;
}
