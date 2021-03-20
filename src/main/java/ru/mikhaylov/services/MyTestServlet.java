package ru.mikhaylov.services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/hi")
public class MyTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String one = req.getParameter("one");
        String respan = "<html><body>Hello Anton "+one+
                "<form action = 'hello' method = 'post'> <textarea name=one></textarea>" +
                "<input type=submit name=submit /></form></body></html>";
        resp.getWriter().write(respan);
        Enumeration<String> list = req.getHeaderNames();
        list.asIterator().forEachRemaining(f -> System.out.println(f+"="+req.getHeader(f)));
        System.out.println(req.getCookies());
        System.out.println(req.getContentType());
//        if (req.getHeader("accept-encoding").contains("gzip")) {
//            new PrintWriter(new GZIPOutputStream(resp.getOutputStream())).write(respan);
//
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
