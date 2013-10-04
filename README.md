basicjbossesb
=============

This is an example of 

1) A hornetq file that creates a queue queue/demoGateway
2) A very basic ESB client that publishes a message on a JMS queue : queue/demoGateway
3) A simple ESB that listens to the queue and performs an action org.openrap.basicjbossesb.esblisteningonjms.ESBAction


Steps to install
1) Download and install JBoss 6.x (not JBoss EAP)
2) Download JBoss ESB 4.x
3) Unpack and copy the file jbossesb-4.xx/deployment.properties-example to deployment.properties
4) Edit deployment.properties and set org.jboss.esb.server.home to your JBoss 6 Home
5) Run ant
6) Start JBoss 6.x via bin/run.(sh/bat)
7) Copy the file hornetq-jms.xml in the root of this repo to jboss/server/default/deploy
8) Edit basicbossesb/esblisteningonjms/pom.xml and point jboss.home to your JBoss home
9) cd basicbossesb/esblisteningonjms and run mvn package
10) Then run mvn jboss:hard-deploy
11) View JBoss logs outputed from the run.(sh/bat)
12) Open mvn "-Dexec.args=-classpath %classpath org.openrap.basicjbossesb.jmsclient.SendJMSMessage" -Dexec.executable=java  org.codehaus.mojo:exec-maven-plugin:1.2.1:exec
