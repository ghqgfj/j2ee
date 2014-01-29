package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForm
 */
public class ServletForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForm() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
       Cookie c=new Cookie("ServletForm","Add One Cookie");
       response.addCookie(c);
       PrintWriter out=response.getWriter();
       for(int i=0;i<request.getParameterValues("maths").length;i++)
       {out.println(request.getParameterValues("maths")[i]);}
       rd.include(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Reading Checkbox Data";
        String docType =
        "<!doctype html public \"-//w3c//dtd html 4.0 " +
        "transitional//en\">\n";
        out.println(request.getRemoteAddr());
        
        out.println(docType +
                  "<html>\n" +
                  "<head><title>" + title + "</title></head>\n" +
                  "<body bgcolor=\"#f0f0f0\">\n" +
                  "<h1 align=\"center\">" + title + "</h1>\n" +
                  "<ul>\n" +
                  "  <li><b>Maths Flag : </b>: "
                  + request.getParameter("maths") + "\n" +
                  "  <li><b>Physics Flag: </b>: "
                  + request.getParameter("physics") + "\n" +
                  "  <li><b>Chemistry Flag: </b>: "
                  + request.getParameter("chemistry") + "\n" +
                  "</ul>\n");
        out.println("<table><tr bgcolor=\"#949494\"><th>Attribute Name</th><th>Attribute Value(s)</th></tr>");
        Enumeration attritue = request.getAttributeNames();
        while(attritue.hasMoreElements()) {
           String paramName = (String)attritue.nextElement();
           out.print("<tr><td>" + paramName + "</td>\n");
           String paramValue = request.getAttribute(paramName).toString();
           out.println("<td> " + paramValue + "</td></tr>\n");
        }
        out.println("<table><tr bgcolor=\"#949494\"><th>Parameter Name</th><th>Parameter Value(s)</th></tr>");
        Enumeration parameter = request.getParameterNames();
       
        while(parameter.hasMoreElements()) {
           String paramName = (String)parameter.nextElement();
           out.print("<tr><td>" + paramName + "</td>\n");
           String paramValue = request.getParameter(paramName);
           out.println("<td> " + paramValue + "</td></tr>\n");
        }
        out.println("</table>");
        out.println("</body></html>");
    }

}
