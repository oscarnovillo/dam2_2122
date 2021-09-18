package servicios.persona;

import dao.DaoPersona;
import modelo.Persona;
import modelo.Persona;

public class ServicioAddPersona {

    public boolean addPersona(Persona p){
        DaoPersona dao = new DaoPersona();
        return dao.addPersona(p);
    }

}
