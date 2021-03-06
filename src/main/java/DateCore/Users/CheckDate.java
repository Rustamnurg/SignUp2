package DateCore.Users;

import Essence.*;

import java.util.regex.Pattern;

/**
 * Created by Rustam on 06.10.16.
 */
public class CheckDate {
    public String check(User obj) {
        String result = "";

        if (!Pattern.compile("[a-zA-Zа-яА-я]{2,20}").matcher(obj.getFirstName()).matches()) {
            result += "Wrong first name.";

        }
        if (!Pattern.compile("[a-zA-Zа-яА-я]{2,20}").matcher(obj.getLastName()).matches()) {
            result += "Wrong last name.";
        }

        if (!Pattern.compile("[a-zA-Z0-9]+@(([a-zA-Z0-9\\-]+\\.)([a-zA-Z0-9\\-])+)+").matcher(obj.getEmail()).matches()) {
            result += "Wrong email.";

        }
        if (!Pattern.compile("[a-zA-Z0-9]{2,20}").matcher(obj.getLogin()).matches()) {
            result += "Wrong login.";

        }
        if ((!obj.getPasswordCheck().equals(obj.getPassword()) || !Pattern.compile("[a-zA-Z0-9]{4,20}").matcher(obj.getPassword()).matches())) {
            result += "Wrong password.";
        }

        if (obj.getCountry().equals("No")) {
            result += "Wrong country.";
        }
        return result;
    }

    public String checkLogIn(UserLogIn obj) {
        String result = "";


        if ((!Pattern.compile("[a-zA-Z0-9]{4,20}").matcher(obj.getPassword()).matches())) {
            result += "Invalid password format.";
        }

        if (!Pattern.compile("[a-zA-Z0-9]{2,20}").matcher(obj.getLogin()).matches()) {
            result += "Invalid login format.";

        }

        return result;
    }

}
