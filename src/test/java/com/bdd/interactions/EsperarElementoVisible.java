package com.bdd.interactions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class EsperarElementoVisible implements Interaction {

    private final Target target;
    private final int segundos;

    public EsperarElementoVisible(Target target, int segundos) {
        this.target = target;
        this.segundos = segundos;
    }

    public static EsperarElementoVisible por(Target target, int segundos) {
        return new EsperarElementoVisible(target, segundos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(target, WebElementStateMatchers.isVisible()).forNoMoreThan(segundos).seconds());
    }
}

