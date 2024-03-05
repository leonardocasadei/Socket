import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        String hostname="localhost";
        int port=12345;


        Socket socket=new Socket(hostname, port);


        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        


        Scanner scanner = new Scanner(System.in);

    
        try{
            while(true){
                System.out.println("Inserisci un messaggio: ");
    
                String input = scanner.nextLine();
                    
    
                out.println(input);
                System.out.println("MESSAGGIO INVIATO AL SERVER");
    
    
    
                System.out.println("MESSAGGIO RICEVUTO DAL SERVER: " + in.readLine());
            }
            
        } finally{
            socket.close();
        }
        

    }
}
