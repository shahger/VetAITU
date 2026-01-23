package model;

public class Cat extends Pet {

    private boolean indoor;

    public Cat(int id, String name, int age, String ownerName, boolean indoor) {
        super(id, name, "Cat", age, ownerName);
        this.indoor = indoor;
    }

    @Override
    public void makeSound() {
        System.out.println("Cat " + name + " says: Meow!");
    }

    @Override
    public String toString() {
        return super.toString() + " | Indoor: " + (indoor ? "Yes" : "No");
    }
}

