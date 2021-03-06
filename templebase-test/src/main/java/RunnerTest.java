import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "ru.bmstu.test",
        tags = "@databasetemple",
        dryRun = false,
        strict = false,
        snippets = SnippetType.UNDERSCORE
//        name = "^Успешное|Успешная.*"
)
public class RunnerTest {
}