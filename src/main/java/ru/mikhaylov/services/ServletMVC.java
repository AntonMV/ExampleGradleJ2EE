package ru.mikhaylov.services;

import ru.mikhaylov.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc")
public class ServletMVC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));

        Student student = new Student(name,age);

        req.setAttribute("stud", student);
        RequestDispatcher view = req.getRequestDispatcher("/view/about.jsp");
        view.forward(req,resp);
    }
}
