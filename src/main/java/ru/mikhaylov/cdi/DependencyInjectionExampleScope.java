package ru.mikhaylov.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/diExampleScope")
public class DependencyInjectionExampleScope extends HttpServlet {
    @Inject
    MyBean myBean;

    @Inject
    ChangeMyBean changeMyBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        myBean.setI(5);
        changeMyBean.change();
        System.out.println(myBean.getI() + " ");
        System.out.println(changeMyBean.myBean.getI() + " ");
        RequestDispatcher view = req.getRequestDispatcher("/jsp/exampleBean.jsp");
        view.forward(req,resp);
    }
}

//scope
//@ApplicationScoped
//@SessionScoped
//@RequestScoped аналог singleton
//@ConversationScoped
//@Dependent аналог prototype в spring
//@Dependent
@RequestScoped
@Named("newBean")
class MyBean{
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
class ChangeMyBean{
    @Inject
    MyBean myBean;

    public void change(){
        myBean.setI(3);
    }
}
