/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.quevedo.servidor.config;

import jakarta.inject.Singleton;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

@Getter
@Singleton
@Log4j2
public class ConfigurationQuevedo {

    private String ruta;
    private String user;
    private String password;
    private String driver;
    private String rutaKeyStores;

    public ConfigurationQuevedo() {

        try {
            Yaml yaml = new Yaml();

            Iterable<Object> it = null;

            it = yaml
                    .loadAll(this.getClass().getClassLoader().getResourceAsStream("config.yaml"));

            Map<String, String> m = (Map) it.iterator().next();
            this.ruta = m.get("ruta");
            this.password = m.get("password");
            this.user = m.get("user");
            this.driver = m.get("driver");
            this.rutaKeyStores    = m.get("rutaKeyStores");


        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
