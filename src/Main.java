import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pet> pets = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        pets.add(new Pet(1, "Unknown", "Dog",  2, "No owner"));
        pets.add(new Dog(2, "Rex", 4, "Aidar", "Labrador"));
        pets.add(new Cat(3, "Murka", 1, "Asel", true));

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPet();
                case 2 -> addDog();
                case 3 -> addCat();
                case 4 -> viewAllPets();
                case 5 -> demonstratePolymorphism();
                case 6 -> viewDogsOnly();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== VET CLINIC SYSTEM ===");
        System.out.println("1. Add Pet");
        System.out.println("2. Add Dog");
        System.out.println("3. Add Cat");
        System.out.println("4. View All Pets");
        System.out.println("5. Make All Pets Make Sound");
        System.out.println("6. View Dogs Only");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addPet() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Owner name: ");
        String owner = scanner.nextLine();

        pets.add(new Pet(id, name, "Dog", age, owner));
        System.out.println("Pet added!");
    }

    private static void addDog() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Owner name: ");
        String owner = scanner.nextLine();
        System.out.print("Breed: ");
        String breed = scanner.nextLine();

        pets.add(new Dog(id, name, age, owner, breed));
        System.out.println("Dog added!");
    }

    private static void addCat() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Owner name: ");
        String owner = scanner.nextLine();
        System.out.print("Indoor (true/false): ");
        boolean indoor = scanner.nextBoolean();
        scanner.nextLine();

        pets.add(new Cat(id, name, age, owner, indoor));
        System.out.println("Cat added!");
    }

    private static void viewAllPets() {
        for (Pet p : pets) {
            System.out.println(p);
        }
    }

    private static void demonstratePolymorphism() {
        for (Pet p : pets) {
            p.makeSound();
        }
    }

    private static void viewDogsOnly() {
        for (Pet p : pets) {
            if (p instanceof Dog) {
                Dog d = (Dog) p;
                System.out.println(d);
            }
        }
    }
}

