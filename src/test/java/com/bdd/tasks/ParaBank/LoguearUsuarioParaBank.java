package com.bdd.tasks.ParaBank;

import com.bdd.interactions.EsperarElementoVisible;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

import static com.bdd.userinterfaces.ParaBank.PBLoginUi.*;

public class LoguearUsuarioParaBank implements Task {

    private final String usuario;
    private final String contrasena;

    public LoguearUsuarioParaBank(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static LoguearUsuarioParaBank conCredenciales(String usuario, String contrasena) {
        return Tasks.instrumented(LoguearUsuarioParaBank.class, usuario, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarElementoVisible.por(TXT_USERNAME_LOGIN,40),
                Enter.theValue(usuario).into(TXT_USERNAME_LOGIN),
                Enter.theValue(contrasena).into(TXT_PASSWORD_LOGIN),
                Click.on(BTN_LOGIN)
        );
    }
}
