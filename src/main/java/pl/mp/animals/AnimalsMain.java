package pl.mp.animals;

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
}
