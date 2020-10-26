package animals;

import java.util.Scanner;

public class TextUI {
    private static final TextUI instance;
    
    static {
        instance = new TextUI();
    }
    
    private final Scanner scn = new Scanner(System.in);
    private final ChatEngine engine = new ChatEngine();
    private Animal animal;
    
    private TextUI() {
    }
    
    public static TextUI get() {
        return instance;
    }
    
    public void start() {
        greet();
        inputAnimal();
        askUserForGuess();
    }
    
    private void askUserForGuess() {
        System.out.println("Is it " + animal + "?");
        while (true) {
            String userInput = scn.nextLine().trim();
            Response response = engine.processResponse(userInput);
            switch (response) {
                case NEGATIVE:
                    System.out.println("You answered: No.");
                    break;
                case NEUTRAL:
                    System.out.println(engine.askForClarification());
                    continue;
                case POSITIVE:
                    System.out.println("You answered: Yes.");
                    break;
                default:
                    break;
            }
            break;
        }
        System.out.println(engine.sayGoodbye());
    }
    
    private void greet() {
        System.out.println(engine.getGreetMsg());
    }
    
    private void inputAnimal() {
        System.out.println("Enter an animal:");
        String[] nounResult = engine.getNounWithArticle(scn.nextLine());
        animal = new Animal(nounResult[0], nounResult[1]);
    }
}