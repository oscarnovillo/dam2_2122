package dao;

import EE.errores.BaseDatosCaidaException;
import EE.errores.CustomException;
import dao.modelo.Usuario;
import EE.errores.NotFoundException;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DaoErrores {


    public List<Usuario> dameTodos() {

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("99","nombre","pass", LocalDateTime.now()));

        Random r = new Random();

        if (r.nextBoolean())
            throw new BaseDatosCaidaException("Base Datos Caida");

        return usuarios;
    }

    public Usuario dameUsuario(String id) {
        Random r = new Random();

        if (r.nextBoolean())
            throw new NotFoundException("Usuario No encontrado");

        return new Usuario(id,"un usuario","pass", LocalDateTime.now());
    }
}
