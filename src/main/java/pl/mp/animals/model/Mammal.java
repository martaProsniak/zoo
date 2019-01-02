package pl.mp.animals.model;

/**
 * Mammal representation.
 */
public abstract class Mammal extends Animal {
    /**
     * Mammal fur color.
     */
    private String furColor;

    public String getColor() {
        return furColor;
    }

    public void setColor(String color) {
        this.furColor = color;
    }
}
