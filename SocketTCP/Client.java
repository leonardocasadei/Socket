import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        

        String hostname="localhost";
        int porta=12345;

        Socket clientSocket=new Socket(hostname, porta);




        PrintWriter out=new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Scanner scanner=new Scanner(System.in);
        System.out.print("FAI UNA RICHIESTA: ");
        String richiesta=scanner.nextLine();
        
        out.println(richiesta);


        System.out.println("RISPOSTA DAL SERVER: " + in.readLine());


        clientSocket.close();

    }
}
