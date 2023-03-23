import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class p9 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        String department = request.getParameter("Dept");
        int regn = Integer.parseInt(request.getParameter("RegNo"));
        Double cgp = Double.parseDouble(request.getParameter("CGPA"));
        String nam = request.getParameter("Name");
        String scho = request.getParameter("Scholarship");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //create a database connection using jdbc , port no used here is 3307
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root", "");
            stmt = conn.createStatement();
            String sql;
            //select data from table where dept matches the value given by user in form
            sql = "Insert into marks values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, regn);
            pstmt.setString(2, nam);
            pstmt.setString(3, department);
            pstmt.setDouble(4, cgp);
            pstmt.setString(5, scho);
            pstmt.executeUpdate();
           
            //Display values
            out.println("<h2>Successully Inserted the values</h2>");
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