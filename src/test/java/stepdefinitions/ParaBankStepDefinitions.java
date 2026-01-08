package stepdefinitions;

import com.bdd.interactions.EsperarElementoVisible;
import com.bdd.interactions.Pause;
import com.bdd.models.ParaBank.NuevoUsuarioParaBank;
import com.bdd.questions.ParaBank.MensajeVisible;
import com.bdd.tasks.ParaBank.LoguearUsuarioParaBank;
import com.bdd.tasks.ParaBank.RegistrarUsuarioEnParabank;
import com.bdd.utils.ConfigHelper;
import com.bdd.utils.JsonUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


import java.util.Map;
import java.util.logging.Logger;

import static com.bdd.userinterfaces.ParaBank.PBLoginUi.*;
import static com.bdd.userinterfaces.ParaBank.PBRegistroUi.*;
import static org.hamcrest.Matchers.is;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ParaBankStepDefinitions {

    private static final Logger LOGGER = Logger.getLogger(ParaBankStepDefinitions.class.getName());
    private EnvironmentVariables environmentVariables;

    @Before
    public void prepararEscenario() {
        ConfigHelper.loadAllEnvironmentProperties();
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario");
        LOGGER.info("Escenario preparado");
    }

    @Given("que el usuario accede a la web de Parabank")
    public void queElUsuarioAccedeALaWebDeParabank() {

        String parabankUrl = ConfigHelper.getProperty("url.parabank");
        System.out.println("Parabank URL: " + parabankUrl);
        theActorInTheSpotlight().attemptsTo(Open.url(parabankUrl));
    }

    @When("navega al formulario de registro de nuevos usuarios")
    public void navegaAlFormularioDeRegistroDeNuevosUsuarios() {
        theActorInTheSpotlight().attemptsTo(
                EsperarElementoVisible.por(BTN_REGISTRO,50),
                Click.on(BTN_REGISTRO),
                Pause.deSegundos(3)

        );

    }

    @And("proporciona sus datos personales:")
    public void proporcionaSusDatosPersonales(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMaps(String.class, String.class).get(0);
        NuevoUsuarioParaBank usuario = new NuevoUsuarioParaBank(datos);

        theActorInTheSpotlight().attemptsTo(
                RegistrarUsuarioEnParabank.conDatos(usuario)
        );
    }

    @And("completa el proceso de registro con la información ingresada")
    public void completaElProcesoDeRegistroConLaInformaciónIngresada() {
        theActorInTheSpotlight().attemptsTo(
                Pause.deSegundos(2),
                Click.on(BTN_REGISTRAR)

        );

    }

    @Then("debería poder iniciar sesión correctamente con las credenciales registradas")
    public void deberíaPoderIniciarSesiónCorrectamenteConLasCredencialesRegistradas() {
        String usuario = JsonUtil.leerValor("usuario", "DataRegistroParaBank.json");
        String contrasena = JsonUtil.leerValor("contrasena", "DataRegistroParaBank.json");
        theActorInTheSpotlight().attemptsTo(

                LoguearUsuarioParaBank.conCredenciales(usuario, contrasena)
        );
        theActorInTheSpotlight().should(
                seeThat("el mensaje de bienvenida sea visible",
                        MensajeVisible.en(LBL_MENSAJE_BIENVENIDA, 20),
                        is(true)
                )
        );


    }


    @And("que el usuario accede a la web de Parabank para loguearse")
    public void queElUsuarioAccedeALaWebDeParabankParaLoguearse() {
        Serenity.getWebdriverManager().closeCurrentDrivers();
        String parabankUrl = ConfigHelper.getProperty("url.parabank");
        System.out.println("Parabank URL: " + parabankUrl);
        theActorInTheSpotlight().attemptsTo(Open.url(parabankUrl));
    }
}