package DateCore.Likes;

import Essence.Likes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Rustam on 27.10.16.
 */
public class DeleteLikes {
    public void deleteLikes(Likes likes){
        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();

            stmt.executeUpdate("DELETE FROM \"Likes\" WHERE id_posts = " + likes.getId_posts() +
                    " AND id_likers = " +  likes.getId_likers());

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
