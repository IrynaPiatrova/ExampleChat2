package com.courses.progect.classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Irina Petrova on 24.05.2017.
 */

public class Chat {
    /**
     * name - name of the room (chat)
     * chatters - Map to store Chatter objects
     */
    private String name;
    private Map<String, List<Message>> chatters = new HashMap<>();

    public Chat() {
    }

    /**
     * This constructor takes a name to create a new ChatRoom
     * @param name
     */
    public Chat(String name) {
        this.name = name;
    }

    /**
     * Returns name of the room
     * @return java.lang.String
     */
    public String getName() {
        return name;
    }

    /**
     * Set room name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * adds a Chat object to list of chatters
     * @return void
     */
    public void addChatter(List<Message> listmessage) {
        chatters.put(this.getName(), listmessage);
    }

    /**
     * returns a Chat object from chatters list.
     * @param chatName
     * @return List<Message>
     */
    public List<Message> getChat(String chatName) {
        return  chatters.get(chatName);
    }

    /**
     * @return java.util.Map chatters
     */
    public Map getChatters() {
        return chatters;
    }
}
