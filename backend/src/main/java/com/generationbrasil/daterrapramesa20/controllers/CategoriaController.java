package com.generationbrasil.daterrapramesa20.controllers;

import com.generationbrasil.daterrapramesa20.dto.CategoriaDTO;
import com.generationbrasil.daterrapramesa20.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarTodasAsCategorias() {
        return ResponseEntity.ok().body(categoriaService.listarCategorias());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoriaService.categoriaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> inserindoNovaCategoria(@RequestBody CategoriaDTO dto) {
        dto = categoriaService.inserindoNovaCategoria(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        return ResponseEntity.ok().body(categoriaService.atualizarCategoria(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoriaPorId(id);
        return ResponseEntity.noContent().build();
    }
}
