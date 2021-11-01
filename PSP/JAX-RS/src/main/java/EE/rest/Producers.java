package EE.rest;

import org.modelmapper.ModelMapper;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class Producers {


    @Produces
    public ModelMapper producesModelMapper()
    {
        return new ModelMapper();
    }

    @Produces
    public Jsonb producesJsonb()
    {
        return JsonbBuilder.create();
    }
}
