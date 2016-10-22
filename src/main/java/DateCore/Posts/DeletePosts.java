package DateCore.Posts;
import java.sql.*;

/**
 * Created by Rustam on 20.10.16.
 */
public class DeletePosts {

    public void deletePosts(int id){
        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();

            stmt.executeUpdate("DELETE FROM \"Posts\" WHERE id = " + id);

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

