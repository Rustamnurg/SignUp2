package DateCore.Likes;

import Essence.Likes;
import Essence.Posts;
import Other.GetTimeNow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Rustam on 25.10.16.
 */
public class AddLikes {
    public void addLikes(Likes likes) {


        Connection connection = null;

        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn = null;
        Statement stmt = null;



//        private int id_posts;
//        private int id_likers;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            String sql = "INSERT INTO \"Likes\" VALUES (DEFAULT, '" + likes.getId_posts() + "', '" + likes.getId_likers() + "')";

            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Закрываем ресурсы, не допуская их утечки.
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }

    }
}
