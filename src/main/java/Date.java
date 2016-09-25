import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Rustam on 25.09.16.
 */
public class Date {
  public void save(String[] arr  ){

      try(Writer writer = new FileWriter("/Users/Rustam/Desktop/note.csv", true)){
          writer.append(arr[0] + ";");
          writer.append(arr[1] + ";");
          writer.append(arr[2] + ";");
          writer.append(arr[3] + ";");
          writer.append(arr[4] + ";");
          writer.append(arr[5] + ";");
          writer.append(arr[6] + '\n');
          writer.flush();

      } catch (IOException e) {
          e.printStackTrace();
      }

  }


}
