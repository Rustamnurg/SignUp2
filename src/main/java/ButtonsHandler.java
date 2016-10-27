
import DateCore.Likes.AddLikes;
import DateCore.Likes.DeleteLikes;
import DateCore.Posts.AddPosts;
import DateCore.Posts.ChangePosts;
import DateCore.Posts.DeletePosts;
import Essence.Likes;
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


        String value = req.getParameter("paremeter");

        resp.sendRedirect("/mainPage");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Posts posts = new Posts();
        AddPosts addPosts = new AddPosts();
        HttpSession session = req.getSession();
        Likes likes;
        switch (req.getParameter("action")) {

            case ("Add"):
                posts.setId_author(Integer.parseInt(session.getAttribute("idUsers").toString()));
                posts.setContent(req.getParameter("content"));
                addPosts.addPosts(posts);
                System.out.println("add");
                break;
            case ("Delete"):
                DeletePosts deletePosts = new DeletePosts();
                deletePosts.deletePosts(Integer.parseInt(req.getParameter("idPosts")));
                System.out.println("del");
                break;
            case ("AddLikes"):
                AddLikes addLikes = new AddLikes();
                likes = new Likes(Integer.parseInt(req.getParameter("idPosts")),
                        Integer.parseInt(session.getAttribute("idUsers").toString()));
                addLikes.addLikes(likes);
                System.out.println("Like");
                break;
            case ("DeleteLikes"):
                DeleteLikes deleteLikes = new DeleteLikes();
                likes = new Likes(Integer.parseInt(req.getParameter("idPosts")),
                        Integer.parseInt(session.getAttribute("idUsers").toString()));
                deleteLikes.deleteLikes(likes);
                System.out.println("!Like");
                break;
            case ("Edit"):
                System.out.println("Edit");
                break;
            case ("EditSend"):
                System.out.println("ES");
                break;


        }
//        if(req.getParameter("add") != null) {
//            posts.setId_author(Integer.parseInt(session.getAttribute("id").toString()));
//            posts.setContent(req.getParameter("content"));
//            addPosts.addPosts(posts);
//        } else if (req.getParameter("Delete") != null) {
//            DeletePosts deletePosts = new DeletePosts();
//            deletePosts.deletePosts(Integer.parseInt(req.getParameter("idPosts")));
//        }
//        else if (req.getParameter("Edit") != null) {
//            req.getParameter("idPosts");
//          //  resp.
////            ChangePosts changePosts = new ChangePosts();
////            changePosts.changePosts()
//        }
//        else if (req.getParameter("Like") != null) {
//        System.out.println("Like");
//        }
//
//        else{
//            System.out.println("No(");
//        }

        resp.sendRedirect("/mainPage");
    }



}




