import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException{
        

        int numeroPorta=12345;
        ServerSocket serverSocket=new ServerSocket(numeroPorta);

        Socket clientSocket=serverSocket.accept();


        



        PrintWriter out=new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        System.out.println("RICHIESTA DAL CLIENT: " + in.readLine());


        String risposta="MESSAGGIO RICEVUTO";
        out.println(risposta);






        clientSocket.close();
        serverSocket.close();





    }
}
