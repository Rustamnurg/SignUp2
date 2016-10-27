package DateCore.Likes;

import Essence.Posts;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Rustam on 27.10.16.
 */
public class GetCountLikes {
    public int getCountLikes(int idPosts) {

        Connection connection = null;

        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn = null;
        Statement stmt = null;
        int count = 0;


//        private int id_posts;
//        private int id_likers;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from \"Likes\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                    if(Integer.parseInt(rs.getString("id_posts")) == idPosts){
                        count++;

                }
            }



            conn.close();



            return  count;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }
}
//SELECT COUNT(*) FROM table;