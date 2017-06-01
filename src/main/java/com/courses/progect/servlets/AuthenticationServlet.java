package com.courses.progect.servlets;

import com.courses.progect.classes.MyConstans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static com.courses.progect.servlets.AddChat.chat;

/**
 * Created by Irina Petrova on 18.05.2017.
 */
@WebServlet("/Authentication")
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(MyConstans.USERNAME);
        String lastname = request.getParameter(MyConstans.LASTNAME);
        String full = username + "" + lastname;
        request.setAttribute(MyConstans.FULLNAME, full);
        Cookie ck = new Cookie(MyConstans.FULLNAME,full);
        Set setKey = chat.getChatters().keySet();
        request.setAttribute(MyConstans.CHATERS, setKey);
        response.addCookie(ck);
        request.getRequestDispatcher(MyConstans.CONVERSATION_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
