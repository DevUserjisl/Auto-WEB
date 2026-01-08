package com.bdd.tasks.ParaBank;


import com.bdd.models.ParaBank.NuevoUsuarioParaBank;
import com.bdd.utils.JsonUtil;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;


import static com.bdd.userinterfaces.ParaBank.PBRegistroUi.*;

public class RegistrarUsuarioEnParabank implements Task {

    private final NuevoUsuarioParaBank usuario;

    public RegistrarUsuarioEnParabank(NuevoUsuarioParaBank usuario) {
        this.usuario = usuario;
    }

    public static RegistrarUsuarioEnParabank conDatos(NuevoUsuarioParaBank usuario) {
        return Tasks.instrumented(RegistrarUsuarioEnParabank.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Enter.theValue(usuario.getFirstName()).into(TXT_FIRST_NAME),
                Enter.theValue(usuario.getLastName()).into(TXT_LAST_NAME),
                Enter.theValue(usuario.getAddress()).into(TXT_ADDRESS),
                Enter.theValue(usuario.getCity()).into(TXT_CITY),
                Enter.theValue(usuario.getState()).into(TXT_STATE),
                Enter.theValue(usuario.getZipCode()).into(TXT_ZIP_CODE),
                Enter.theValue(usuario.getPhone()).into(TXT_PHONE),
                Enter.theValue(usuario.getSsn()).into(TXT_SSN)
        );
        String Username = usuario.getUsername();
        String Password = usuario.getPassword();
        JsonUtil.guardarValor("usuario", "DataRegistroParaBank.json", Username);
        JsonUtil.guardarValor("contrasena", "DataRegistroParaBank.json", Password);
        String UsernameGenerado = JsonUtil.leerValor("usuario", "DataRegistroParaBank.json");
        String PasswordGenerado = JsonUtil.leerValor("contrasena", "DataRegistroParaBank.json");
        actor.attemptsTo(
                Enter.theValue(UsernameGenerado).into(TXT_USERNAME),
                Enter.theValue(PasswordGenerado).into(TXT_PASSWORD),
                Enter.theValue(PasswordGenerado).into(TXT_CONFIRM_PASSWORD)
        );
    }
}
