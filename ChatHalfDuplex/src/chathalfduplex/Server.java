/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chathalfduplex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author SARJIT
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket server;
        Socket socket;
        String str;
        char arr[];
        Scanner scr = new Scanner(System.in);
        try
        {
            server = new ServerSocket(12345);
            
            System.out.println("Waiting for a client.");
            socket = server.accept();
            
            System.out.println("Connected to client.");
            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
            
            InputStreamReader in = new InputStreamReader(socket.getInputStream());
            
            
            while(true)
            {
                System.out.println("Type a message to send..");
                str = scr.nextLine();
                
                out.write(str);
                out.flush();
                
                if(str.equalsIgnoreCase("Exit"))    break;
                
                System.out.println("Message Sent. Waiting for response...");
                arr = new char[200];
                
                in.read(arr);
                
                str = new String(arr);
                
                if(str.equalsIgnoreCase("Exit"))    break;
                
                System.out.println("Client : " + str.trim());
                
            }
            
            in.close();
            out.close();
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
}
