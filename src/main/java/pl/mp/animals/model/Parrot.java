package pl.mp.animals.model;

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
