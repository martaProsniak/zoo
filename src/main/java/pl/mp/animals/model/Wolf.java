package pl.mp.animals.model;

import java.io.Serializable;

/**
 * Wolf representation.
 */
public class Wolf extends Mammal implements MeatEater {

        public void howl () {
        System.out.println(getName() + " is howling.");
    }

        @Override
        public void eat () {
        System.out.println("Wolf " + getName() + " is eating.");
    }

        @Override
        public void eatMeat () {
        System.out.println("Wolf " + getName() + " is eating meat.");
    }
    }
