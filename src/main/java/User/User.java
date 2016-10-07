package User;

/**
 * Created by Rustam on 06.10.16.
 */
public class User {
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

}
