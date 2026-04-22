package br.com.jpm.faculdade.factory;

import br.com.jpm.faculdade.model.dto.request.CursoRequestDTO;
import br.com.jpm.faculdade.model.dto.response.CursoResponseDTO;
import br.com.jpm.faculdade.model.dto.response.DisciplinaResponseDTO;
import br.com.jpm.faculdade.model.entity.Curso;
import br.com.jpm.faculdade.model.entity.Disciplina;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CursoFactory {


    public static Curso dtoToEntitySetGet(CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setCodigo(dto.getCodigo());
        curso.setNome(dto.getNome());
        curso.setDuracao(dto.getDuracao());
        return curso;
    }

    public static CursoRequestDTO entityToDtoSetGet(Curso curso) {
        CursoRequestDTO dto = new CursoRequestDTO();
        dto.setCodigo(curso.getCodigo());
        dto.setNome(curso.getNome());
        dto.setDuracao(curso.getDuracao());
        return dto;
    }

    public static Curso dtoToEntityConstructor(CursoRequestDTO dto) {
        Curso curso = new Curso(
                dto.getNome(),
                dto.getDuracao(),
                dto.getCodigo()
        );
        return curso;
    }

    public static CursoResponseDTO entityToResponse(Curso curso) {
        CursoResponseDTO responseDto = new CursoResponseDTO();
        responseDto.setNome(curso.getNome());
        responseDto.setCodigo(curso.getCodigo());
        responseDto.setDuracao(curso.getDuracao());

        List<DisciplinaResponseDTO> disciplinasDTO = new ArrayList<>();
        for(Disciplina disciplina : curso.getDisciplinas()){

            DisciplinaResponseDTO disciplinaDTO = new DisciplinaResponseDTO();

            disciplinaDTO.setId(disciplina.getId());
            disciplinaDTO.setNome(disciplina.getNome());
            disciplinaDTO.setCargaHoraria(disciplina.getCargaHoraria());

            disciplinasDTO.add(disciplinaDTO);
        }

        responseDto.setDisciplinasDTO(disciplinasDTO);

        return responseDto;

    }
    public static void updateEntity(Curso curso, CursoRequestDTO dto){
        curso.setNome(dto.getNome());
        curso.setCodigo(dto.getCodigo());
        curso.setDuracao(dto.getDuracao());
    }
}