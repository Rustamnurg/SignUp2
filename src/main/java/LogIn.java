


import DateCore.Users.RequestsToDb.SearchDate;
import DateCore.Users.MainDataProcessor;
import Essence.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rustam on 30.09.16.
 */
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if ((session.getAttribute("login") == null)) {
            req.getRequestDispatcher("/LogIn.jsp").forward(req, resp);
        }
        else{
            resp.sendRedirect("/mainPage");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("do post");

        if ((session.getAttribute("login") != null)) {
            req.getRequestDispatcher("/mainPage").forward(req, resp);
        }
        else {


            resp.setContentType("text/html;charset=UTF-8");
            resp.setStatus(200);
            PrintWriter out = resp.getWriter();

            MainDataProcessor mainDataProcessor = new MainDataProcessor();

            String result = "";

            result = mainDataProcessor.dateProcessorLogIn(req.getParameter("login"), req.getParameter("password"));

            if (result.equals("")) {
                resp.setStatus(302);

                SearchDate searchDate = new SearchDate();
                User user = searchDate.searchData(req.getParameter("login"), req.getParameter("password"));

                session.setAttribute("idUsers", user.getId());
                session.setAttribute("firstName", user.getFirstName());
                session.setAttribute("lastname", user.getLastName());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("login", user.getLogin());
                session.setAttribute("password", user.getPassword());
                session.setAttribute("country", user.getCountry());
                session.setMaxInactiveInterval(500);
                resp.sendRedirect("/mainPage");


            } else {
                resp.setStatus(302);
                out.println(getPageCode(result + "<br />" + "<a href=\"javascript:history.back();\">Try agan</a>"));
            }
        }
    }



    protected String getPageCode(String content){
        return "<!DOCTYPE html><html>"
                + "<head><meta charset='UTF-8'>"
                +   "<title>Hello page</title>"
                + "</head>"
                + "<body>"
                + content
                + "</body>"
                + "</html>";

    }

}