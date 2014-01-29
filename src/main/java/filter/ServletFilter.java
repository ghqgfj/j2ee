package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ServletFilter implements Filter {

    public void destroy() {
    
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
            ServletException {        
        if ("on".equals(request.getParameter("block"))) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.getWriter().write("Your Request has been blocked");
        } else {
            filterChain.doFilter(request, response);
        }

    }

    public void init(FilterConfig arg0) throws ServletException {

    }

}
