import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.sound.midi.Track;

public class servidor {

    public static void main(String[] args) {
        int puerto=5000;
        try {
            //Crear un objeto socket
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println( "Servidor esperando conexiones......");
            
            while(true){
            // Crear arreglo de bytes para recibir los datos del cliente
            byte[] bufferEntrada= new byte[1024];
            //crear objeto datagram para recibir los datos
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length );
            
            //recibir el paquete
            socket.receive(paqueteEntrada);
///////////////////////////////////////////////////////////////////////////////////////////////

            Thread HiloCliente = new HiloCliente(socket, paqueteEntrada);
            HiloCliente.start();
            }
            //String mensajeRecibido = new String(paqueteEntrada.getData());
            //System.out.println("Mensaje es:"+mensajeRecibido);


            //InetAddress direccionIp_Clientes = paqueteEntrada.getAddress();
            //int puerto_cliente=paqueteEntrada.getPort();

            //String mensajeSalida = "Hola soy el servidor";
            //byte[] bufferSalida = mensajeSalida.getBytes();

            //DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_Clientes,puerto_cliente);
            //socket.send(paqueteSalida);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            
        }
    }
}