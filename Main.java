import java.sql.*;
public class Main {
    public static void main(String[] args) {
        try {
            // SQLite DB に接続
            Connection conn = DriverManager.getConnection("jdbc:sqlite:student.db");
            Statement stmt = conn.createStatement();

            // DB の内容を取得
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                    rs.getString("student_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email")
                );
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
