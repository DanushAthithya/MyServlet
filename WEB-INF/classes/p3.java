import java.io.*;
import javax.servlet.http.*;  
import javax.servlet.*;  

class Obje{
    public int age;
    public String name;
    public long phn;
}

public class p3 extends HttpServlet{
    public Obje obj=new Obje();
    private String message;
    public void init()
    {
        obj.name="Danush Athithya";
        obj.age=20;
        obj.phn=988443961;
        message="";
    }
    public void doGet(HttpServletRequest req,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        String reg;
        reg=req.getParameter("Properties");
        if(reg.equals("Name")){
            message=obj.name;
        }
        else if(reg.equals("Age")){
            message=String.valueOf(obj.age);
        }
        else if(reg.equals("PHN"))
        {
            message=String.valueOf(obj.phn);
        }
        else{
            message=null;
        }
        PrintWriter out=response.getWriter();
        out.println("<h3>"+message+"</h3>");
    }
    public void destroy(){
        //do nothing
    }
}
