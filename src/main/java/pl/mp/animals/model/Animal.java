package pl.mp.animals.model;

import java.io.Serializable;

/**
 * Animal representation.
 */
public abstract class Animal implements Serializable {
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
