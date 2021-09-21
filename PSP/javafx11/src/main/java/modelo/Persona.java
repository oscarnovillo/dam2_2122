package modelo;

import lombok.*;

import java.time.LocalDate;


@Getter @Setter @ToString
public class Persona {

    private String nombre;
    private int edad;
    private boolean mujer;
    private LocalDate registro;


}
