package com.generationbrasil.daterrapramesa20.repositories;

import com.generationbrasil.daterrapramesa20.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
