package pl.mp.animals;

public class Bird extends Animal{
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

    @Override
    public void eat() {
    }
}
