package gui;

import config.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public class Producers {


    @Produces
    @Named("url")
    public String getUrl()
    {
        return "jjj";
    }

    @Produces
    @Named("configDB")
    public String getDB()
    {
        return "jjj";
    }

    @Produces
    @Singleton
    public Validator createValidator(@Named("url")String s) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator;
    }

}
