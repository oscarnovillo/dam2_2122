package dao;

import modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class DaoPersonaImpl implements DaoPersona {

    public static List<Persona> personas;
    private static List<Persona> personasSeleccionadas;


    public DaoPersonaImpl() {
        if (personas == null) {
            personas = new ArrayList<>();
            personasSeleccionadas = new ArrayList<>();
        }
    }


    @Override
    public boolean addPersona(Persona p) {
        return personas.add(p);
    }
}




