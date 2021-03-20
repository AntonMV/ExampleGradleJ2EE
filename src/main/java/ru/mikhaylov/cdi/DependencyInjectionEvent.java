package ru.mikhaylov.cdi;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Singleton;
import javax.interceptor.InterceptorBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@WebServlet("/diExampleEvent")
public class DependencyInjectionEvent extends HttpServlet {
    @Inject
    BookService bookService;

    @Inject
    Subscriber subscriber;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book("Tom");
        bookService.addBook(book);
        System.out.println(subscriber.list.size());
        bookService.addBook(new Book("Don"));
        bookService.removeBook(book);
        System.out.println(subscriber.list.size());
    }
}

@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
@interface Add{ }

@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
@interface Remove{ }

class Book {
    String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BookService{
    @Inject
    @Remove
    Event<Book> removeEvent;

    @Inject
    @Add
    Event<Book> addEvent;

    public void addBook(Book book){
        System.out.println(book.getName() + " book is added");
        addEvent.fire(book);
    }

    public void removeBook(Book book){
        System.out.println(book.getName() + " book is remove");
        removeEvent.fire(book);
    }
}
@Singleton
class Subscriber{

    List<Book> list = new ArrayList<>();

    public void addBook(@Observes @Add Book book){
        System.out.println(book.getName() + "book add to List");
        list.add(book);
    }

    public void removeBook(@Observes @Remove Book book){
        System.out.println(book.getName() + "book remove to List");
        list.remove(book);
    }
}
