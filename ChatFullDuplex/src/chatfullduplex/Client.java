/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatfullduplex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;



/**
 *
 * @author SARJIT
 */



public class Client {

    public static void main(String[] args)
    {
        Socket client;
        ChatThread receiver;
        String str;
        Scanner scr = new Scanner(System.in);
        try
        {
            client = new Socket(InetAddress.getLocalHost(), 12345);
            
            System.out.println("Connected to Server...");
            receiver = new ChatThread(new InputStreamReader(client.getInputStream()));
            
            OutputStreamWriter send = new OutputStreamWriter(client.getOutputStream());
            receiver.start();
            
            System.out.println("Start Sending messages... Send exit to exit");
            while(receiver.getFlag())
            {
                str = scr.nextLine();
                
                send.write(str);
                send.flush();
                
                if(str.trim().equalsIgnoreCase("Exit")){
                    receiver.setFlag(false);
                    break;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
