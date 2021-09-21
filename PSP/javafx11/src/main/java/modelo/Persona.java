package modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@ToString
public class Persona {

    private String nombre;
    private int edad;
    private boolean mujer;
    private LocalDate registro;


}
