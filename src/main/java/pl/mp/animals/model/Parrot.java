package pl.mp.animals.model;

import java.io.Serializable;

/**
 * Parrot representation.
 */
public class Parrot extends Bird implements PlantEater {

   public void tweet () {
       System.out.println(getName() + " is tweeting.");
   }

    @Override
    public void eat() {
        System.out.println("Parrot " + getName() + " is eating.");;
    }

    @Override
    public void eatPlants() {
        System.out.println("Parrot " + getName() + " is eating plants.");
    }
}
