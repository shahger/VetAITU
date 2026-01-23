package model;

public class Dog extends Pet {

    private String breed;

    public Dog(int id, String name, int age, String ownerName, String breed) {
        super(id, name, "Dog", age, ownerName);
        setBreed(breed);
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be empty");
        }
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Dog " + name + " says: Woof!");
    }

    @Override
    public String toString() {
        return super.toString() + " | Breed: " + breed;
    }
}

