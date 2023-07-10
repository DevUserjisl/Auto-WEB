package com.bdd.web.stepdefinitions;

import com.bdd.web.steps.GoogleSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class GoogleStepDefs {

    GoogleSteps googleSteps = new GoogleSteps();

    @Dado("que abro Google")
    public void queAbroGoogle() {
        googleSteps.openPage("https://google.com");
    }

//    @Cuando("escribo {string}")
//    public void escribo(String busqueda) throws InterruptedException {
//        googleSteps.search(busqueda);
//    }

    @Y("accedo al primer resultado")
    public void accedoAlPrimerResultado() {
        googleSteps.clickFirstResult();
    }

    @Entonces("valido que salí de Google")
    public void validoQueSalgoDeGoogle() throws InterruptedException {
        googleSteps.validarFueraDeGoogle();
    }

    @Entonces("valido que NO sali de Google")
    public void validoQueNOSaliDeGoogle() throws InterruptedException {
        googleSteps.validarPermanecerEnGoogle();
    }


    @Cuando("escribo {string}")
    public void escribo(String busqueda) throws InterruptedException {
        googleSteps.search(busqueda);
    }
}
