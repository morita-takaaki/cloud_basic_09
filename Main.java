import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                    rs.getString("student_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
