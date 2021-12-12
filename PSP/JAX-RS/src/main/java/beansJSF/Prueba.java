package beansJSF;



import jakarta.enterprise.inject.Model;


import java.io.Serializable;


@Model
public class Prueba implements Serializable {
    private String mensaje = "tonteria";

    private int numero = 2;

    public Prueba() {

        mensaje = "desd eel cter";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String dameLink()
    {
        return "test/test";
    }
}
