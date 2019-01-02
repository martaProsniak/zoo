package pl.mp.animals.model;

/**
 * Bird representation.
 */
public abstract class Bird extends Animal{
    /**
     * Bird feathers color.
     */
    private String feathersColor;

    public String getColor() {
        return feathersColor;
    }

    public void setColor(String color) {
        this.feathersColor = color;
    }
}
