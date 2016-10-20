

import Essence.Testing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rustam on 22.09.16.
 */

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");
        resp.setStatus(200);
        out.println(getPageCode());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.println(getPageCode());


    }


    protected String getPageCode(){
        return "<a href='/registrarion'>Registration</a><br/>"
                + "<a href='/LogIn'>Log in</a>";

    }
}
