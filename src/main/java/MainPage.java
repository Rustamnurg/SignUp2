import Functional.Weather.GetWeather;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Rustam on 11.10.16.
 */
public class MainPage extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GetWeather getWeather = new GetWeather();
        System.out.println(getWeather.getWeather("Kazan"));
        System.out.println("ASSASA");
        if(session.getAttribute("login") == null){
            req.getRequestDispatcher("/").forward(req, resp);
        }
        else {

            req.setAttribute("Message", session.getAttribute("firstName"));

            req.getRequestDispatcher("/MainPage.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}
