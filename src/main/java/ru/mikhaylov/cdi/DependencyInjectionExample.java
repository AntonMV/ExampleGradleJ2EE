package ru.mikhaylov.cdi;


import ru.mikhaylov.model.*;

import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/diExample")
public class DependencyInjectionExample extends HttpServlet {

//    @Inject
//    @AnnotationStudent
//    Person person;
//
//
//    @Inject
//    @AnnotationWorker
//    Worker worker;
//
//    @Inject
//    public DependencyInjectionExample(Student student) {
//        this.student = student;
//    }
//
//    @Inject
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    @Inject
    Person person;

    @Inject
    String s;

    @Inject
    @S2
    String s2;

    @Inject
    int age;

    @Inject
    Car car;

    @Inject
    Logger logger;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Qualifier:");
        System.out.println(person.toString());
        System.out.printf(s + " " + s2 + " " + age + " " + car.getName()+ " ");
        resp.getWriter().write(car.getName());
        logger.log(Level.ALL, "message");
    }
}

