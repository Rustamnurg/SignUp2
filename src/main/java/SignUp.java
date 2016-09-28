import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by Rustam on 25.09.16.
 */
public class SignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signUpPages.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //resp.setStatus(200);
        PrintWriter out = resp.getWriter();

        String[] arr = new String[7];
        arr[0] = req.getParameter("firstName");
        arr[1] = req.getParameter("lastName");
        arr[2] = req.getParameter("email");
        arr[3] = req.getParameter("login");
        arr[4] = req.getParameter("passwordFirst");
        arr[5] = req.getParameter("passwordSecond");
        arr[6] = req.getParameter("country");


        Check checkClass = new Check();
        String result;
        result = checkClass.check(arr);
        if(result.equals("")){
            resp.setStatus(302);
            Date date = new Date();
            date.save(arr);
            out.println(getPageCode("All ok"));

        }
        else{
            resp.setStatus(302);
            out.println(getPageCode(result + "<br />"+ "<a href=\"javascript:history.back();\">Try agan</a>"));
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
