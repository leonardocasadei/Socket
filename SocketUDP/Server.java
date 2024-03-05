import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server{
    public static void main(String[] args) throws IOException{
        int porta=6789;
        DatagramSocket serverSocket = new DatagramSocket(porta);


        byte[] bufferIN = new byte[1024];
        byte[] bufferOUT = new byte[1024];

        DatagramPacket receivePacket=new DatagramPacket(bufferIN, bufferIN.length);
        serverSocket.receive(receivePacket);

        String ricevuto=new String(receivePacket.getData());
        System.out.println("RICEVUTO: " + ricevuto);
        

        String risposta="PACCHETTO RICEVUTO DAL SERVER";
        bufferOUT = risposta.getBytes();

        InetAddress IPClient= receivePacket.getAddress();
        int portaClient=receivePacket.getPort();

        DatagramPacket sendPacket=new DatagramPacket(bufferOUT, bufferOUT.length, IPClient, portaClient);

        serverSocket.send(sendPacket);



        serverSocket.close();
    }
}