package DateCore.Intersection;

import Essence.Posts;
import Essence.SuperAll;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by Rustam on 26.10.16.
 */
public class SuperAllGet {


    public LinkedList<SuperAll> superAllGet(int idUsers, String autorLogin){
        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;

        boolean editable = false;

//        SuperAll(int id_posts, int id_author, String content, String date, boolean editable, String loginAutor,
//        boolean isLikes, int likes) {

        SuperAllGet superAllGet = new SuperAllGet();
        LinkedList<SuperAll> linkedList = new LinkedList<>();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from \"Posts\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                if(idUsers ==  Integer.parseInt(rs.getString("id_author"))){
                 editable = true;
                }


                linkedList.addFirst(new SuperAll(Integer.parseInt(rs.getString("id")),
                        Integer.parseInt(rs.getString("id_author")),rs.getString("content"),
                        rs.getString("date"), editable, autorLogin, false, 5));
            }



            conn.close();



            return  linkedList;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
