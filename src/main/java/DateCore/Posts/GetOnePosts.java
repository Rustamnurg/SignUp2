package DateCore.Posts;

import Essence.Posts;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Rustam on 20.10.16.
 */
public class GetOnePosts {
    public Posts getOnePosts(int id){
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
            String query = "select * from \"Posts\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                if((Integer.parseInt(rs.getString("id")) == id)){
                    posts.setId_posts(Integer.parseInt(rs.getString("id")));
                    posts.setId_author(Integer.parseInt(rs.getString("id_author")));
                    posts.setContent(rs.getString("content"));
                    posts.setDate(rs.getString("date"));
                    break;
                }
            }
            conn.close();
            return posts;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
