package in.reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class register extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name1");
        String email = req.getParameter("email1");
        String pass = req.getParameter("pass1");
        String gender = req.getParameter("gender1");
        String city = req.getParameter("city1");
        PrintWriter out=resp.getWriter();
        out.write(gender);
        out.write(city);
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "123213Abhi@");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into users values(?,?,?,?,?)");
			System.out.print("database conntect");
	
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, pass);
			preparedStatement.setString(4, gender);
			preparedStatement.setString(5, city);
			int count= preparedStatement.executeUpdate();
			
			if(count> 0)
			{
				System.out.println("inserted"); 
				resp.setContentType("text/html");
				out.print("<h2 style='color:green'> users register successfully</h2>");
				RequestDispatcher erDispatcher=req.getRequestDispatcher("/index.jsp");
				erDispatcher.include(req, resp);
			}
			else {
				System.out.println("value is not inserted");
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> users not register successfully</h3>");
				RequestDispatcher erDispatcher=req.getRequestDispatcher("/index.jsp");
				erDispatcher.include(req, resp);
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'> users not register successfully</h3>");
			RequestDispatcher erDispatcher=req.getRequestDispatcher("/index.jsp");
			erDispatcher.include(req, resp);
		}
        
	}

}