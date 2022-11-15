package com.example.estoque.service;

import com.example.estoque.entity.Categoria;
import com.example.estoque.entity.Endereco;
import com.example.estoque.entity.Funcionario;
import com.example.estoque.repositoty.EnderecoRepository;
import com.example.estoque.repositoty.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> todos(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios;
    }

    public Funcionario pegar(Long id){
       Optional<Funcionario> F = funcionarioRepository.findById(id);
       Funcionario funcionario = F.orElse(null);
       return funcionario;
    }

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(Long id,Funcionario funcionario){
        Optional<Funcionario> funcionario2 = funcionarioRepository.findById(id);
        Funcionario funcionario1 = funcionario2.orElse(null);
        funcionario1.setContato(funcionario.getContato());
        funcionario1.setNome(funcionario.getNome());
        funcionario1.setCpf(funcionario.getCpf());
        funcionario1.setEmail(funcionario.getEmail());
        funcionario1.setEnderecos(funcionario.getEnderecos());

        return  funcionarioRepository.save(funcionario1);
    }
    public void deleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }
}
