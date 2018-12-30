package pl.mp.animals.model;

/**
 * Iguana representation.
 */
public class Iguana extends Lizard implements PlantEater{

    public void hiss(){
        System.out.println(getName() + " is hissing.");
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




