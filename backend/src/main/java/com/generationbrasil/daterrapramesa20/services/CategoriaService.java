package com.generationbrasil.daterrapramesa20.services;

import com.generationbrasil.daterrapramesa20.dto.CategoriaDTO;
import com.generationbrasil.daterrapramesa20.repositories.CategoriaRepository;
import com.generationbrasil.daterrapramesa20.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return new CategoriaDTO(categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada " + id)));
    }
}
