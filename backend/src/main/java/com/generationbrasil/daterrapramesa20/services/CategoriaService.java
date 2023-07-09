package com.generationbrasil.daterrapramesa20.services;

import com.generationbrasil.daterrapramesa20.dto.CategoriaDTO;
import com.generationbrasil.daterrapramesa20.entities.Categoria;
import com.generationbrasil.daterrapramesa20.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<CategoriaDTO> listarCategorias(){
        return categoriaRepository.findAll().stream().map(CategoriaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoriaDTO categoriaPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        Categoria cat = categoria.get();
        return new CategoriaDTO(cat);
    }
}
