package DateUsers.DataBase;

import User.User;

import java.sql.*;

/**
 * Created by Rustam on 09.10.16.
 */
public class СheckMatch {
    public String СheckMatchEmail(String email){
        String colum = "email";
        if(!checkMatch(colum, email)){
            return "";
        }
        else {
            return "Email occupied.";
        }
    }

    public String СheckMatchLogin(String login){
        String colum = "login";
        if(!checkMatch(colum, login)){
            return "";
        }
        else {
            return "Login occupied.";
        }
    }


    private boolean checkMatch(String colum, String value){
        String url = "jdbc:postgresql://localhost/users?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;
        boolean isExist = false;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "SELECT " +  colum + " from users";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getString(colum).equals(value)){
                    isExist = true;
                    break;
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isExist;

    }


    public boolean checkMatchLogIn(String loginCheck, String passwordCheck){
        String url = "jdbc:postgresql://localhost/users?characterEncoding=utf8";
        String name = "rustam_admin";
        String password = "123321";
        Connection conn;
        Statement stmt;
        boolean isExist = false;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, name, password);
            stmt = conn.createStatement();
            String query = "SELECT login, password from users";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(rs.getString("login").equals(loginCheck)){
                    if(rs.getString("password").equals(passwordCheck))
                    isExist = true;
                    break;
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isExist;

    }
}
