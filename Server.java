/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;
import java.io.*;
import java.net.*;

/**
 *
 * @author Studenti
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int port=12345;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server in ascolto sulla porta  " + port);
        
        try{
            while(true){
                Socket clientSocket=serverSocket.accept();
                
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Ciao client!");
                clientSocket.close();
            }
        } finally{
            serverSocket.close();
        }
    }
}
   
