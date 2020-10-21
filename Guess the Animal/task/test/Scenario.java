import animals.Main;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.TestedProgram;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.function.Predicate;

import static java.text.MessageFormat.format;
import static java.util.function.Predicate.not;
import static org.hyperskill.hstest.testcase.CheckResult.correct;
import static org.hyperskill.hstest.testcase.CheckResult.wrong;

public class Scenario {
    private final Object[][] data;
    private final String[][] script;
    private TestedProgram main;
    private String output = "";

    Scenario(String name) throws IOException {
        data = new YAMLMapper().readValue(new File("test/" + name + ".data.yaml"), String[][].class);
        script = new YAMLMapper().readValue(new File("test/" + name + ".script.yaml"), String[][].class);
    }

    CheckResult check() {
        for (var values : data) {
            for (var action : script) {
                switch (action[0]) {
                    case "start":
                        main = new TestedProgram(Main.class);
                        output = action.length == 1 ? main.start()
                                : main.start(format(action[1], values).split(" "));
                        continue;
                    case "input":
                        output = main.execute(format(action[1], values));
                        continue;
                    case "finish":
                        if (main.isFinished()) continue;
                        return wrong(format(action[1], values));
                    default:
                        final Map<String, Predicate<String>> validation = Map.of(
                                "contains", output::contains,
                                "not contains", not(output::contains),
                                "file exists", file -> new File(file).exists(),
                                "file delete", file -> new File(file).delete(),
                                "matches", output::matches);

                        if (validation.get(action[0]).test(format(action[1], values))) continue;
                        return wrong(format(action[2], values));
                }
            }
        }
        return correct();
    }

}