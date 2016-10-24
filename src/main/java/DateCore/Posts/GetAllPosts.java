package DateCore.Posts;

import Essence.Posts;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Rustam on 19.10.16.
 */
public class GetAllPosts {
    public LinkedList<Posts> getAllPosts(){
        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;

        Posts posts = new Posts();
        LinkedList<Posts> linkedList = new LinkedList<>();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from \"Posts\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                linkedList.add(new Posts(Integer.parseInt(rs.getString("id")),Integer.parseInt(rs.getString("id_author"))
                        ,rs.getString("content"), rs.getString("date")));
            }



            conn.close();
            return  linkedList;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
