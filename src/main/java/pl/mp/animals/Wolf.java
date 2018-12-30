package pl.mp.animals;

/**
 * Wolf representation.
 */
public class Wolf extends Mammal implements MeatEater {

    public void howl (){
        System.out.println(getName() + " is howling.");
    }

    @Override
    public void eat() {
        eatMeat();
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " is eating meat.");
    }
}
