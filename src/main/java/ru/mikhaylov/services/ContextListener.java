package ru.mikhaylov.services;


//import javax.servlet.ServletContextAttributeListener;
//import javax.servlet.ServletContextListener;
//import javax.servlet.ServletRequestAttributeListener;
//import javax.servlet.ServletRequestListener;
//import javax.servlet.http.HttpSessionActivationListener;
//import javax.servlet.http.HttpSessionAttributeListener;
//import javax.servlet.http.HttpSessionBindingListener;
//import javax.servlet.http.HttpSessionListener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ContextListener implements ServletContextAttributeListener {


    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println(event.getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println(event.getName());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println(event.getName());
    }
}
