package dao.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
public class UsuarioGetDTO {

    @NotEmpty
    private String name;
}
