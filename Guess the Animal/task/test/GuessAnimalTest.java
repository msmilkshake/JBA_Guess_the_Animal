import animals.Main;
import org.hyperskill.hstest.dynamic.input.DynamicTestingMethod;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.TestedProgram;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GuessAnimalTest extends StageTest<String> {
    public GuessAnimalTest() {
        super(Main.class);
    }

    @DynamicTestingMethod
    CheckResult testAnimals() throws IOException {
        return new Scenario("animals").check();
    }

    @DynamicTestingMethod
    CheckResult negativeAnswers() throws IOException {
        return new Scenario("negative-answers").check();
    }

    @DynamicTestingMethod
    CheckResult positiveAnswers() throws IOException {
        return new Scenario("positive-answers").check();
    }

    @DynamicTestingMethod
    CheckResult unclearAnswers() throws IOException {
        return new Scenario("unclear-answers").check();
    }

    @DynamicTestingMethod
    CheckResult testRandomGoodbye() throws IOException {
        final Set<String> goodbyes = new HashSet<>();

        for (int tries = 10; tries > 0; tries--) {
            final var main = new TestedProgram(Main.class);
            main.start();
            goodbyes.add(main.execute("cat\nyes\n"));
        }

        if (goodbyes.size() > 1) {
            return CheckResult.correct();
        } else {
            return CheckResult.wrong("You program should use different ways to say Goodbye!");
        }
    }
}