package RecipeSearch;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(Scanner scanner){
        this.scanner = scanner;
    }

    public void start(){
        System.out.print("Files to read: ");
        String file = scanner.nextLine();
        ArrayList<Recipes> recipes = readRecipesFromFile(file);

        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("find name - search recipes by name");
        System.out.println("find cooking time - search recipes by cooking time");
        System.out.println("ingredient - search recipes by ingredient");
        System.out.println("stop - stops the program");
        System.out.println("");

        while (true) {
            System.out.println("");
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            if (command.equals("list")) {
                System.out.println("Recipes: ");
                for (Recipes recipe : recipes) {
                    System.out.println(recipe);
                }
            } else if (command.equals("find name")) {
                System.out.print("Search for: ");
                String recipeName = scanner.nextLine();

                System.out.println("Recipes: ");
                for (Recipes recipe : recipes) {
                    if (recipe.getName().contains(recipeName)) {
                        System.out.println(recipe);
                    }
                }
            } else if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxTime = Integer.valueOf(scanner.nextLine());

                for (Recipes recipe : recipes) {
                    if (recipe.getTime() <= maxTime) {
                        System.out.println(recipe);
                    }
                }
            } else if(command.equals("ingredient")){
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine();

                for(Recipes recipe : recipes){
                    if(recipe.getIngredients().contains(ingredient)){
                        System.out.println(recipe);
                    }
                }
            } else {
                break;
            }
        }

    }

    public ArrayList<Recipes> readRecipesFromFile(String file) {
        ArrayList<Recipes> recipes = new ArrayList<>();

        try (Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String name = reader.nextLine();
                if (name.isEmpty()) {
                    continue;
                }

                int time = Integer.valueOf(reader.nextLine());
                ArrayList<String> ingredients = new ArrayList<>();

                while (reader.hasNextLine()) {
                    String ingredient = reader.nextLine();
                    if (ingredient.isEmpty()) {
                        break;
                    }
                    ingredients.add(ingredient);
                }
                Recipes recipe = new Recipes(name, time, ingredients);
                recipes.add(recipe);
                System.out.println(recipe);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return recipes;
    }
}
