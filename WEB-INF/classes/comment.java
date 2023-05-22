import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
public class comment extends HttpServlet{
    public void init(){
        //do nothing
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        String comment = request.getParameter("text_box");
        String name = request.getParameter("movi");
        if(comment=="")
        {
            out.println("<h1>Nothing to save</h1>");
        }
        else
        {
           
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            //create a database connection using jdbc , port no used here is 3307
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root", "");
            stmt = conn.createStatement();
            String sql;
            //select data from table where dept matches the value given by user in form
            sql = "Insert into movie(name,comment) values(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, comment);
            
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
}
