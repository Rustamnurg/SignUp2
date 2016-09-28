import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rustam on 25.09.16.
 */
public class Check {

    public String check(String[] arr  ){
        String result = "";

        if(!Pattern.compile("[a-zA-Zа-яА-я]{2,20}").matcher(arr[0]).matches()){
            result += "Wrong first name \n";

        }

        if(!Pattern.compile("[a-zA-Zа-яА-я]{2,20}").matcher(arr[1]).matches()){
            result += "Wrong last name\n";
        }

        if(!Pattern.compile("[a-zA-Z0-9]+@(([a-zA-Z0-9\\-]+\\.)([a-zA-Z0-9\\-])+)+").matcher(arr[2]).matches()){
            result += "Wrong email\n";

        }
        if(!Pattern.compile("[a-zA-Z0-9]{2,20}").matcher(arr[3]).matches()){
            result += "Wrong login\n";

        }
        if((!arr[4].equals(arr[5]) || !Pattern.compile("[a-zA-Z0-9]{4,20}").matcher(arr[4]).matches())) {
            result += "Wrong password\n";
        }

        if(arr[6].equals("No")){
            result += "Wrong country\n";
        }
        return result;
    }

}
