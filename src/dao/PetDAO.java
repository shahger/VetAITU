package dao;

import db.DBConnection;

import java.sql.*;

public class PetDAO {

    // -------- CREATE --------

    public void insertDog(String name, int age, String owner, String breed) {
        String sql = "INSERT INTO pet(name, species, age, owner_name, breed, indoor) VALUES (?, 'Dog', ?, ?, ?, false)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, owner);
            ps.setString(4, breed);

            ps.executeUpdate();
            System.out.println("Dog added to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCat(String name, int age, String owner, boolean indoor) {
        String sql = "INSERT INTO pet(name, species, age, owner_name, breed, indoor) VALUES (?, 'Cat', ?, ?, NULL, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, owner);
            ps.setBoolean(4, indoor);

            ps.executeUpdate();
            System.out.println("Cat added to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------- READ --------

    public void displayAllPets() {
        String sql = "SELECT * FROM pet ORDER BY pet_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- ALL PETS ---");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("pet_id") +
                                ", Name: " + rs.getString("name") +
                                ", Species: " + rs.getString("species") +
                                ", Age: " + rs.getInt("age") +
                                ", Owner: " + rs.getString("owner_name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // -------- UPDATE --------

    public void updatePetName(int id, String newName) {
        String sql = "UPDATE pet SET name = ? WHERE pet_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, id);

            int updated = ps.executeUpdate();
            System.out.println(updated > 0 ? "Pet updated!" : "Pet not found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePetAge(int id, int newAge) {
        String sql = "UPDATE pet SET age = ? WHERE pet_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newAge);
            ps.setInt(2, id);

            int updated = ps.executeUpdate();
            System.out.println(updated > 0 ? "Age updated!" : "Pet not found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -------- DELETE --------

    public void deletePet(int id) {
        String sql = "DELETE FROM pet WHERE pet_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int deleted = ps.executeUpdate();
            System.out.println(deleted > 0 ? "Pet deleted!" : "Pet not found!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // -------- SEARCH --------

    public void searchByName(String name) {
        String sql = "SELECT * FROM pet WHERE name ILIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- SEARCH RESULTS ---");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("pet_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("species") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("owner_name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void filterBySpecies(String species) {
        String sql = "SELECT * FROM pet WHERE species = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, species);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- " + species.toUpperCase() + " LIST ---");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("pet_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("owner_name")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchByAgeRange(int min, int max) {
        String sql = "SELECT * FROM pet WHERE age BETWEEN ? AND ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- AGE RANGE " + min + " - " + max + " ---");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("pet_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("species") + " | " +
                                rs.getInt("age")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

