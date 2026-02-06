package menu;

import dao.PetDAO;
import exception.InvalidInputException;

import java.util.Scanner;

public class VetClinicMenu implements Menu {

    private final Scanner scanner;
    private final PetDAO petDAO;

    public VetClinicMenu() {
        scanner = new Scanner(System.in);
        petDAO = new PetDAO();
    }

    @Override
    public void displayMenu() {
        System.out.println("""
        ===== VET CLINIC SYSTEM =====
        1. Add Dog
        2. Add Cat
        3. View All Pets
        4. Update Pet Name
        5. Update Pet Age
        6. Delete Pet
        7. Search Pet by Name
        8. Filter Pets by Species
        9. Search Pets by Age Range
        0. Exit
        =============================
        """);
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                System.out.print("Choose option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addDog();
                    case 2 -> addCat();
                    case 3 -> petDAO.displayAllPets();
                    case 4 -> updatePetName();
                    case 5 -> updatePetAge();
                    case 6 -> deletePet();
                    case 7 -> searchByName();
                    case 8 -> filterBySpecies();
                    case 9 -> searchByAgeRange();
                    case 0 -> {
                        System.out.println("Exiting system...");
                        running = false;
                    }
                    default -> throw new InvalidInputException("Invalid menu option");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ---------- MENU ACTIONS ----------

    private void addDog() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Owner name: ");
            String owner = scanner.nextLine();

            System.out.print("Breed: ");
            String breed = scanner.nextLine();

            petDAO.insertDog(name, age, owner, breed);

        } catch (Exception e) {
            System.out.println("Failed to add dog");
        }
    }

    private void addCat() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Owner name: ");
            String owner = scanner.nextLine();

            System.out.print("Indoor (true/false): ");
            boolean indoor = Boolean.parseBoolean(scanner.nextLine());

            petDAO.insertCat(name, age, owner, indoor);

        } catch (Exception e) {
            System.out.println("Failed to add cat");
        }
    }

    private void updatePetName() {
        System.out.print("Pet ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New name: ");
        String name = scanner.nextLine();

        petDAO.updatePetName(id, name);
    }

    private void updatePetAge() {
        System.out.print("Pet ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New age: ");
        int age = Integer.parseInt(scanner.nextLine());

        petDAO.updatePetAge(id, age);
    }

    private void deletePet() {
        System.out.print("Pet ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        petDAO.deletePet(id);
    }

    private void searchByName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        petDAO.searchByName(name);
    }

    private void filterBySpecies() {
        System.out.print("Species (Dog/Cat): ");
        String species = scanner.nextLine();

        petDAO.filterBySpecies(species);
    }

    private void searchByAgeRange() {
        System.out.print("Min age: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Max age: ");
        int max = Integer.parseInt(scanner.nextLine());

        petDAO.searchByAgeRange(min, max);
    }
}

