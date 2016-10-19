package DateCore.Users;


import DateCore.Users.RequestsToDb.AddDb;
import DateCore.Users.RequestsToDb.СheckMatch;
import Essence.*;

import java.sql.SQLException;

/**
 * Created by Rustam on 08.10.16.
 */
public class MainDataProcessor {
    CheckDate checkDate = new CheckDate();
    AddDb addDb = new AddDb();
    СheckMatch сheckMatch = new СheckMatch();


    public String dateProcessorRegestrarion(String firstName, String lastName, String email, String login,
                                            String passwordFirst, String passwordSecond, String country) throws SQLException {

        User user = new User(firstName, lastName, email, login, passwordFirst, passwordSecond, country);
        String errorStatus;

        errorStatus = checkDate.check(user);
        if (!errorStatus.equals("")) {
            return errorStatus;
        } else {
            if (!((errorStatus += сheckMatch.СheckMatchEmail(user.getEmail()) +
                    сheckMatch.СheckMatchLogin(user.getLogin())).equals(""))) {
                return errorStatus;
            } else {
                if (!(errorStatus = addDb.add(user)).equals("")) {
                    return errorStatus;
                }
                return errorStatus;
            }
        }
    }

    public String dateProcessorLogIn(String login, String password) {
        UserLogIn userLogIn = new UserLogIn();
        userLogIn.setLogin(login);
        userLogIn.setPassword(password);
        String errorStatus;
        User user = new User();

        errorStatus = checkDate.checkLogIn(userLogIn);

        if (!errorStatus.equals("")) {
            return errorStatus;
        }
//        else if(!(сheckMatch.checkMatchLogIn(userLogIn.getLogin(),userLogIn.getPassword()))){
//            return "Wrong email or password";
//        }
        else if(!(сheckMatch.checkMatchLogIn(userLogIn.getLogin(),userLogIn.getPassword()))){
            return "Wrong email or password";
        }
            else {
            return  errorStatus;
        }





    }
}


