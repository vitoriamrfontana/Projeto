package br.com.jpm.faculdade.controller;

import br.com.jpm.faculdade.factory.DisciplinaFactory;
import br.com.jpm.faculdade.model.dto.request.DisciplinaRequestDTO;
import br.com.jpm.faculdade.model.dto.response.DisciplinaResponseDTO;
import br.com.jpm.faculdade.model.entity.Disciplina;
import br.com.jpm.faculdade.service.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

   @Autowired
    private DisciplinaService disciplinaService;

    /**
     *READ
     */

    @GetMapping("/{disciplinaId}")
   public ResponseEntity<DisciplinaResponseDTO> findDisciplinaById(@PathVariable Long disciplinaId) {
        return ResponseEntity.ok(disciplinaService.findByIdDto(disciplinaId));
   }
    /**
     * CREATE
     */

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> createDisciplina(@Valid @RequestBody DisciplinaRequestDTO dto){
        Disciplina disciplinaSalva = disciplinaService.create(dto);
        DisciplinaResponseDTO response = DisciplinaFactory.entityToResponse(disciplinaSalva);
        return ResponseEntity.ok(response);
    }

}