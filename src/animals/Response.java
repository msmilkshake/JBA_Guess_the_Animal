package animals;

public enum Response {
    NEGATIVE(-1),
    NEUTRAL(0),
    POSITIVE(1);
    
    private final double weight;
    
    Response(int weight) {
        this.weight = weight;
    }
    
    public double val() {
        return weight;
    }
}
