

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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


//        SearchDate searchDate = new SearchDate();
//        boolean check  = searchDate.searchDate(req.getParameter("login"), req.getParameter("password"));
//        System.out.println(check);
//
//        out.println(getPageCode(req.getParameter("login") + " " + check));
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