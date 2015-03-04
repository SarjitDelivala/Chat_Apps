/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author SARJIT
 */
public class ServerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ServerSocket server;
        Socket serverSocket = null;
        try
        {
            server = new ServerSocket(12345);
            System.out.println("Waiting for Client to join : ");
            serverSocket = server.accept();
            OutputStream out = serverSocket.getOutputStream();
            String str = " ";
            OutputStreamWriter outWrite = new OutputStreamWriter(out);
            Scanner scr = new Scanner(System.in);
            System.out.println("Start sending message : ");
            while(true)
            {
                str = scr.nextLine();

                if(!str.equals(""))
                {
                    outWrite.write(str);
                    outWrite.flush();
                }
                
                if(str.equalsIgnoreCase("Exit"))
                    break;
            }
            outWrite.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        
        
    }
    
}
