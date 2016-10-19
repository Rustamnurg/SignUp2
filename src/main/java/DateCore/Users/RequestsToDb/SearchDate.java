package DateCore.Users.RequestsToDb;

/**
 * Created by Rustam on 11.10.16.
 */

import java.sql.ResultSet;


        import Essence.*;

import java.sql.*;

/**
 * Created by Rustam on 09.10.16.
 */
public class SearchDate {
    public User searchData(String login, String passwordUsers){


        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;
        User user = new User();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from \"Users\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                if(rs.getString("login").equals(login) && rs.getString("password").equals(passwordUsers)){
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setCountry(rs.getString("country"));
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return user;
    }

}
