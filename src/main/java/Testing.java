import DateCore.Likes.AddLikes;
import Essence.Likes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Rustam on 27.10.16.
 */

@WebServlet("/testing")
public class Testing extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Likes likes = new Likes(1, 1);
        AddLikes addLikes = new AddLikes();
        addLikes.addLikes(likes);

    }
}
