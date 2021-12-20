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

    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.hibernate.orm.core;
    //requires jakarta.persistence;
   // requires org.hibernate.orm.core;


}
