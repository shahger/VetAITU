public class Pet {

    protected int petId;
    protected String name;
    protected String species;
    protected int age;
    protected String ownerName;

    public Pet(int petId, String name, String species, int age, String ownerName) {
        this.petId = petId;
        setName(name);
        setSpecies(species);
        setAge(age);
        setOwnerName(ownerName);
    }

    public Pet() {
        this.petId = 0;
        this.name = "Unknown";
        this.species = "Unknown";
        this.age = 0;
        this.ownerName = "Unknown";
    }

    public int getPetId() { return petId; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public String getOwnerName() { return ownerName; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be empty!");
            this.name = "Unknown";
        }
    }

    public void setSpecies(String species) {
        if (species != null && !species.trim().isEmpty()) {
            this.species = species;
        } else {
            this.species = "Unknown";
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative. Setting to 0.");
            this.age = 0;
        }
    }

    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.trim().isEmpty()) {
            this.ownerName = ownerName;
        } else {
            this.ownerName = "Unknown";
        }
    }

    public boolean isYoung() {
        return age < 3;
    }

    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }


    @Override
    public String toString() {
        return "Pet ID: " + petId +
                ", Name: " + name +
                ", Species: " + species +
                ", Age: " + age +
                ", Owner: " + ownerName;
    }
}




