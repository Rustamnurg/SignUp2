package DateUsers;

import User.User;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Rustam on 06.10.16.
 */
public class SaveDate {
    public boolean add(User obj){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
        {
            oos.writeObject(obj);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        return  true;
    }
}
