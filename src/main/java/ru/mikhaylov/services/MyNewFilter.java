package ru.mikhaylov.services;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(value = "/ServletFilter", initParams = {@WebInitParam(name ="name", value = "Max")})
public class MyNewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getInitParameter("name"));
        System.out.println("Init filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().write("before");
        if (true){
            //chain.doFilter(request, new MyResponseWraper((HttpServletResponseWrapper) response));
            chain.doFilter(request,response);
        }
        response.getWriter().write("after");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy filter");
    }
}

class MyResponseWraper extends HttpServletResponseWrapper {

    public MyResponseWraper(HttpServletResponseWrapper response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return super.getWriter();
    }
}
