package com.bdd.userinterfaces.ParaBank;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PBLoginUi {


    public static final Target BTN_REGISTRO = Target.the("Botón para ingresar al modal de registro")
            .locatedBy("//a[normalize-space()='Register']");

    public static final Target TXT_USERNAME_LOGIN = Target.the("campo de usuario")
            .locatedBy("//input[@name='username']");

    public static final Target TXT_PASSWORD_LOGIN = Target.the("campo de contraseña")
            .locatedBy("//input[@name='password']");

    public static final Target BTN_LOGIN = Target.the("botón de Log In")
            .locatedBy("//input[@value='Log In']");

    public static final Target LBL_MENSAJE_BIENVENIDA = Target.the("mensaje de bienvenida al loguearte")
            .locatedBy("//h1[normalize-space(text())='Accounts Overview']");


}
