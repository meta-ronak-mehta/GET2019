package com.metacube.ead4;

public interface MessageService {

    /**
     * 
     * @param message to be send 
     * @param receiver address of receiver
     */
    public void sendMessage(String message, String receiver);
}
