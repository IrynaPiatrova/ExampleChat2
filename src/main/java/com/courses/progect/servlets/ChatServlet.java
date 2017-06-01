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
import java.util.List;
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
        /*namechat = namechat.replaceAll("]", "");*/
       /* namechat = namechat.replaceAll("[", "");*/
        /*if (namechat.charAt(namechat.length() - 1) == ']') {
        }*/
        /*if (namechat.charAt(1) == '[') {
        }*/
        request.setAttribute("namechat", namechat);
        request.getRequestDispatcher("chatRoom.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String fullName = getCookieByName(MyConstans.FULLNAME, cookies);
        String message = request.getParameter(MyConstans.MESSAGE);
        if (message != null) {
            chat.getChat(namechat).add(new Message(fullName, message));
        }
        response.setContentType(MyConstans.CONTENTTYPE);
        response.setCharacterEncoding(MyConstans.UTF8);
        PrintWriter out = response.getWriter();
        writeChat(out, fullName, message);
    }

    private void writeChat(PrintWriter out, String fullName, String message) {
        List<Message> messageList = chat.getChat(namechat);
        /*messageList.forEach(messageL-> {*/
        for (Message messageL : messageList) {
            String userName = messageL.getUserName();
            System.out.println(userName + " " + fullName);
            if (fullName.equals(userName)) {
                out.println("<li class=\"right clearfix\">\n" +
                        "<span class=\"chat-img pull-right\">\n" +
                        "  <img src=\"http://placehold.it/50/FA6F57/fff&text=ME\" alt=\"User Avatar\" class=\"img-circle\" />\n");
            } else {
                out.println("<li class=\"left clearfix\"><span class=\"chat-img pull-left\">\n" +
                        "<img src=\"http://placehold.it/50/55C1E7/fff&text=U\" alt=\"User Avatar\" class=\"img-circle\" />\n");
            }
            out.println("  </span>  <div class=\"chat-body clearfix\">\n" +
                    "       <div class=\"header\">\n" +
                    "          <small class=\" text-muted\">\n");
            /*out.println("\t\t\t<span class=\"glyphicon glyphicon-time\"></span>");
            out.println("15 mins ago");*/
            out.println("</small>\n" +
                    "\t\t  <strong class=\"pull-right primary-font\">");
            out.println(messageL.getUserName());
            out.println("</strong>\n" +
                    "        </div>\n" +
                    "        <p>");
            out.println(messageL.getMessage());
            out.println("</p>\n" +
                    "     </div>\n" +
                    "</li>  ");
        }
        /*});*/
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
