package com.metacube.ead4;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailService implements MessageService {

    private String message;
    private String receiver;
    
    /**
     * Constructor that assign value to  message and receiver by auto-wiring
     * @param message to be send (auto wired) 
     * @param receiver address of receiver (auto wired)
     */
    @Autowired
    public EmailService(String message ,String receiver) {
        super();
        this.message=message;
        this.receiver=receiver;
    }
    
    /**
     * method to print message by his receiver name 
     * @param message to be send 
     * @param receiver address of receiver 
     */
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println(getReceiver() + " receive the "+ getMessage() +" by Email service");      
    }

    /**
     * 
     * @return Message 
     */
    public String getMessage() {    return message;     }

    /**
     * 
     * @return Receiver Address
     */
    public String getReceiver() {   return receiver;    }


}
