import java.io.*;
import javax.servlet.http.*;  
import javax.servlet.*;  



public class p4 extends HttpServlet{
    public void init()
    {

    }
    public void doGet(HttpServletRequest req,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        String box=req.getParameter("text_box");
        
        PrintWriter out=response.getWriter();
        out.println("<form action=\"3rdpage\" method=\"get\"><input name=\'hid\' value=\'"+box+"\' type=\'hidden\'><input type=\"submit\"></form>");
    }
    public void destroy(){
        //do nothing
    }
}