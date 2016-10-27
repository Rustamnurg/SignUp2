package DateCore.Users.RequestsToDb;

import java.sql.*;

/**
 * Created by Rustam on 28.10.16.
 */
public class GetLoginFromUsers {
    public String getLoginFromUsers(int idUsers){

        String url = "jdbc:postgresql://localhost/project?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;
        String login = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "select * from \"Users\"";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                if (Integer.parseInt(rs.getString("id")) == idUsers) {
                    login = rs.getString("login");
                    break;
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return login;
    }
}
