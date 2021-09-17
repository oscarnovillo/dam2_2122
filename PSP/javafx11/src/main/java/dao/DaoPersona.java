package dao;

import modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class DaoPersona {

    public static List<Persona> personas;
    private static List<Persona> personasSeleccionadas;


    public DaoPersona() {
        if (personas == null) {
            personas = new ArrayList<>();
            personasSeleccionadas = new ArrayList<>();
        }
    }


    public boolean addPersona(Persona p) {
        return personas.add(p);
    }
}




