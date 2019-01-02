package pl.mp.animals;

import pl.mp.animals.model.Animal;
import pl.mp.animals.model.Bird;
import pl.mp.animals.model.Iguana;
import pl.mp.animals.model.Lizard;
import pl.mp.animals.model.Mammal;
import pl.mp.animals.model.MeatEater;
import pl.mp.animals.model.Parrot;
import pl.mp.animals.model.PlantEater;
import pl.mp.animals.model.Wolf;

import java.io.*;

/**
 * Application main class.
 */
public class AnimalsMain {
    /**
     * Application main method.
     *
     * @param args Command line application starting arguments.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the ZOO!");

        //New animal array
        Animal[] zoo;

        //New path - text files will be created here
        String filePath = "/tmp/ZooCopy.txt";
        //New path - binary files will be created here
        String binFilePath = "/tmp/ZooBin";

        //Ex. 7
        zoo = load();
        save(filePath, zoo);

        //Ex. 8
        printZoo(zoo);

        //Ex. 9
        feedAll(zoo);
        feedMeetEaters(zoo);
        feedPlantEaters(zoo);

        //Ex. 10
        howl(zoo);
        hiss(zoo);
        tweet(zoo);

        //Ex. 11
        saveBinaryZoo(binFilePath, zoo);
        zoo = loadBinaryZoo(binFilePath);
        printZoo(zoo);

    }


    /**
     * Load information from file and converts it to an array.
     * @return Animal array.
     */
    private static Animal[] load() {
        String file = "ZOO.txt";
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String animalsCount = br.readLine();
            int count = Integer.parseInt(animalsCount);

            Animal[] zoo = new Animal[count];

            for (int i = 0; i < count; i++) {
                //Read animal species
                String animalSpecies = br.readLine();
                //Create new animal according to species
                Animal animal = null;
                switch (animalSpecies) {
                    case "wolf":
                        animal = new Wolf();
                        break;
                    case "parrot":
                        animal = new Parrot();
                        break;
                    case "iguana":
                        animal = new Iguana();
                        break;
                }
                //Assign animal to an array
                zoo[i] = animal;

                //Read animal name
                String animalName = br.readLine();
                animal.setName(animalName);

                //Read animal age
                String animalAgeText = br.readLine();
                //Converts String into Integer
                int animalAge = Integer.parseInt(animalAgeText);
                //Set animal age
                animal.setAge(animalAge);

                //Read animal color
                String animalColor = br.readLine();
                //Set animal color according to spiecies
                if (animal instanceof Mammal) {
                    ((Mammal) animal).setColor(animalColor);
                } else if (animal instanceof Bird) {
                    ((Bird) animal).setColor(animalColor);
                } else if (animal instanceof Lizard) {
                    ((Lizard) animal).setColor(animalColor);
                }
            }
            return zoo;
        } catch (IOException ex) {
            System.err.println(ex);
            return new Animal[0]; //returns empty table in case of exception
        }
    }

    /**
     * Save animals array into the file.
     * @param file Path to the file.
     * @param animals Animal array.
     */

    private static void save(String file, Animal[] animals) { ;
        try (FileWriter fw = new FileWriter(file)) {
            //Saves array size into the file
            fw.write(animals.length + "\n");

            for (int i = 0; i < animals.length; i++) {
                //Write animal species into the file
                if (animals[i] instanceof Wolf) {
                    String species = "wolf";
                    fw.write(species + "\n");
                } else if (animals[i] instanceof Parrot) {
                    String species = "parrot";
                    fw.write(species + "\n");
                } else if (animals[i] instanceof Iguana) {
                    String species = "iguana";
                    fw.write(species + "\n");
                }
                //Write animal name into the file
                fw.write(animals[i].getName() + "\n");

                //Write animal age into the file
                fw.write(animals[i].getAge() + "\n");

                //Write animal color into the file
                if (animals[i] instanceof Bird) {
                    fw.write(((Bird) animals[i]).getColor() + "\n");
                } else if (animals[i] instanceof Mammal) {
                    fw.write(((Mammal) animals[i]).getColor() + "\n");
                } else if (animals[i] instanceof Lizard) {
                    fw.write(((Lizard) animals[i]).getColor() + "\n");
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Prints Animal array (name, age, species and color).
     * @param animals Animal array to be printed
     */

    private static void printZoo(Animal[] animals) {

        System.out.println("Animals in our Zoo:");

        for (int i = 0; i < animals.length; i++) {
            System.out.print((i + 1) + ". Animal in the zoo is: " +
                    animals[i].getName() + ", " +
                    animals[i].getAge() + " years, ");
            if (animals[i] instanceof Wolf) {
                System.out.print("species: wolf, ");
            } else if (animals[i] instanceof Parrot) {
                System.out.print("species: parrot, ");
            } else if (animals[i] instanceof Iguana) {
                System.out.print("species: iguana, ");
            }

            if (animals[i] instanceof Mammal){
                System.out.println("fur color: " + ((Mammal) animals[i]).getColor());
            } else if (animals[i] instanceof Bird){
                System.out.println("feathers color: " + ((Bird) animals[i]).getColor());
            } else if (animals[i] instanceof Lizard){
                System.out.println("scales color: " + ((Lizard) animals[i]).getColor());
            }
        }
    }

    /**
     * Feeds all animals in an array.
     * @param animals Animal array.
     */
    private static void feedAll (Animal [] animals){
        for (Animal a : animals){
            a.eat();
        }
    }

    /**
     * Meat eaters call method implemented from Meat Eater interface.
     * @param animals Animal array.
     */
    private static void feedMeetEaters (Animal [] animals) {
        for (Animal a : animals) {
            if (a instanceof MeatEater){
                ((MeatEater) a).eatMeat();
            }
        }
    }

    /**
     * Plant eaters call method implemented from Plant Eater interface.
     * @param animals Animal array.
     */
    private static void feedPlantEaters (Animal [] animals) {
        for (Animal a : animals) {
            if (a instanceof PlantEater){
                ((PlantEater) a).eatPlants();
            }
        }
    }

    /**
     * Calls howl method from Wolf class.
     * @param animals Animal array.
     */
    private static void howl (Animal [] animals ){
        for (Animal a : animals){
            if (a instanceof Wolf){
                ((Wolf) a).howl();
            }
        }
    }

    /**
     * Calls hiss method from Iguana class.
     * @param animals Animal array.
     */
    private static void hiss (Animal [] animals ){
        for (Animal a : animals){
            if (a instanceof Iguana){
                ((Iguana) a).hiss();
            }
        }
    }

    /**
     * Calls tweet method from Parrot class.
     * @param animals Animal array.
     */
    private static void tweet (Animal[] animals){
        for(Animal a : animals){
            if (a instanceof Parrot){
                ((Parrot) a).tweet();
            }
        }
    }

    /**
     * Saves animal array into binary file.
     * @param file File path.
     * @param animals Animal array.
     */
    private static void saveBinaryZoo(String file, Animal[] animals) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(animals);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Loads animals from binary file.
     * @param file File path.
     * @return Animals array.
     */
    private static Animal[] loadBinaryZoo (String file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)){
            return (Animal[]) ois.readObject();
        }catch (IOException | ClassNotFoundException ex){
            System.err.println(ex);
            return null;
        }
    }

}



