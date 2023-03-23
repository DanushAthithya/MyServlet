import java.io.*;
import javax.servlet.http.*;  
import javax.servlet.*;  


public class p1 extends HttpServlet{
    private String message;
    public void init()
    {
        message="Success";
    }
    public void doGet(HttpServletRequest req,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>"+message+"</h1>");
    }
    public void destroy(){
        //do nothing
    }
}