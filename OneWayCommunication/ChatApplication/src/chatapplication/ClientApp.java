/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SARJIT
 */
public class ClientApp {
    public static void main(String args[])
    {
        Socket client;
        char[] cbuf;
        try
        {
            client = new Socket(InetAddress.getLocalHost(), 12345);
            
            System.out.println("Connected to server ");
            
            InputStreamReader reader = new InputStreamReader(client.getInputStream());
            
            while(true){
                
                cbuf = new char[100];
                reader.read(cbuf);
                
                    
                    System.out.println( new String(cbuf).trim());
                    
                
                if(new String(cbuf).trim().equalsIgnoreCase("Exit"))
                        break;
                
                
            }
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        
    }
}
