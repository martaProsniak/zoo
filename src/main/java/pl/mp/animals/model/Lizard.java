package pl.mp.animals.model;

/**
 * Lizard representation.
 */
public abstract class Lizard extends Animal {
    /**
     * Lizard scale color.
     */
    private String scaleColor;

    public String getScaleColor() {
        return scaleColor;
    }

    public void setScaleColor(String scaleColor) {
        this.scaleColor = scaleColor;
    }

}

