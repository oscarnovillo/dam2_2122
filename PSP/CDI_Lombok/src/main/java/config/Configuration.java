/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.Yaml;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Optional;

/**
 * @author dam2
 */
@Getter
@Setter
@Singleton
public class Configuration {


    private String ruta;
    private String user;
    private String password;

    public Configuration() throws FileNotFoundException {

        Yaml yaml = new Yaml();

        Iterable<Object> it = null;

        it = yaml
                .loadAll(new FileInputStream("config/config.yaml"));


        Map<String, String> m = (Map) it.iterator().next();
        this.ruta = m.get("ruta");
        this.user = m.get("user");
        this.password = m.get("password");
        this.ruta = Optional.ofNullable(System.getenv("ruta")).orElseGet(() -> m.get("ruta"));

    }

}
