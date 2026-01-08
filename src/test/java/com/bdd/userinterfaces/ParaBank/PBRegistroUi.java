package com.bdd.userinterfaces.ParaBank;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PBRegistroUi {

    public static final Target BTN_REGISTRAR = Target.the("Botón para completar el registro")
            .locatedBy("//input[@value='Register']");

    public static final Target TXT_FIRST_NAME = Target.the("Campo First Name")
            .locatedBy("//input[@name='customer.firstName']");

    public static final Target TXT_LAST_NAME = Target.the("Campo Last Name")
            .locatedBy("//input[@name='customer.lastName']");

    public static final Target TXT_ADDRESS = Target.the("Campo Address")
            .locatedBy("//input[@name='customer.address.street']");

    public static final Target TXT_CITY = Target.the("Campo City")
            .locatedBy("//input[@name='customer.address.city']");

    public static final Target TXT_STATE = Target.the("Campo State")
            .locatedBy("//input[@name='customer.address.state']");

    public static final Target TXT_ZIP_CODE = Target.the("Campo Zip Code")
            .locatedBy("//input[@name='customer.address.zipCode']");

    public static final Target TXT_PHONE = Target.the("Campo Phone")
            .locatedBy("//input[@name='customer.phoneNumber']");

    public static final Target TXT_SSN = Target.the("Campo SSN")
            .locatedBy("//input[@name='customer.ssn']");

    public static final Target TXT_USERNAME = Target.the("Campo Username")
            .locatedBy("//input[@name='customer.username']");

    public static final Target TXT_PASSWORD = Target.the("Campo Password")
            .locatedBy("//input[@name='customer.password']");

    public static final Target TXT_CONFIRM_PASSWORD = Target.the("Campo Confirm Password")
            .locatedBy("//input[@name='repeatedPassword']");
}
