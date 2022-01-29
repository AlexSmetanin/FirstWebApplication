import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LibraryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_ee_db",
                    "root", "!QAZxsw2");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT title FROM books");
            while (rs.next())
                pw.println(rs.getString("title"));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
