package Essence;

/**
 * Created by Rustam on 09.10.16.
 */
public class UserLogIn {
    private String login;
    private String password;

    public UserLogIn(String login, String password) {
        this.login = login;
        this.password = password;


    }
    public UserLogIn(){

    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }



    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
