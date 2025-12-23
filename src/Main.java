public class Main {

    public static void main(String[] args) {

        System.out.println("=== Veterinary Clinic Management System ===\n");


        Pet pet1 = new Pet(1, "Buddy", "Dog", 2, "Alice");
        Pet pet2 = new Pet(2, "Milo", "Cat", 7, "Bob");
        Pet pet3 = new Pet();

        Owner owner1 = new Owner(101, "Alice", "+77010000001", 1);
        Owner owner2 = new Owner(102, "Bob", "+77010000002", 3);

        Veterinarian vet1 = new Veterinarian(201, "Dr. Smith", "Dog", 6);
        Veterinarian vet2 = new Veterinarian();


        System.out.println("--- PETS ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);

        System.out.println("\n--- OWNERS ---");
        System.out.println(owner1);
        System.out.println(owner2);

        System.out.println("\n--- VETERINARIANS ---");
        System.out.println(vet1);
        System.out.println(vet2);


        System.out.println("\n--- TESTING METHODS ---");
        System.out.println(pet1.getName() + " is young: " + pet1.isYoung());
        System.out.println(pet2.getName() + " life stage: " + pet2.getLifeStage());

        owner1.addPet();
        System.out.println(owner1.getName() + " frequent client: " + owner1.isFrequentClient());

        System.out.println(vet1.getName() + " experienced: " + vet1.isExperienced());
        System.out.println(vet1.getName() + " can treat cats: " + vet1.canTreat("Cat"));

        System.out.println("\n=== Program Complete ===");
    }
}
