package org.openrap.basicjbossesb.esblisteningonjms;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

public class ESBAction extends AbstractActionLifecycle {

    protected ConfigTree _config;

    public ESBAction(ConfigTree _configTree) {
        this._config = _configTree;
    }

    @org.jboss.soa.esb.actions.annotation.Process
    public Message runMe(Message message) {

        System.out.println("In the custom action class now...");
        System.out.println("Let's unpack the retrieved message [" + message.getBody().get().toString()+"]");
        return message;
    }
}
