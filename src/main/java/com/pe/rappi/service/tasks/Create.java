package com.pe.rappi.service.tasks;

import com.google.gson.JsonObject;
import com.pe.rappi.service.utils.Utils;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static com.pe.rappi.service.utils.WebServiceEndpoints.*;

public class Create implements Task {

    Utils utils = new Utils();

    private final String name;
    private final String job;


    public Create(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    @Step("{0} enter his name #name and job #job")
    public <T extends Actor> void performAs(T actor) {
        String file = "create.json";
        JsonObject createJson = null;
        try {
            createJson = utils.getJsonFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject dataCreateUsersJson = createJson;
        dataCreateUsersJson.addProperty("name", name);
        dataCreateUsersJson.addProperty("job", job);

        actor.attemptsTo((Post.to(USERS.getUrl()).with(requestSpecification -> requestSpecification.given().log().all().contentType("application/json")
                .and().body(dataCreateUsersJson.toString()))));

        SerenityRest.then().log().all();
    }

    public static Create with(String name, String job) {
        return instrumented(Create.class, name, job);
    }
}
