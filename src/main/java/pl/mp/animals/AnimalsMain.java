package pl.mp.animals;

import pl.mp.animals.model.Animal;
import pl.mp.animals.model.Iguana;
import pl.mp.animals.model.Parrot;
import pl.mp.animals.model.Wolf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Application main class.
 */
public class AnimalsMain {
    /**
     * Application main method.
     * @param args Command line application starting arguments.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the ZOO!");

        printMenu();

        //Create new Scanner object to reads user input
        Scanner inputScanner = new Scanner(System.in);

        boolean running = true;

        while (running){
            //Read next user command
            int command = inputScanner.nextInt();

            switch (command){
                case 1:{
                    load();
                    break;
                } case 2:{

                    break;
                }case 3: {
                    running = false;
                    break;
                }default:{
                    printMenu();
                }
            }

        }

    }
    //Prints user menu
    private static void printMenu(){
        System.out.println("Choose action: \n" +
                "1 - load file \n" +
                "2 - save file \n" +
                "3 - quit");
    }

    private static Animal[] load () {
        String file = "C:\\Programowanie\\Projects\\java-2018-11-17-animals\\src\\main\\java\\pl\\mp\\animals\\ZOO";
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String animalsCount = br.readLine();
            int count = Integer.parseInt(animalsCount);

            Animal[] zoo = new Animal[count];

            for (int i = 0; i<count; i++) {
                //Read animal species
                String animalSpecies = br.readLine();
                //Create new animal according to spiecies
                Animal animal = null;
                if (animalSpecies.equals("wolf")){
                    animal = new Wolf();
                } else if (animalSpecies.equals("parrot")){
                    animal = new Parrot();
                } else if (animalSpecies.equals("iguana")){
                    animal = new Iguana();
                } else {
                    System.out.println("Unknown spiecies!");
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
                if (animal instanceof Wolf){
                    ((Wolf) animal).setColor(animalColor);
                } else if (animal instanceof Parrot) {
                    ((Parrot) animal).setColor(animalColor);
                } else if (animal instanceof Iguana) {
                    ((Iguana) animal).setColor(animalColor);
                }
                /* Check load method
                System.out.println(i + " " + animal.getName() +
                        " " + animal.getAge());
                animal.eat(); */
            }
            return zoo;
        } catch (IOException ex) {
            System.err.println(ex);
            return new Animal[0]; //returns empty table in case of exception
        }
    }
}
