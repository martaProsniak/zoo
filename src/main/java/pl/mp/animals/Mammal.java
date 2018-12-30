package pl.mp.animals;

/**
 * Mammal representation.
 */
public abstract class Mammal extends Animal {
    /**
     * Mammal fur color.
     */
    private String furColor;

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
}
