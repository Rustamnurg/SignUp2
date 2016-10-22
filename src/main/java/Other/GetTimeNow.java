package Other;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rustam on 22.10.16.
 */
public class GetTimeNow {
    public String getDate(){
        Date now = new Date();
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.format(now);
        return format.format(now);
    }
}
