package Essence;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Rustam on 19.10.16.
 */
public class Testing {
    public void addPosts() {
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");


        int idAutor = 1;
        String time = "2004-10-19 10:23:54+02";//format1.format(d);
        String context = "dsadasdaxdrcftvmfkjbvhudfs";


        Connection connection = null;

        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            String sql = "INSERT INTO \"Posts\" VALUES (DEFAULT, '" + idAutor + "', '" + context + "', '" +
                   time + "')";

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


    public void readPosts(){


        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;

        String result = "";
        LinkedList ll = new LinkedList();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from \"Posts\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                ll.add(rs.getString("id_author") + rs.getString("content") + rs.getString("date"));
            }

            ListIterator<String> itr = ll.listIterator();
            while (itr.hasNext())
                System.out.println(itr.next());
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
