

import DateCore.Users.MainDataProcessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Rustam on 25.09.16.
 */
public class
SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signUpPages.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        MainDataProcessor mainDataProcessor = new MainDataProcessor();


        String result = null;

        try {
            result = mainDataProcessor.dateProcessorRegestrarion(req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("email"),
                    req.getParameter("login"), req.getParameter("passwordFirst"), req.getParameter("passwordSecond"),
                    req.getParameter("country"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        PrintWriter out = resp.getWriter();
        if (result.equals("")) {
            resp.setStatus(302);
            //req.getRequestDispatcher("/LogIn.jsp").forward(req, resp);
           resp.sendRedirect("/LogIn");
        } else {
            resp.setStatus(302);
            out.println(getPageCode(result + "<br />" + "<a href=\"javascript:history.back();\">Try agan</a>"));
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

