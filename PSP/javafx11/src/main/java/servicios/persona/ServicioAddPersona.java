package servicios.persona;

import dao.DaoPersona;
import dao.DaoPersonaImpl;
import modelo.Persona;

public class ServicioAddPersona implements IServicioAddPersona {

    @Override
    public boolean addPersona(Persona p){
        DaoPersona dao = new DaoPersonaImpl();
        return dao.addPersona(p);
    }

}
