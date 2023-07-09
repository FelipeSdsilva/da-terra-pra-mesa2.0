package com.generationbrasil.daterrapramesa20.controllers;

import com.generationbrasil.daterrapramesa20.dto.CategoriaDTO;
import com.generationbrasil.daterrapramesa20.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(categoriaService.categoriaPorId(id));
    }

}
