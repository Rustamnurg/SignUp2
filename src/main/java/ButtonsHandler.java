
import DateCore.Posts.AddPosts;
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
public class ButtonsHandler extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.sendRedirect("/mainPage");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Posts posts = new Posts();
        AddPosts addPosts = new AddPosts();
        HttpSession session = req.getSession();

        if(req.getParameter("add") != null) {
            posts.setId_author(Integer.parseInt(session.getAttribute("id").toString()));
            posts.setContent(req.getParameter("content"));
            addPosts.addPosts(posts);

        } else if (req.getParameter("Delete") != null) {
            System.out.println("Delete");

        }
        else if (req.getParameter("Edit") != null) {
        System.out.println("Edit");
        }
        else if (req.getParameter("Like") != null) {
        System.out.println("Like");
        }
        else{
            System.out.println("No(");
        }
        resp.sendRedirect("/mainPage");
    }



}




