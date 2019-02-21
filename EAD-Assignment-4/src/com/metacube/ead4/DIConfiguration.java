package com.metacube.ead4;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {
    
    // Create Object of EmailService with autoWire 
    @Bean
    public EmailService email( String message,String receiver) {
        return new EmailService(message,receiver);
    }
    
    // create bean of message
    @Bean
    public String message(){
        return "Email-msg";
    }
    
    //create bean of receiver
    @Bean
    public String receiver(){
        return "Email-Receiver";
    }
    
    
    

}
