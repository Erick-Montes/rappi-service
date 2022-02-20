package com.pe.rappi.service.stepsdefinitions;

import com.pe.rappi.service.questions.CreateQuestions;
import com.pe.rappi.service.tasks.Create;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreateUsersStepsDefinitions {

    EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que el (.*) accede al servicio$")
    public void queElClienteAccedeAlServicio(String client) {
        theActorCalled(client).whoCan(CallAnApi.at(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url")));
    }

    @When("^el ingresa su nombre (.*) y posicion (.*)$")
    public void elIngresaSuNombreYPosicion(String name, String job) {
        theActorInTheSpotlight().attemptsTo(Create.with(name, job));
    }

    @Then("^el valida que su nombre (.*) y su posicion (.*) fueron creados correctamente$")
    public void elValidaQueSuNombreYSuPosicionFueronCreadosCorrectamente(String name, String job) {
        theActorInTheSpotlight().should(seeThat("validate name", new CreateQuestions().name(), equalTo(name))
                , seeThat("validate job", new CreateQuestions().job(), equalTo(job)));
    }

    @Given("que el se encuentra en el modal del login")
    public void queElSeEncuentraEnElModalDelLogin() {
        
    }

    @When("el ingresa su celular {int} y su dni {int}")
    public void elIngresaSuCelularYSuDni(int arg0, int arg1) {
        
    }

    @Then("el logra ingresar a la plataforma")
    public void elLograIngresarALaPlataforma() {
    }
}
