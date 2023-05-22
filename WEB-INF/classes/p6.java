import java.io.*;
import javax.servlet.http.*;  
import javax.servlet.*;  

class Objec{
    public String username;
    public String password;
    public void setData(String na,String ra)
    {
        username=na;
        password=ra;
    }
}

public class p6 extends HttpServlet{
    public Objec[] obj=new Objec[4];
    private String ran;
    private String nam;
    public int hit;
    public int j;
    public void init()
    {
        hit=0;
        obj[0]=new Objec();
        obj[1]=new Objec();
        obj[2]=new Objec();
        obj[0].setData("Danush", "1234");
        obj[1].setData("Athithya", "5678");
        obj[2].setData("DARK", "9012");
    }
    public void doGet(HttpServletRequest req,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        String user=req.getParameter("username");
        String pas=req.getParameter("pass");
        PrintWriter out=response.getWriter();
        hit++;
        j=0;
        for(int i=0;i<3;i++)
        {
            if(obj[i].username.equals(user) && obj[i].password.equals(pas))
            {
                j=1;
                out.println("<h3>Scolarship Application Requirements</h3>");
                out.println("<p>Marks requirements is above 75% in 12th</p>");
                out.println("<p>Should not have received scholarship from any other institutions</p>");
                out.println("<h3>Number of page visits:"+hit+"</h3>");
                break;
            }
            if(j==1)
            {
                out.println("<h3>Invalid Username and Password</h3>");
            }
        }
    }
    public void destroy(){
        //do nothing
    }
}