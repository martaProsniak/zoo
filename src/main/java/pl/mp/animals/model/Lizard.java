package pl.mp.animals.model;

/**
 * Lizard representation.
 */
public abstract class Lizard extends Animal {
    /**
     * Lizard scale color.
     */
    private String scaleColor;

    public String getColor() {
        return scaleColor;
    }

    public void setColor(String color) {
        this.scaleColor = color;
    }

}

