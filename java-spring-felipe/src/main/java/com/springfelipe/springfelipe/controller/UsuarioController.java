package com.springfelipe.springfelipe.controller;

import com.springfelipe.springfelipe.model.Usuario;
import com.springfelipe.springfelipe.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping()
    public List<Usuario> getUsuarios() {
       return repository.findAll();
    }

    @GetMapping("/{login}")
    public Usuario getOne(@PathVariable("login") String login){
        return repository.findByLogin(login);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping()
    public void post(@RequestBody Usuario usuario){
        repository.salvar(usuario);
    }
}
