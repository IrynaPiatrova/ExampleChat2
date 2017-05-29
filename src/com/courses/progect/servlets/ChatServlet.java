package com.courses.progect.servlets;

import com.courses.progect.classes.Message;
import com.courses.progect.classes.MyConstans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.courses.progect.servlets.AddChat.chat;

/**
 * Created by Irina Petrova on 18.05.2017.
 */
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    private String namechat;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        namechat = request.getParameter(MyConstans.NAMECHAT);
        if (namechat.charAt(namechat.length() - 1) == ']') {
            namechat = namechat.replaceAll("]", "");
        }
        request.setAttribute("namechat", namechat);
        request.getRequestDispatcher("chatRoom.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter(MyConstans.MESSAGE);
       // Cookie[] cookies = request.getCookies();
       // String fullname = getCookieByName(MyConstans.FULLNAME, cookies);
        chat.getChat(namechat).add(new Message("fullname", message));
        response.setContentType(MyConstans.CONTENTTYPE);
        response.setCharacterEncoding(MyConstans.UTF8);
        PrintWriter out = response.getWriter();
        out.println("<li class=\"right clearfix\">\n" +
                "<span class=\"chat-img pull-right\">\n" +
                "  <img src=\"http://placehold.it/50/FA6F57/fff&text=ME\" alt=\"User Avatar\" class=\"img-circle\" />\n" +
                "    </span>\n" +
                "    <div class=\"chat-body clearfix\">\n" +
                "       <div class=\"header\">\n" +
                "          <small class=\" text-muted\">\n" +
                "\t\t\t<span class=\"glyphicon glyphicon-time\"></span>");
        out.println("15 mins ago");
        out.println("</small>\n" +
                "\t\t  <strong class=\"pull-right primary-font\">");
        out.println("fullname");
        out.println("</strong>\n" +
                "        </div>\n" +
                "        <p>");
        out.println(message);
        out.println("</p>\n" +
                "     </div>\n" +
                "</li>  ");
    }

    private String getCookieByName(String cName, Cookie[] cookies) {

        Map<String, Cookie> cookieMap = new HashMap<>();
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie);
        }
        Cookie firstRequiredCookie = cookieMap.get(cName);
        return firstRequiredCookie.getValue();
    }
}
