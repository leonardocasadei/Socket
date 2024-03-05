import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception{
        int portaServer=6789;
        InetAddress IPServer=InetAddress.getByName("localhost");


        byte[] bufferIN = new byte[1024];
        byte[] bufferOUT = new byte[1024];

        String richiesta="DAMMI L'ORDINE";
        bufferOUT = richiesta.getBytes();

        DatagramSocket clientSocket=new DatagramSocket();

        DatagramPacket sendPacket=new DatagramPacket(bufferOUT, bufferOUT.length, IPServer, portaServer);
        clientSocket.send(sendPacket);



        DatagramPacket receivePacket=new DatagramPacket(bufferIN, bufferIN.length);
        clientSocket.receive(receivePacket);

        String risposta=new String(receivePacket.getData());
        System.out.println("RISPOSTA RICEVUTA DAL SERVER: " + risposta);



        clientSocket.close();

    }
}
