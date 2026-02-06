public class Owner {

    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;

    public Owner(int ownerId, String name, String phone, int numberOfPets) {
        this.ownerId = ownerId;
        setName(name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
    }

    public int getOwnerId() { return ownerId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getNumberOfPets() { return numberOfPets; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.contains("+")) {
            this.phone = phone;
        } else {
            System.out.println("Invalid phone number!");
            this.phone = "N/A";
        }
    }

    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets >= 0) {
            this.numberOfPets = numberOfPets;
        } else {
            this.numberOfPets = 0;
        }
    }

    public boolean isFrequentClient() {
        return numberOfPets >= 3;
    }

    @Override
    public String toString() {
        return "Owner ID: " + ownerId +
                ", Name: " + name +
                ", Phone: " + phone +
                ", Pets: " + numberOfPets;
    }
}
