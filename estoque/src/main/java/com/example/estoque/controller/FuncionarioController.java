package com.example.estoque.controller;

import com.example.estoque.entity.Funcionario;
import com.example.estoque.service.FuncionarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
    final Logger logger = LoggerFactory.getLogger(FuncionarioController.class);
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> todosFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.todos();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> pegarFuncionario(@PathVariable Long id){
        Funcionario funcionario = funcionarioService.pegar(id);
        return ResponseEntity.ok().body(funcionario);
    }
    @PostMapping
    public ResponseEntity<Funcionario> salva(@RequestBody Funcionario f){
        logger.info("Usuario cadastrado com sucesso!");
        return ResponseEntity.ok(funcionarioService.salvar(f));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,@RequestBody Funcionario f){
        logger.info("Usuario alterado com sucesso!");
        return ResponseEntity.ok(funcionarioService.atualizar(id,f));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id){
        funcionarioService.deleteFuncionario(id);
        logger.info("Usuario deletado com sucesso!");
        return ResponseEntity.noContent().build();
    }

}
