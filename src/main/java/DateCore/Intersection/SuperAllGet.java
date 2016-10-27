package DateCore.Intersection;

import DateCore.Likes.CheckIsLikes;
import DateCore.Likes.GetCountLikes;
import DateCore.Users.RequestsToDb.GetLoginFromUsers;
import Essence.Posts;
import Essence.SuperAll;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Rustam on 26.10.16.
 */
public class SuperAllGet {


    public LinkedList<SuperAll> superAllGet(int idUsers) {
        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;

        boolean editable = false;

//        SuperAll(int id_posts, int id_author, String content, String date, boolean editable, String loginAutor,
//        boolean isLikes, int likes) {

        SuperAllGet superAllGet = new SuperAllGet();
        GetLoginFromUsers getLoginFromUsers = new GetLoginFromUsers();
        CheckIsLikes checkIsLikes = new CheckIsLikes();
        LinkedList<SuperAll> linkedList = new LinkedList<>();
        GetCountLikes getCountLikes = new GetCountLikes();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from \"Posts\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                if (idUsers == Integer.parseInt(rs.getString("id_author"))) {
                    editable = true;
                } else {
                    editable = false;
                }

                linkedList.addFirst(new SuperAll(Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("id_author")), rs.getString("content"),
                        rs.getString("date"), editable,
                        getLoginFromUsers.getLoginFromUsers(Integer.parseInt(rs.getString("id_author"))),
                        checkIsLikes.checkIsLikes(Integer.parseInt(rs.getString("id")), idUsers),
                        getCountLikes.getCountLikes(Integer.parseInt(rs.getString("id")))));
            }


            conn.close();


            return linkedList;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
