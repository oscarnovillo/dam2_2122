package dao;

import EE.errores.ApiError;
import dao.modelo.Usuario;
import dao.modelo.UsuarioEntity;
import io.vavr.control.Either;
import jakarta.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/***
 *
 * edte emeetodo
 * @author
 *
 */
public class DaoUsuario {

    private static List<Usuario> usuarios = new ArrayList<>();


    static {
        usuarios.add(new Usuario("1", "nombre", "pass", LocalDateTime.now()));
    }


    private DBConnectionPool dbConnection;
//    private Session session;


    @Inject
    public DaoUsuario(DBConnectionPool dbConnection) {
//        this.session = session;
        this.dbConnection = dbConnection;
    }

    public Either<ApiError, Usuario> dameUsuarioPorNombre(String nombre) {
        Usuario u = usuarios.stream()
                .filter(usuario -> usuario.getName().equals(nombre))
                .findFirst().orElse(null);
        if (u != null) {
            return Either.right(u);
        } else {
            return Either.left(new ApiError("error not found", LocalDateTime.now()));
        }
    }


    public Either<ApiError, Usuario> dameUno(String id) {
        Usuario u = usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst().orElse(null);
        if (u != null) {
            return Either.right(u);
        } else {
            return Either.left(new ApiError("error not found", LocalDateTime.now()));
        }
    }

    public List<Usuario> dameTodos() {
        JdbcTemplate jtm = new JdbcTemplate(
                dbConnection.getDataSource());

        // select devuelve LIST
        return jtm.query("Select * from usuarios",
                BeanPropertyRowMapper.newInstance(Usuario.class));
    }

    public Usuario addUser(Usuario user) {

        UsuarioEntity userE = new UsuarioEntity();
        userE.setNombre(user.getName());
        userE.setPrecio(100.0);
//        session.beginTransaction();
//        session.save(userE);
//        session.getTransaction().commit();

        return user;
    }

    public boolean borrar(String id) {
        return usuarios.remove(usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst().orElse(null));
    }
}
