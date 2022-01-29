import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;

        } else {
            count = count + 1;
        }
        session.setAttribute("count", count);

        // String name = request.getParameter("name");
        // String surname = request.getParameter("surname");

        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        // pw.println("<h1> Hello, " + name + " " + surname + "</h1>");
        pw.println("<h1> Your count is: " + count + "</h1>");
        pw.println("</html>");

        //response.sendRedirect("https://www.google.com");
        //response.sendRedirect("/testJSP.jsp");

        //RequestDispatcher dispatcher = request.getRequestDispatcher("/testJSP.jsp");
        //dispatcher.forward(request, response);

    }
}
