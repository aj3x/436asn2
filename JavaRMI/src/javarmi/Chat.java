/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi;

import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author aj3x
 */
public class Chat extends UnicastRemoteObject implements ChatInterface{

    public String name;
    public ChatInterface client = null;
    
    public Chat(String n) throws RemoteException{
        this.name = n;
    }
    
    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public void send(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public void setClient(ChatInterface c) throws RemoteException {
        this.client = c;
    }

    @Override
    public ChatInterface getClient() throws RemoteException {
        return this.client;
    }
    
}
