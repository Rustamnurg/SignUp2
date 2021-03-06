package Essence;

/**
 * Created by Rustam on 06.10.16.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private String passwordCheck;
    private String country;


    public User(String firstName, String lastName, String email, String login, String password, String passwordCheck, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.country = country;
    }
    public User(int id, String firstName, String lastName, String email, String login, String password, String passwordCheck, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.country = country;
    }
    public  User(){

    }

    public int getId()
    {
        return  id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public String getCountry() {
        return country;
    }


    public void setId(int id){
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
