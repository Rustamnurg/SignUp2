package DateCore.Likes;

import java.sql.*;

/**
 * Created by Rustam on 28.10.16.
 */
public class CheckIsLikes {
    public boolean checkIsLikes(int idPosts, int idUsers) {

        Connection connection = null;

        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn = null;
        Statement stmt = null;
        boolean isLikes = false;


//        private int id_posts;
//        private int id_likers;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from \"Likes\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                if(Integer.parseInt(rs.getString("id_likers")) == idUsers) {
                    if (Integer.parseInt(rs.getString("id_posts")) == idPosts) {
                        isLikes = true;
                        break;
                    }
                }
            }

            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isLikes;
    }
}
