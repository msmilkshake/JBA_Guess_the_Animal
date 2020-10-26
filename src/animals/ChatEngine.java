package animals;

import java.time.LocalTime;
import java.util.Random;

public class ChatEngine {
    
    private final String[] negativeWords = {
            "n", "no", "no way", "nah", "nope", "negative",
            "i don't think so", "yeah no"
    };
    private final String[] positiveWords = {
            "y", "yes", "yeah", "yep", "sure", "right", "affirmative",
            "correct", "indeed", "you bet", "exactly", "you said it"
    };
    
    private final String[] clarificationQuestions = {
            "I'm not sure I caught you: was it yes or no?",
            "Funny, I still don't understand, is it yes or no?",
            "Oh, it's too complicated for me: just tell me yes or no.",
            "Could you please simply say yes or no?",
            "Oh, no, don't try to confuse me: say yes or no.",
            "Come on, yes or no?"
    };
    
    private final String[] goodbyePhrases = {
            "Have a nice day!",
            "See you soon!",
            "Bye!"
    };
    
    public String[] getNounWithArticle(String noun) {
        noun = noun.toLowerCase();
        String[] result = new String[2];
        if (noun.startsWith("a ") || noun.startsWith("an ")) {
            result = noun.split(" ", 2);
            result[1] = result[1].trim();
        } else {
            result[1] = noun.trim();
            if (noun.matches("[aeiou].*")) {
                result[0] = "an";
            } else {
                result[0] = "a";
            }
        }
        return result;
    }
    
    public String getGreetMsg() {
        String greetMsg;
        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.of(5, 0))
                && time.isBefore(LocalTime.of(12, 0))) {
            greetMsg = "Good morning";
        } else if (time.isAfter(LocalTime.of(12, 0))
                && time.isBefore(LocalTime.of(18, 0))) {
            greetMsg = "Good afternoon";
        } else {
            greetMsg = "Good evening";
        }
        return greetMsg;
    }
    
    public Response processResponse(String response) {
        Response sentiment = getResponseSentiment(response);
        
        return sentiment;
    }
    
    private Response getResponseSentiment(String response) {
        response = response.trim()
                .toLowerCase()
                .replaceAll("[.,!?]", "");
        for (String s : negativeWords) {
            if (s.equals(response)) {
                return Response.NEGATIVE;
            }
        }
        for (String s : positiveWords) {
            if (s.equals(response)) {
                return Response.POSITIVE;
            }
        }
        return Response.NEUTRAL;
    }
    
    public String sayGoodbye() {
        return getRandomFromArr(goodbyePhrases);
    }
    
    public String askForClarification() {
        return getRandomFromArr(clarificationQuestions);
    }
    
    private String getRandomFromArr(String[] arr) {
        return arr[new Random().nextInt(arr.length)];
    }
}
