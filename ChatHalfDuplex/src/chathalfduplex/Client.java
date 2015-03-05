/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chathalfduplex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author SARJIT
 */
public class Client {
    public static void main(String args[])
    {
        Socket client;
        Scanner scr = new Scanner(System.in);
        String str;
        char arr[];
        
        try
        {
            System.out.println("Connecting to server.");
            
            client = new Socket(InetAddress.getLocalHost(), 12345);
            
            System.out.println("Connected to server.");
            OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
            
            InputStreamReader in = new InputStreamReader(client.getInputStream());
            
            while(true)
            {
                System.out.println("Waiting for Server Message...");
                arr = new char[200];
                in.read(arr);
                
                str = new String(arr);
                
                if(str.trim().equalsIgnoreCase("Exit"))    break;
                
                System.out.println("Server : " + str.trim());
                
                System.out.println("\nType a message to send...");
                str = scr.nextLine();
                
                out.write(str);
                out.flush();
                
                System.out.print("Message Sent. ");
                
                if(str.trim().equalsIgnoreCase("Exit"))    break;
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
