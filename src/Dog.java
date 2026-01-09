public class Dog extends Pet {

    private String breed;

    public Dog(int id, String name, int age, String ownerName, String breed) {
        super(id, name, "Dog", age, ownerName);
        this.breed = breed;
    }

    public void makeSound() {
        System.out.println("Dog " + name + " says: Woof!");
    }

    public String getType() {
        return "Dog";
    }

    public boolean isBigDog() {
        return super.age >= 3;
    }

    @Override
    public String toString() {
        return super.toString() + " | Breed: " + breed;
    }
}

