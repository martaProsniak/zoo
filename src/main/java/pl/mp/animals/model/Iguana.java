package pl.mp.animals.model;

import java.io.Serializable;

/**
 * Iguana representation.
 */
public class Iguana extends Lizard implements PlantEater {

    public void hiss(){
        System.out.println(getName() + " is hissing.");
    }

    @Override
    public void eat() {
        System.out.println("Iguana " + getName() + " is eating.");;
    }

    @Override
    public void eatPlants() {
        System.out.println("Iguana " + getName() + " is eating plants.");
    }
}




