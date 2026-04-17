package br.com.jpm.faculdade.controller;

import br.com.jpm.faculdade.factory.CursoFactory;
import br.com.jpm.faculdade.model.dto.request.CursoRequestDTO;
import br.com.jpm.faculdade.model.dto.response.CursoResponseDTO;
import br.com.jpm.faculdade.model.entity.Curso;
import br.com.jpm.faculdade.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    /**
     *READ
     */

    @GetMapping("/{cursoId}")
    public ResponseEntity<CursoResponseDTO> findCursoById(@PathVariable Long cursoId) {
        return ResponseEntity.ok(cursoService.findByIdDto(cursoId));
    }

    /**
     * CREATE
     */

    @PostMapping
    public ResponseEntity<?> createCurso(@Valid @RequestBody CursoRequestDTO dto) {
        return ResponseEntity.ok(cursoService.create(dto));
    }

}
