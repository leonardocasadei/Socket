import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket){
        super();
        this.clientSocket=clientSocket;
    }


    public void run(){
        try{
            PrintWriter out=new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    
            
            while(true){
                String stringaRicevuta=in.readLine();
                System.out.println("STRINGA RICEVUTA: " + stringaRicevuta);
        
                try{
                    Thread.sleep(4000);
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
        
                String stringaTrasformata=stringaRicevuta.toUpperCase();
                    
                out.println(stringaTrasformata);
            }

            
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
}
