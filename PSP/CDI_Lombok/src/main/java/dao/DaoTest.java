package dao;

import javax.enterprise.context.RequestScoped;


public interface DaoTest extends Dao<Test>{

    public int dameNumero();
    public String dameNombre();
}
