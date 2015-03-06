/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatfullduplex;

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
        // TODO code application logic here
        ServerSocket server;
        String str;
        Socket socket;
        Scanner scr = new Scanner(System.in);
        ChatThread receiver;
        try
        {
            server = new ServerSocket(12345);
            
            System.out.println("Waiting for client...");
            
            socket = server.accept();
            
            OutputStreamWriter send = new OutputStreamWriter(socket.getOutputStream());
            
            receiver = new ChatThread(new InputStreamReader(socket.getInputStream()));
            
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
