module JAX.RS {
    requires io.vavr;
    requires jakarta.jakartaee.api;
    requires lombok;

    requires modelmapper;
    requires org.yaml.snakeyaml;
    requires org.apache.logging.log4j;


    requires java.sql;
    requires java.naming;

    requires com.zaxxer.hikari;
    requires spring.jdbc;
//    requires org.hibernate.orm.core;


}
