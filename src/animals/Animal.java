package animals;

public class Animal {
    private String article;
    private String name;
    
    public Animal(String article, String name) {
        this.article = article;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return article + " " + name;
    }
}
