package com.bdd.questions.ParaBank;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

public class MensajeVisible implements Question<Boolean> {

    private final Target target;
    private final int segundosMaximos;

    public MensajeVisible(Target target, int segundosMaximos) {
        this.target = target;
        this.segundosMaximos = segundosMaximos;
    }

    public static MensajeVisible en(Target target, int segundosMaximos) {
        return new MensajeVisible(target, segundosMaximos);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor)
                .withTimeoutOf(Duration.ofSeconds(segundosMaximos))
                .isVisible();
    }
}