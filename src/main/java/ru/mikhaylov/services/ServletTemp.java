package ru.mikhaylov.services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/temp")
public class ServletTemp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("ant","Mikhaylov");
        resp.addCookie(cookie);
        Cookie[] cookies = req.getCookies();
        for (Cookie c: cookies) {
            System.out.println(c.getName()+"="+c.getValue());
        }
    }
}
