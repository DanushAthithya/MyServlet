import java.io.*;
import javax.servlet.http.*;  
import javax.servlet.*;  

class Obj{
    public int regnum;
    public String name;
    public int rank;
    public void setData(int reg,String na,int ra)
    {
        regnum=reg;
        name=na;
        rank=ra;
    }
}

public class p2 extends HttpServlet{
    public Obj[] obj=new Obj[4];
    private int ran;
    private String nam;
    public void init()
    {
        obj[0]=new Obj();
        obj[1]=new Obj();
        obj[2]=new Obj();
        obj[0].setData(1, "Danush", 1);
        obj[1].setData(2, "Athithya", 5);
        obj[2].setData(3, "DARK", 6);
    }
    public void doGet(HttpServletRequest req,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html");
        int reg=Integer.parseInt(req.getParameter("regnum"));
        for(int i=0;i<3;i++)
        {
            if(obj[i].regnum==reg){
                nam=obj[i].name;
                ran=obj[i].rank;
                break;
            }
        }
        PrintWriter out=response.getWriter();
        out.println("<h3>Name:"+nam+"</h3><br><h3>Rank:"+ran+"</h3>");
    }
    public void destroy(){
        //do nothing
    }
}
