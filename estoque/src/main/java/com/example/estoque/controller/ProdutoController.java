package com.example.estoque.controller;

import com.example.estoque.entity.Funcionario;
import com.example.estoque.entity.Produto;
import com.example.estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> todosProdutos(){
        List<Produto> produto = produtoService.todosProduto();
        return ResponseEntity.ok(produto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> pegarProduto(@PathVariable Long id){
        Produto produto = produtoService.pegarProduto(id);
        return ResponseEntity.ok().body(produto);
    }
    @PostMapping
    public ResponseEntity<Produto> salvaproduto(@RequestBody Produto f){
        return ResponseEntity.ok(produtoService.salvarProduto(f));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id,@RequestBody Produto f){
        return ResponseEntity.ok(produtoService.atualizarProduto(id,f));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteproduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

}
