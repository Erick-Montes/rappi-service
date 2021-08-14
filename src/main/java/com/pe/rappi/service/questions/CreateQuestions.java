package com.pe.rappi.service.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class CreateQuestions {
    public Question<String> name(){
        return Question.about("The name")
                .answeredBy(
                        actor -> SerenityRest.lastResponse().jsonPath().getString("name")
                );
    }

    public Question<String> job(){
        return Question.about("The job")
                .answeredBy(
                        actor -> SerenityRest.lastResponse().jsonPath().getString("job")
                );
    }
}
