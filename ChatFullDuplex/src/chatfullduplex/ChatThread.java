/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatfullduplex;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author SARJIT
 */
class ChatThread extends Thread
{
    String str;
    boolean flag;
    
    InputStreamReader read;

    public ChatThread(InputStreamReader r) {
        
        flag = true;
        read = r;
    }
    
    public void setFlag(boolean f)
    {
        flag = f;
    }
    
    public boolean getFlag()
    {
        return flag;
    }
    
    @Override
    public void run()
    {
        while(flag)
        {
            char arr[] = new char[200];
            
            try
            {
                read.read(arr);
                
                str = new String(arr);
                
                if(str.trim().equalsIgnoreCase("Exit")){
                    flag = false;
                    break;
                }
                
                System.out.println("Received : " + str);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
        }
    }
}