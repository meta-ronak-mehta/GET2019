package com.metacube.ead4;

public class TwitterService implements MessageService{

    /**
     * method to print message by his receiver name 
     * @param message to be send 
     * @param receiver address of receiver
     */
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println(message + " receive the "+ receiver +" at Twitter");        
    }

}
