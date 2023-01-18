package com.springfelipe.springfelipe.repository;

import com.springfelipe.springfelipe.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public void salvar(Usuario usuario){
        if(usuario.getId()==null){
            System.out.println("SALVAR - Recebendo o usuário na camada de repositório");
        } else {
            System.out.println("ATUALIZAR - Recebendo o usuário na camada de repositório");
        }
        System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um registro", id));
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        System.out.println("LIST - Listado os usuários do sistema.");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Felipe Pereira","pass123"));
        usuarios.add(new Usuario("Daphne","pass123"));
        return usuarios;
    }

    public Usuario findByLogin(String login){
        System.out.println(String.format("FIND/login - Recebendo o login %s para realizar busca", login));
        return new Usuario("Felipe","pass");
    }
}
