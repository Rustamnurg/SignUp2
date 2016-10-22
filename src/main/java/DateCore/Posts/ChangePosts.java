package DateCore.Posts;

import Essence.Posts;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Rustam on 20.10.16.
 */
public class ChangePosts {
    public Posts changePosts(int id, String changeContent){
        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;

        Posts posts = new Posts();


        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();

            stmt.executeUpdate("UPDATE \"Posts\" SET content = '"+ changeContent +"' WHERE id = " + id);

            conn.close();
            return posts;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
