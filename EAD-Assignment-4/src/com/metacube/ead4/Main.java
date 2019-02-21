package com.metacube.ead4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    
    
public static void main(String[] args) {
        
     
        ApplicationContext factory = new ClassPathXmlApplicationContext("MyXMLApplication.xml");
//        create object of Twitter using XML without annotation and wiring
        TwitterService twitter =  (TwitterService) factory.getBean("twitter");
        twitter.sendMessage("XML-Receiver","XML-msg");
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DIConfiguration.class);
//      create object of Email Service using JAVA with  Spring annotations for auto-wiring
        EmailService email = (EmailService) ctx.getBean("email");
        email.sendMessage("abc","HI");   
        
    }

}
