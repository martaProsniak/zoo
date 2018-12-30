package pl.mp.animals.model;

/**
 * Bird representation.
 */
public abstract class Bird extends Animal{
    /**
     * Bird feathers color.
     */
    private String feathersColor;

    public String getFeathersColor() {
        return feathersColor;
    }

    public void setFeathersColor(String feathersColor) {
        this.feathersColor = feathersColor;
    }
}
