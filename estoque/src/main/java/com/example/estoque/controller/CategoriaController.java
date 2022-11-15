package com.example.estoque.controller;


import com.example.estoque.entity.Categoria;
import com.example.estoque.entity.Produto;
import com.example.estoque.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<Categoria>> todosProdutos(){
        List<Categoria> categoria = categoriaService.todos();
        return ResponseEntity.ok(categoria);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> pegarProduto(@PathVariable Long id){
        Categoria categoria = categoriaService.pegar(id);
        return ResponseEntity.ok().body(categoria);
    }
    @PostMapping
    public ResponseEntity<Categoria> salvaproduto(@RequestBody Categoria f){
        return ResponseEntity.ok(categoriaService.salvar(f));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> atualizarProduto(@PathVariable Long id,@RequestBody Categoria f){
        return ResponseEntity.ok(categoriaService.atualizar(id,f));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteproduto(@PathVariable Long id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
