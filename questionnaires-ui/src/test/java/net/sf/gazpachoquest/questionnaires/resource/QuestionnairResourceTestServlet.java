package net.sf.gazpachoquest.questionnaires.resource;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;

@WebServlet(name = "testServlet", urlPatterns = { "/testServlet" })
public class QuestionnairResourceTestServlet extends HttpServlet {

    @Inject
    @GazpachoResource
    private QuestionnairResource questionnairResource;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Doing something with connection: ");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>hey! </title></head><body>hello!</body></html>");
        writer.close();
    }
}
