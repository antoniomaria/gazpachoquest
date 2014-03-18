package net.sf.gazpachoquest.questionnaires.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "testServlet", urlPatterns = { "/testServlet" })
public class MyRestClientTestServlet extends HttpServlet {

    @Inject
    @GazpachoClient
    private MyRestClient myRestClient;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Doing something with connection: " + myRestClient.getId());
        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>hey! " + myRestClient.getId() + "</title></head><body>hello!</body></html>");
        writer.close();
    }
}
