package com.generationbrasil.daterrapramesa20.services;

import com.generationbrasil.daterrapramesa20.dto.CategoriaDTO;
import com.generationbrasil.daterrapramesa20.entities.Categoria;
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
    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll().stream().map(CategoriaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoriaDTO categoriaPorId(Long id) {
        return new CategoriaDTO(categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não encontrado o Id:" + id)));
    }

    @Transactional
    public CategoriaDTO inserindoNovaCategoria(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria);
    }

    @Transactional
    public CategoriaDTO atualizarCategoria(Long id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        categoria.setNome(dto.getNome());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria);
    }

    public void deletarCategoriaPorId(Long id) {
        categoriaRepository.deleteById(id);
    }

}
