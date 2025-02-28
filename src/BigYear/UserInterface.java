package BigYear;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private ArrayList<Bird> birdDataBase;

    public UserInterface(Scanner scanner){
        this.scanner = scanner;
        this.birdDataBase = new ArrayList<>();
    }

    public void start(){
        System.out.println("Commands:");
        System.out.println("add - adds a bird");
        System.out.println("observation - adds and observation");
        System.out.println("all - prints all birds");
        System.out.println("one - prints one bird");
        System.out.println("quit - end the program");


        while(true){
            System.out.println("");
            System.out.print("Command: ");
            String command = scanner.nextLine();

            switch(command){
                case "add":
                    addBird();
                    break;
                case "observation":
                    addObservation();
                    break;
                case "all":
                    printAllBirds();
                    break;
                case "one":
                    printOneBird();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown command");;
            }
        }
    }

    public void addBird(){
        System.out.print("English name:  ");
        String english = scanner.nextLine();
        System.out.print("Latin name: ");
        String latin = scanner.nextLine();

        birdDataBase.add(new Bird(english,latin));
    }

    public void addObservation(){
        System.out.print("Bird observed: ");
        String birdObserved = scanner.nextLine();

        for(Bird bird: birdDataBase) {
            if (bird.getEnglish().equals(birdObserved)) {
                bird.addObservation();
                return;
            }
        }
        System.out.println("That is not in the bird database.");
    }

    public void printAllBirds(){
        for(Bird bird: birdDataBase){
            System.out.println(bird);
        }
    }

    public void printOneBird(){
        int index = (int)((Math.random() * birdDataBase.size()));
        System.out.println(birdDataBase.get(index));
    }
}
