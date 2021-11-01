/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;


/**
 * @author dam2
 */
@Getter
@Setter
@Log4j2
public class Configuration {

    private static Configuration config;
    private String ruta;
    private String user;
    private String password;

    private Configuration() {

    }

    public static Configuration cargarInstance(InputStream file) {

        if (config == null) {
            try {
                Yaml yaml = new Yaml();
                config = yaml.loadAs(file,
                        Configuration.class);
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
        }
        return config;
    }

    public static Configuration getInstance() {

        return config;
    }
}
