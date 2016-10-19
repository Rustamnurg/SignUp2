package DateCore.Posts;

import Essence.Posts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rustam on 19.10.16.
 */
public class AddPosts {
    public void addPosts(Posts posts) {
//        Date d = new Date();
//        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");

        Connection connection = null;

        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            String sql = "INSERT INTO \"Posts\" VALUES (DEFAULT, '" + posts.getId_author() + "', '" + posts.getContent() + "', '" +
                    posts.getDate() + "')";

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
