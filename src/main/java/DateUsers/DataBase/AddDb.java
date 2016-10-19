package DateUsers.DataBase;

import User.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Rustam on 09.10.16.
 */
public class AddDb {
    public String add(User user) throws SQLException {

        Connection connection = null;

        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            String sql = "INSERT INTO \"Users\" VALUES (DEFAULT, '"+ user.getFirstName() +"', '"+ user.getLastName() +"', '"+
                    user.getEmail() +"', '"+ user.getLogin() +"', '"+ user.getPassword() +"', '"+ user.getCountry() +"')";

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
        return  "";
    }

}
