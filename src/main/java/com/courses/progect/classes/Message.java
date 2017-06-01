package com.courses.progect.classes;

/**
 * Created by Irina Petrova on 21.05.2017.
 */
public class Message {
    private String message;
    private String username;
    //private String date;

    public Message() {
    }

    public Message(String username, String message/*, String date*/) {
        this.message = message;
        this.username = username;
        //this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public String getUserName() {
        return username;
    }

    /*public String getDate() {
        return date;
    }*/

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*public void setDate(String date) {
        this.date = date;
    }*/
}