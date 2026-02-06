import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/vet_clinic",
                    "postgres",
                    "mental123"
            );

            System.out.println("CONNECTED TO DATABASE!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
