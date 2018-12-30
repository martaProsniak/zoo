package pl.mp.animals.model;

/**
 * Animal representation.
 */
public abstract class Animal {
    /**
     * Animal name.
     */
    private String name;
    /**
     * Animal age.
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void eat ();
}
