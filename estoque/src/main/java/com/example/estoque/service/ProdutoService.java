package com.example.estoque.service;

import com.example.estoque.entity.Categoria;
import com.example.estoque.entity.Funcionario;
import com.example.estoque.entity.Produto;
import com.example.estoque.repositoty.CategoriaRepository;
import com.example.estoque.repositoty.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> todos(){
        List<Produto> produto = produtoRepository.findAll();
        return produto;
    }

    public Produto pegar(Long id){
        try{
            Optional<Produto> p = produtoRepository.findById(id);
            Produto produto = p.orElse(null);
            return produto;
        }catch (Exception e){
         return null;
        }
    }

    public Produto salvar(Produto produto){
        Set<Categoria> categorias = new HashSet<>();
        for (Categoria cat:
             produto.getCategorias()) {
            Optional<Categoria> categoria = categoriaRepository.findById(cat.getId());
            Categoria categoria1 = categoria.orElse(null);
            categorias.add(categoria1);
           // produto.getCategorias().add(categoria1);
        }
        produto.SetCategorias(categorias);
        return produtoRepository.save(produto);
    }
    public Produto atualizar(Long id,Produto produto){
        Optional<Produto> produto2 = produtoRepository.findById(id);
        Produto produto1 = produto2.orElse(null);
        produto1.setDescription(produto.getDescription());
        produto1.setName(produto.getName());
        produto1.setPrice(produto.getPrice());
        produto1.setImgUrl(produto.getImgUrl());
        produto1.getCategorias().clear();
        for (Categoria c : produto.getCategorias()){
          Optional<Categoria> cat = categoriaRepository.findById(c.getId());
          Categoria categoria = cat.orElse(null);
          produto1.addCategorias(categoria);
        }
        return  produtoRepository.save(produto1);
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }


}
