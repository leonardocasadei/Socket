import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException{
        int port = 12345; //PORTA DEL SERVER IN ASCOLTO
        ServerSocket serverSocket=new ServerSocket(port);
        System.out.println("SERVER IN ASCOLTO SULLA PORTA: " + port);

        try{
                
            while(true){
                Socket clientSocket = serverSocket.accept();

                ClientHandler clientHandler=new ClientHandler(clientSocket);
                clientHandler.start();
            }

    
        } finally{
            serverSocket.close();
        }
        
    }
}
