package DateUsers.DataBase;

import User.*;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

/**
 * Created by Rustam on 09.10.16.
 */
public class SearchData {
    public Object searchData(String login, String passwordUsers){


        String url = "jdbc:postgresql://localhost/users?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;
        User user = new User();
      //  user = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from users";
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {
                if(rs.getString("login").equals(login) && rs.getString("password").equals(passwordUsers)){
                    user.setFirstName(rs.getString("firstName"));
                    user.setLastName(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setCountry(rs.getString("country"));
                    System.out.println(user.getFirstName());
                    System.out.println(user.getLastName());
                    System.out.println(user.getEmail());
                    System.out.println(user.getLogin());
                    System.out.println(user.getPassword());
                    System.out.println(user.getCountry());

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
