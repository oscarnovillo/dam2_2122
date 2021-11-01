package dao.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UsuarioLoginDTO {

    private String id;

    @NotEmpty
    private String name;

    private String password;
}
