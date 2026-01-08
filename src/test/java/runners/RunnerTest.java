package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests; // ✅ TestNG
import io.cucumber.testng.CucumberOptions;             // ✅ TestNG

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        tags = "@RegistroParaBank",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
