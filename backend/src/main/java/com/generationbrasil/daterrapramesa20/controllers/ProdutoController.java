package com.generationbrasil.daterrapramesa20.controllers;

import com.generationbrasil.daterrapramesa20.dto.ProdutoDTO;
import com.generationbrasil.daterrapramesa20.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;


    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> recuperarTodosProdutosPaginado(Pageable pageable) {
        return ResponseEntity.ok().body(service.produtosPaginados(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> recuperarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.produtoPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> inserirProduto(@RequestBody ProdutoDTO dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.novoProduto(dto));
    }
}
