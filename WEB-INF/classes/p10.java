import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class p10 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        int regn = Integer.parseInt(request.getParameter("RegNo"));
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //create a database connection using jdbc , port no used here is 3307
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root", "");
            stmt = conn.createStatement();
            String sql;
            //select data from table where dept matches the value given by user in form
            sql = "delete from marks  where RegNo=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, regn);
            pstmt.executeUpdate();
           
            //Display values
            out.println("<h2>Successully Deleted the records</h2>");
            // Clean-up environment
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}