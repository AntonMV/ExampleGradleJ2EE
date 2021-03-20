package ru.mikhaylov.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class MyTag extends SimpleTagSupport {

    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter jspWriter = getJspContext().getOut();
        jspWriter.print("hello world<br/>");
        jspWriter.print(name);
        getJspContext().setAttribute("one","number");
        StringWriter stringWriter = new StringWriter();
        getJspBody().invoke(stringWriter);
        jspWriter.print("<b>");
        jspWriter.print(stringWriter.toString());
        jspWriter.print("</b>");

    }


}
