package pl.mp.animals;

/**
 * Parrot representation.
 */
public class Parrot extends Bird implements PlantEater {

   public void tweet () {
       System.out.println(getName() + " is tweeting.");
   }

    @Override
    public void eat() {
        eatPlants();
    }

    @Override
    public void eatPlants() {
        System.out.println(getName() + " is eating plants.");
    }
}
