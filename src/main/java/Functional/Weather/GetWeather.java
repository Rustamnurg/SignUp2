package Functional.Weather;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Rustam on 10.10.16.
 */

public class GetWeather {
    public String getWeather(String city) {
        try {
            URL url = new URL("http://api.openweathermap.org:/data/2.5/weather?q=" + city + "ru&APPID=da81ff727e8de0aabd43796f8df4c8bb");
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            int c;
            String str ="";
            while ((c = in.read())!=-1){
                if(c == 34){
                    if(str.equals("temp")){
                        in.read();
                        str = "";
                        str += (char)in.read();
                        str += (char)in.read();
                        str += (char)in.read();
                        str += (char)in.read();
                        str += (char)in.read();
                        str += (char)in.read();
                        break;
                    }
                    str = "";

                }
                else {
                    str += (char) c;
                }


            }
            in.read();
            in.close();

            return  String.format("%.2f", Double.parseDouble(str) - 273.15);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}