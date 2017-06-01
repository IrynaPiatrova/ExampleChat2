package com.courses.progect.servlets;

import com.courses.progect.classes.Chat;
import com.courses.progect.classes.Message;
import com.courses.progect.classes.MyConstans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Irina Petrova on 25.05.2017.
 */
@WebServlet("/addChat")
public class AddChat extends HttpServlet {
    public static Chat chat = new Chat();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter(MyConstans.FULLNAME_NAME);
        String nameChat = request.getParameter(MyConstans.NAMECHAT);
        chat.setName(nameChat);
        List<Message> listMessages = new ArrayList<>();
        chat.addChatter(listMessages);
        request.setAttribute(MyConstans.FULLNAME, name);
        request.setAttribute(MyConstans.CHATERS, chat.getChatters().keySet());
        request.getRequestDispatcher(MyConstans.CONVERSATION_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
