package animals;

public class Animal {
    private final String article;
    private final String name;
    
    public Animal(String article, String name) {
        this.article = article;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return article + " " + name;
    }
}
