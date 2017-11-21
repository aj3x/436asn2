/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi;

import java.rmi.*;
import java.util.Scanner;

/**
 *
 * @author aj3x
 */
public class JavaRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //System.setSecurityManager(new RMISecurityManager());
            
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Your name and press Enter:");
            String name = s.nextLine().trim();
            
            Chat server = new Chat(name);	
            Naming.rebind("rmi://localhost/", server);

            System.out.println("[System] Chat Remote Object is ready:");

            while(true){
                String msg = s.nextLine().trim();
                if (server.getClient()!=null){
                    ChatInterface client=server.getClient();
                    msg="["+server.getName()+"] "+msg;
                    client.send(msg);
                }	
            }

    	}catch (Exception e) {
            System.out.println("[System] Server failed: " + e);
    	}
    }
}
