package menu;

import model.*;
import exception.*;

import java.util.ArrayList;
import java.util.Scanner;

public class VetClinicMenu implements Menu {

    private ArrayList<Pet> pets = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public VetClinicMenu() {
        pets.add(new Dog(1, "Rex", 4, "Aidar", "Labrador"));
        pets.add(new Cat(2, "Murka", 2, "Asel", true));
    }

    @Override
    public void displayMenu() {
        System.out.println("""
        === VET CLINIC SYSTEM ===
        1. Add Dog
        2. Add Cat
        3. View All Pets
        4. Make All Pets Sound
        0. Exit
        """);
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addDog();
                    case 2 -> addCat();
                    case 3 -> viewPets();
                    case 4 -> makeSounds();
                    case 0 -> running = false;
                    default -> throw new InvalidInputException("Invalid menu option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addDog() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("model.Owner: ");
            String owner = scanner.nextLine();
            System.out.print("Breed: ");
            String breed = scanner.nextLine();

            pets.add(new Dog(id, name, age, owner, breed));
            System.out.println("Dog added!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addCat() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("model.Owner: ");
            String owner = scanner.nextLine();
            System.out.print("Indoor (true/false): ");
            boolean indoor = Boolean.parseBoolean(scanner.nextLine());

            pets.add(new Cat(id, name, age, owner, indoor));
            System.out.println("Cat added!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewPets() {
        pets.forEach(System.out::println);
    }

    private void makeSounds() {
        pets.forEach(Pet::makeSound);
    }
}
