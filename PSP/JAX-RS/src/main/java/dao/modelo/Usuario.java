package dao.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private String id;

    @NotEmpty
    private String name;

    private String password;

    private LocalDateTime fecha;

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
