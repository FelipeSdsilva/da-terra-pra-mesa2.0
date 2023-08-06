package com.generationbrasil.daterrapramesa20.services;

import com.generationbrasil.daterrapramesa20.dto.CategoriaDTO;
import com.generationbrasil.daterrapramesa20.dto.ProdutoDTO;
import com.generationbrasil.daterrapramesa20.entities.Categoria;
import com.generationbrasil.daterrapramesa20.entities.Produto;
import com.generationbrasil.daterrapramesa20.repositories.CategoriaRepository;
import com.generationbrasil.daterrapramesa20.repositories.ProdutoRepository;
import com.generationbrasil.daterrapramesa20.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public Page<ProdutoDTO> produtosPaginados(Pageable pageable) {
        return produtoRepository.findAll(pageable).map(ProdutoDTO::new);
    }

    @Transactional(readOnly = true)
    public ProdutoDTO produtoPorId(Long id) {
        return new ProdutoDTO(produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado" + id)));
    }

    @Transactional
    public ProdutoDTO novoProduto(ProdutoDTO dto) {
        Produto produto = new Produto();
        converterDtoEmEntidade(produto, dto);
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }


    @Transactional
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO dto) {
        try {

            Produto produto = produtoRepository.getReferenceById(id);
            converterDtoEmEntidade(produto, dto);
            produto = produtoRepository.save(produto);

            return new ProdutoDTO(produto);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
    }

    public void deletarProduto(Long id){

    }

    private void converterDtoEmEntidade(Produto produto, ProdutoDTO dto) {
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setQtd(dto.getQtd());
        produto.setImgUrl(dto.getImgUrl());

        produto.getCategorias().clear();

        for (CategoriaDTO catDto : dto.getCategorias()) {
            Categoria categoria = categoriaRepository.getReferenceById(catDto.getId());
            produto.getCategorias().add(categoria);
        }

    }
}
