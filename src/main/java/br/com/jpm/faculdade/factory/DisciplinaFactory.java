package br.com.jpm.faculdade.factory;

import br.com.jpm.faculdade.model.dto.request.DisciplinaRequestDTO;
import br.com.jpm.faculdade.model.dto.response.DisciplinaResponseDTO;
import br.com.jpm.faculdade.model.entity.Curso;
import br.com.jpm.faculdade.model.entity.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaFactory {

    public static Disciplina dtoToEntityConstructorDisciplina(DisciplinaRequestDTO dto, Curso curso) {

        // 1. Criando a disciplina a partir do DTO
        Disciplina disciplina = new Disciplina(
                dto.getNome(),
                dto.getCargaHoraria()
        );

        System.out.println("📌 Após criar Disciplina:");
        System.out.println("Nome: " + disciplina.getNome());
        System.out.println("Carga Horária: " + disciplina.getCargaHoraria());

        // 2. Garantindo que a lista de cursos da disciplina não seja nula
        if (disciplina.getCursos() == null) {
            disciplina.setCursos(new ArrayList<>());
        }

        // 3. Adicionando o curso à disciplina
        disciplina.getCursos().add(curso);

        // 4. Garantindo que a lista de disciplinas do curso não seja nula
        if (curso.getDisciplinas() == null) {
            curso.setDisciplinas(new ArrayList<>());
        }

        // 5. Adicionando a disciplina ao curso (relacionamento bidirecional)
        curso.getDisciplinas().add(disciplina);

        System.out.println("🔗 Após criar relacionamento:");
        System.out.println("Cursos vinculados à disciplina: " + disciplina.getCursos().size());
        System.out.println("Disciplinas vinculadas ao curso: " + curso.getDisciplinas().size());

        // 6. Retornando a entidade pronta
        return disciplina;
    }

    public static Disciplina dtoToEntitySetGetDisciplina(DisciplinaRequestDTO dto, Curso curso) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());
        disciplina.setCargaHoraria(dto.getCargaHoraria());

        if (disciplina.getCursos() == null){
            disciplina.setCursos(new ArrayList<>());
        }
        disciplina.getCursos().add(curso);

        if (curso.getDisciplinas() == null){
            curso.setDisciplinas(new ArrayList<>());
        }
        curso.getDisciplinas().add(disciplina);

        return disciplina;
    }
    public static DisciplinaRequestDTO entityToDtoSetGet(Disciplina disciplina){
        DisciplinaRequestDTO dto = new DisciplinaRequestDTO();
        dto.setNome(dto.getNome());
        dto.setCargaHoraria(dto.getCargaHoraria());
        dto.setCursoId(dto.getCursoId());
        return dto;
    }

    public static DisciplinaResponseDTO entityToResponse(Disciplina disciplina){
        DisciplinaResponseDTO resp = new DisciplinaResponseDTO();
        resp.setId(disciplina.getId());
        resp.setNome(disciplina.getNome());
        resp.setCargaHoraria(disciplina.getCargaHoraria());
        return resp;
    }

    public static List<DisciplinaResponseDTO> entityToResponse(List<Disciplina> disciplinas) {
        List<DisciplinaResponseDTO> disciplinasDTO = new ArrayList<>();

        for (Disciplina disciplina : disciplinas) {
            DisciplinaResponseDTO disciplinaDTO = new DisciplinaResponseDTO();
            disciplinaDTO.setId(disciplina.getId());
            disciplinaDTO.setNome(disciplina.getNome());
            disciplinaDTO.setCargaHoraria(disciplinaDTO.getCargaHoraria());
            disciplinasDTO.add(disciplinaDTO);
        }

        return disciplinasDTO;
    }

}
