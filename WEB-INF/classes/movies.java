import java.io.*;
import javax.servlet.http.*;

import javax.servlet.*;
class movie{
    String name;
    Double IMDB;
    String genre;
    public void setData(String nam,Double imd,String gen)
    {
        name=nam;
        IMDB=imd;
        genre=gen;
    }
}

public class movies extends HttpServlet{
    movie obj[]=new movie[3];
    public void init()
    {
        obj[0]=new movie();
        obj[0].setData("Pulp Fiction",8.8, "Dark Humor");
        obj[1]=new movie();
        obj[1].setData("Forrest Gump",9.2, "Drama");
        obj[2]=new movie();
        obj[2].setData("Django Unchained", 8.7, "Action Drama DarkHumor");
    }
    public void doGet(HttpServletRequest req,HttpServletResponse response)throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        out.println("<table><thead><th>MOVIE</th><th>IMDB</th><th>Genre</th><th>Comment</th><th>Submit</th></thead>");
        for(int i=0;i<3;i++)
        {
            out.println("<tr>");
            out.println("<form action=\"commen\" method=\"get\">");
            out.println("<td>"+obj[i].name+"</td>");
            out.println("<td>"+obj[i].IMDB+"</td>");
            out.println("<td>"+obj[i].genre+"</td>");
            out.println("<input type=\"hidden\" name=\"movi\" value=\""+obj[i].name+"\">");

            out.println("<td><textarea name=\"text_box\"></textarea></td>");
            out.println("<td><input type=\"submit\"></td>");
            out.println("</form>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
    public void destroy(){
    //do nothing
    }
}