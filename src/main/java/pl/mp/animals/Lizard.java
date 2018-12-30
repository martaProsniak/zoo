package pl.mp.animals;

public class Lizard extends Animal {
    /**
     * Lizard scale color
     */
    private String scaleColor;

    public String getScaleColor() {
        return scaleColor;
    }

    public void setScaleColor(String scaleColor) {
        this.scaleColor = scaleColor;
    }

    @Override
    public void eat() {
    }
}
