package pl.mp.animals;

public class Mammal extends Animal {
    /**
     * Mammal fur collor.
     */
    private String furColor;

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    @Override
    public void eat() {
    }
}
