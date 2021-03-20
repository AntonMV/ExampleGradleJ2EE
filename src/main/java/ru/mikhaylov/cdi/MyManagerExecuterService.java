package ru.mikhaylov.cdi;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/execService")
public class MyManagerExecuterService extends HttpServlet {

    @Resource
    ManagedExecutorService managedExecutorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        managedExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        managedExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        });
    }
}
