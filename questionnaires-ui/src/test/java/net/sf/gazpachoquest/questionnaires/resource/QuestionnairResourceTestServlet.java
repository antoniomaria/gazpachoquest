/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
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
