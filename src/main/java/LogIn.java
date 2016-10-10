

import DateUsers.MainDataProcessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Rustam on 30.09.16.
 */
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/LogIn.jsp").forward(req, resp);
       // PrintWriter out = resp.getWriter();
       // resp.setContentType("text/html;charset=UTF-8");
       // resp.setStatus(302);
      //  out.println(getPageCode());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();

        MainDataProcessor mainDataProcessor = new MainDataProcessor();

        String result = "";

        result = mainDataProcessor.dateProcessorLogIn(req.getParameter("login"), req.getParameter("password"));

        System.out.println(result);
        if (result.equals("")) {
            resp.setStatus(302);
            out.println(getPageCode("<p> all ok </p>"));
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