package org.openrap.basicjbossesb.esblisteningonjms;

import java.util.HashMap;
import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

public class HelloWorldFirstAction extends AbstractActionLifecycle {
    
    private ConfigTree _configTree;

    public HelloWorldFirstAction(ConfigTree _configTree) {
        this._configTree = _configTree;
    }    
    
    public Message noOperation(Message message) {
        return message;
    }
    
    public Message process(Message message) {
                
        String msgBody = (String)message.getBody().get();
        HashMap requestMap = new HashMap();
        requestMap.put("sayHello.toWhom", msgBody);
        message.getBody().add(requestMap);
        System.out.println("(1st action) REQUEST map is: " + requestMap.toString());
        
        return message;
    }
    
    public void exceptionHandler(Message message, Throwable exception) {
        
        System.out.println("====================================================");
        System.out.println("ERROR!");
        System.out.println(exception.getMessage());
        System.out.println("For message: ");
        System.out.println(message.getBody().get());
        System.out.println("====================================================");
    }
}
