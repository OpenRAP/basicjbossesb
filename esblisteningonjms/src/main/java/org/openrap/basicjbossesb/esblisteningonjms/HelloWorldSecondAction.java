package org.openrap.basicjbossesb.esblisteningonjms;

import java.util.Map;
import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Body;
import org.jboss.soa.esb.message.Message;

public class HelloWorldSecondAction extends AbstractActionLifecycle {
    
    private ConfigTree _configTree;

    public HelloWorldSecondAction(ConfigTree _configTree) {
        this._configTree = _configTree;
    }
    
    public Message noOperation(Message message) {
        return message;
    }
    
    public Message process(Message message) {
        
        Map responseMsg = (Map)message.getBody().get(Body.DEFAULT_LOCATION);
        System.out.println(message.toString());
        System.out.println("(2nd action) RESPONSE map is: " + responseMsg);
        
        return message;
    }
    
    public void exceptionHandler(Message message, Throwable exception) {
        
        System.out.println("====================================================");
        
        System.out.println("ERROR!");
        System.out.println(exception.getMessage());
        System.out.println("For Message: ");
        System.out.println(message.getBody().get());
        
        System.out.println("====================================================");
    }
}
