package ru.mikhaylov.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.interceptor.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/diExampleLive")
public class DependencyInjectionExampleLive extends HttpServlet {
    @Inject
    LiveCycleBean liveCycleBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        liveCycleBean.doJob1();
        liveCycleBean.doJob2();
    }
}
class InterceptorOne {
    @AroundConstruct
    private Object AroundConstruct(InvocationContext context) throws Exception{
        System.out.println("before construct");
        return context.proceed();
    }
    @PostConstruct
    private void postConstruct(InvocationContext context) throws Exception {
        context.proceed();
        System.out.println("Post Construct");
    }

    @AroundInvoke
    private Object AroundMethod(InvocationContext context) throws Exception{
        System.out.println("before method");
        return context.proceed();
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("Destroy method");
    }

}

class InterceptorTwo {
    @AroundInvoke
    private Object AroundMethod(InvocationContext context) throws Exception{
        System.out.println("before method Two");
        return context.proceed();
    }
}

@Three
@Interceptor
class InterceptorThree {
    @AroundInvoke
    private Object AroundMethod(InvocationContext context) throws Exception{
        System.out.println("before method Three");
        return context.proceed();
    }
}

@RequestScoped
@Interceptors({InterceptorOne.class,InterceptorTwo.class})
class LiveCycleBean {

    public LiveCycleBean() {
        System.out.println("Constructor");
    }

    @Three
    public void doJob1(){
        System.out.println("do Job1");
    }

    @ExcludeClassInterceptors
    public void doJob2(){
        System.out.println("do Job2");
    }
}


@InterceptorBinding
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
@interface Three{ }

