package com.example.estoque.service;

import com.example.estoque.entity.Categoria;
import com.example.estoque.entity.Produto;
import com.example.estoque.repositoty.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<Categoria> todos(){
        List<Categoria> categoria = categoriaRepository.findAll();
        return categoria;
    }

    public Categoria pegar(Long id){
        try{
            Optional<Categoria> p = categoriaRepository.findById(id);
            Categoria categoria = p.orElse(null);
            return categoria;
        }catch (Exception e){
            return null;
        }
    }

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long id,Categoria categoria){
        Categoria produto1 = categoriaRepository.getOne(id);
        produto1.setName(categoria.getName());
        return  categoriaRepository.save(produto1);
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }

}
