package com.bdd.tasks.googleSearch;

import com.bdd.userinterfaces.GooglePage.GoogleHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.concurrent.TimeUnit;

public class PresionarBotonBuscar implements Task {

    public PresionarBotonBuscar(){

    }

    public static PresionarBotonBuscar enGoogle() {
        return Tasks.instrumented(PresionarBotonBuscar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(GoogleHomePage.SEARCH_BUTTON)
        );
    }
}