import DateCore.Posts.AddPosts;
import DateCore.Posts.GetAllPosts;
import Essence.Posts;
import Functional.Weather.GetWeather;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Rustam on 21.10.16.
 */
public class AddPostsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.sendRedirect("/mainPage");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Posts posts = new Posts();
        AddPosts addPosts = new AddPosts();
        HttpSession session = req.getSession();

        posts.setId_author(Integer.parseInt(session.getAttribute("id").toString()));
        System.out.println(session.getAttribute("id").toString());
        posts.setContent(req.getParameter("content"));
        addPosts.addPosts(posts);

        resp.sendRedirect("/mainPage");
    }

}




