import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // ★ ① SQLite JDBC ドライバを明示的にロード
            Class.forName("org.sqlite.JDBC");
            System.out.println("SQLite JDBC Driver loaded.");

            // ★ ② 同じフォルダの student.db に接続
            String url = "jdbc:sqlite:student.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to DB.");

            String sql = "SELECT student_id, name, email FROM students";

            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String id = rs.getString("student_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");

                    System.out.println(id + " | " + name + " | " + email);
                }
            }

        } catch (Exception e) {
            // エラーはそのまま表示
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try { conn.close(); } catch (SQLException ignore) {}
            }
        }
    }
}
