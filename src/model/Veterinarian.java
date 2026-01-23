package model;

public class Veterinarian implements Treatable {

    private int vetId;
    private String name;
    private String specialization;
    private int experienceYears;

    public Veterinarian(int vetId, String name, String specialization, int experienceYears) {
        setVetId(vetId);
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
    }

    public void setVetId(int vetId) {
        if (vetId <= 0) {
            throw new IllegalArgumentException("Vet ID must be positive");
        }
        this.vetId = vetId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        this.experienceYears = experienceYears;
    }

    @Override
    public void treat() {
        System.out.println("Veterinarian " + name + " is treating animals");
    }
}
