package model;

public abstract class Pet {

    protected int petId;
    protected String name;
    protected String species;
    protected int age;
    protected String ownerName;

    public Pet(int petId, String name, String species, int age, String ownerName) {
        setPetId(petId);
        setName(name);
        setSpecies(species);
        setAge(age);
        setOwnerName(ownerName);
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        if (petId <= 0) {
            throw new IllegalArgumentException("Pet ID must be positive");
        }
        this.petId = petId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be empty");
        }
        this.species = species;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("model.Owner name cannot be empty");
        }
        this.ownerName = ownerName;
    }

    public boolean isYoung() {
        return age < 3;
    }

    // ABSTRACT METHOD (ОБЯЗАТЕЛЬНО)
    public abstract void makeSound();

    @Override
    public String toString() {
        return "Pet ID: " + petId +
                ", Name: " + name +
                ", Species: " + species +
                ", Age: " + age +
                ", model.Owner: " + ownerName;
    }
}





