package pl.mp.animals;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import pl.mp.animals.model.Animal;
import pl.mp.animals.model.Iguana;
import pl.mp.animals.model.Parrot;
import pl.mp.animals.model.Wolf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        Animal[] zoo = new Animal[10];

        printMenu();

        //Create new Scanner object to reads user input
        Scanner inputScanner = new Scanner(System.in);

        //Variable to create application main loop
        boolean running = true;

        while (running) {
            //Read next user command
            int command = inputScanner.nextInt();

            switch (command) {
                case 1: {
                    zoo = load(); //assign result of load method to global Animal array
                    break;
                }
                case 2: {
                    save(inputScanner, zoo);
                    break;
                }
                case 3: {
                    printZoo(zoo);
                    break;
                }
                case 4: {
                    feedAll(zoo);
                    break;
                }
                case 5: {
                    feedMeetEaters(zoo);
                    break;
                }
                case 6: {
                    feedPlantEaters(zoo);
                    break;
                }
                case 7: {
                    howl(zoo);
                    break;
                }
                case 8: {
                    hiss(zoo);
                    break;
                }
                case 9:{
                    tweet(zoo);
                    break;
                }
                case 0: {
                    running = false;
                    break;
                }
                default: {
                    printMenu();
                }
            }

        }

    }

    //Prints user menu
    private static void printMenu() {
        System.out.println("Choose action: \n" +
                "1 - load file \n" +
                "2 - save file \n" +
                "3 - print whole zoo \n" +
                "4 - feed all animals \n" +
                "5 - feed the meat eaters \n" +
                "6 - feed the plant eaters \n" +
                "7 - speak with wolves \n" +
                "8 - speak with iguanas \n" +
                "9 - speak with parrots \n" +
                "0 - quit");
    }

    /**
     * Load information from file and converts it to an array.
     * @return Animal array.
     */
    private static Animal[] load() {
        String file = "C:\\Programowanie\\Projects\\java-2018-11-17-animals\\src\\main\\java\\pl\\mp\\animals\\ZOO";
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
                if (animalSpecies.equals("wolf")) {
                    animal = new Wolf();
                } else if (animalSpecies.equals("parrot")) {
                    animal = new Parrot();
                } else if (animalSpecies.equals("iguana")) {
                    animal = new Iguana();
                } else {
                    System.out.println("Unknown species!");
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
                if (animal instanceof Wolf) {
                    ((Wolf) animal).setColor(animalColor);
                } else if (animal instanceof Parrot) {
                    ((Parrot) animal).setColor(animalColor);
                } else if (animal instanceof Iguana) {
                    ((Iguana) animal).setColor(animalColor);
                } else {
                    System.out.println("Unknown species!");
                    break;
                }
            }
            System.out.println("File loaded!");
            return zoo;
        } catch (IOException ex) {
            System.err.println(ex);
            return new Animal[0]; //returns empty table in case of exception
        }
    }

    /**
     * Save animals array into the file.
     * @param inputScanner to read user input (file path).
     * @param animals Animal array.
     */

    private static void save(Scanner inputScanner, Animal[] animals) {
        System.out.println("Where to save a file?");
        String file = inputScanner.next();
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
                if (animals[i] instanceof Parrot) {
                    fw.write(((Parrot) animals[i]).getColor() + "\n");
                } else if (animals[i] instanceof Wolf) {
                    fw.write(((Wolf) animals[i]).getColor() + "\n");
                } else if (animals[i] instanceof Iguana) {
                    fw.write(((Iguana) animals[i]).getColor() + "\n");
                }
                System.out.println("File saved!");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Prints Animal array
     * @param animals Animal array to be printed
     */

    private static void printZoo(Animal[] animals) {

        System.out.println("Animals in our Zoo:");

        for (int i = 0; i < animals.length; i++) {
            System.out.print((i + 1) + ". Animal in the zoo is: " +
                    animals[i].getName() + ", " +
                    animals[i].getAge() + " years, ");
            if (animals[i] instanceof Wolf) {
                System.out.print("species: wolf, fur color: " +
                        ((Wolf) animals[i]).getColor() + "\n");
            } else if (animals[i] instanceof Parrot) {
                System.out.print("species: parrot, feathers color: " +
                        ((Parrot) animals[i]).getColor() + "\n");
            } else if (animals[i] instanceof Iguana) {
                System.out.print("species: iguana, scales color: " +
                        ((Iguana) animals[i]).getColor() + "\n");
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
            if (a instanceof Wolf){
                ((Wolf) a).eatMeat();
            }
        }
    }

    /**
     * Plant eaters call method implemented from Plant Eater interface.
     * @param animals Animal array.
     */
    private static void feedPlantEaters (Animal [] animals) {
        for (Animal a : animals) {
            if (a instanceof Parrot){
                ((Parrot) a).eatPlants();
            } else if (a instanceof Iguana){
                ((Iguana) a).eatPlants();
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
}
